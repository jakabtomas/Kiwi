package eu.sk.jakab.kiwi.ui.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.List;

import eu.sk.jakab.kiwi.R;
import eu.sk.jakab.kiwi.network.model.Flight;
import eu.sk.jakab.kiwi.utils.GlideApp;

/**
 * Created by jakab on 7/29/2019.
 */
public class FlightsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_EMPTY = 0;
    private static final int TYPE_FLIGHT = 1;
    private static final int TYPE_LOADING = 2;

    private static DateTimeFormatter dateTimeFormat;
    private List<Flight> items;
    private String currency;

    public FlightsAdapter() {
        this.dateTimeFormat = DateTimeFormat.forPattern("dd/MM/yyyy");
    }

    @Override
    public int getItemViewType(int position) {
        if (items==null) {
            return TYPE_LOADING;
        }
        if (items.isEmpty()) {
            return TYPE_EMPTY;
        }
        return TYPE_FLIGHT;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        switch (viewType) {
            case TYPE_LOADING:
                return new EmptyViewHolder(inflater.inflate(R.layout.row_loading, parent, false));
            case TYPE_EMPTY:
                return new EmptyViewHolder(inflater.inflate(R.layout.row_flights_empty, parent, false));
            case TYPE_FLIGHT:
                return new FlightViewHolder(inflater.inflate(R.layout.row_flight, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case TYPE_FLIGHT:
                ((FlightViewHolder) holder).bind(items.get(position), currency);
                break;
        }
    }

    @Override
    public int getItemCount() {
        if (items==null || items.isEmpty()) {
            return 1;
        }
        return items.size();
    }

    public void addItems(List<Flight> flights, String currency) {
        if (this.items == null) {
            this.items = new ArrayList<>();
        }
        this.items.clear();
        this.items.addAll(flights);
        this.currency = currency;
        notifyDataSetChanged();
    }

    private static class EmptyViewHolder extends RecyclerView.ViewHolder {
        EmptyViewHolder(View view) {
            super(view);
        }
    }

    private static class FlightViewHolder extends RecyclerView.ViewHolder {
        private TextView txtFromShort, txtFromLong,txtFromDate, txtToShort,txtToLong,txtToDate,txtPrice;
        private ImageView imgAvatar;

        public FlightViewHolder(@NonNull View itemView) {
            super(itemView);
            txtFromShort = itemView.findViewById(R.id.txt_from_short);
            txtFromLong = itemView.findViewById(R.id.txt_from_long);
            txtFromDate = itemView.findViewById(R.id.txt_from_date);
            txtToShort = itemView.findViewById(R.id.txt_to_short);
            txtToLong = itemView.findViewById(R.id.txt_to_long);
            txtToDate = itemView.findViewById(R.id.txt_to_date);
            txtPrice = itemView.findViewById(R.id.txt_price);
            imgAvatar = itemView.findViewById(R.id.img_avatar);
        }

        public void bind(final Flight flight, String currency) {

            txtFromShort.setText(flight.getFlyFrom());
            txtFromLong.setText(flight.getCityFrom());
            txtFromDate.setText(dateTimeFormat.print(flight.getDepartureTime()));
            txtToShort.setText(flight.getFlyTo());
            txtToLong.setText(flight.getCityTo());
            txtToDate.setText(flight.getFlyDuration());
            txtPrice.setText(flight.getPrice()+" "+ currency);

            GlideApp.with(imgAvatar)
                    .load(imgAvatar.getContext().getString(R.string.img_url,flight.getMapIdto()))
                    .fitCenter()
                    .into(imgAvatar);
        }
    }
}
