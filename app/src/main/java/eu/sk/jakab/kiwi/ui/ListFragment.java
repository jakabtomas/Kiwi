package eu.sk.jakab.kiwi.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import eu.sk.jakab.kiwi.R;
import eu.sk.jakab.kiwi.base.BaseFragment;
import eu.sk.jakab.kiwi.network.model.Flight;
import eu.sk.jakab.kiwi.network.model.FlightSearchResult;
import eu.sk.jakab.kiwi.ui.adapters.FlightsAdapter;

/**
 * Created by jakab on 7/29/2019.
 */
public class ListFragment extends BaseFragment<Contracts.ListPresenter> implements Contracts.ListView {
    private MainActivityInterface callback;
    private FlightsAdapter adapter;

    public static ListFragment newInstance() {
        return new ListFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivityInterface) {
            callback = (MainActivityInterface) context;
        } else {
            throw new IllegalArgumentException(context + " should implement " + MainActivityInterface.class.getSimpleName());
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(getContext());
        mLinearLayoutManager.setSmoothScrollbarEnabled(true);
        recyclerView.setLayoutManager(mLinearLayoutManager);

        //adapter
        adapter = new FlightsAdapter();
        recyclerView.setAdapter(adapter);

        return  view;
    }

    @Override
    public void showData(FlightSearchResult flightSearchResult) {
        if (flightSearchResult!=null) {
            adapter.addItems(flightSearchResult.getData(), flightSearchResult.getCurrency());
        }
    }
}
