package eu.sk.jakab.kiwi.base;

import android.app.Dialog;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import java.io.IOException;

import eu.sk.jakab.kiwi.R;
import retrofit2.HttpException;

/**
 * Created by jakab on 10/15/2018.
 */
public class BaseFragment<T extends BasePresenter> extends Fragment implements BaseView<T> {

    protected T presenter;
    private Dialog loadingDialog;

    @Override
    public void setPresenter(T presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showError(final Throwable e) {
        if (isAdded()) {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (e instanceof HttpException) {
                        HttpException httpException = (HttpException) e;
                        Toast.makeText(getContext(), String.valueOf(httpException.code()), Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getContext(), R.string.oops_something_went_wrong, Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.subscribe();
    }

    @Override
    public void onPause() {
        presenter.unsubscribe();
        super.onPause();
        hideLoadingDialog();
    }

    protected void hideKeyboard(View view) {
        InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    protected void showKeyboard() {
        InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
    }

    public T getPresenter() {
        return presenter;
    }

    public void showLoadingDialog() {
        if (isAdded() && getActivity() != null) {
            if (loadingDialog == null) {
                loadingDialog = new Dialog(getActivity());
                loadingDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                loadingDialog.setCancelable(false);
                loadingDialog.setContentView(R.layout.dialog_loading);
                loadingDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                loadingDialog.show();
            }
        }
    }

    public void hideLoadingDialog() {
        if (isAdded() && getActivity() != null) {
            if (loadingDialog != null && loadingDialog.isShowing()) {
                loadingDialog.dismiss();
                loadingDialog = null;
            }
        }
    }

    @Override
    public void showToast(final int stringResourceId) {
        if (isAdded()) {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getContext(), stringResourceId, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    /**
     * Gson TypeAdapter for Joda DateTime type
     */
    public static class DateTimeTypeAdapter extends TypeAdapter<DateTime> {

        private final DateTimeFormatter parseFormatter = ISODateTimeFormat.dateOptionalTimeParser();
        private final DateTimeFormatter printFormatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SS'Z'");

        @Override
        public void write(JsonWriter out, DateTime date) throws IOException {
            if (date == null) {
                out.nullValue();
            } else {
                out.value(printFormatter.print(date));
            }
        }

        @Override
        public DateTime read(JsonReader in) throws IOException {
            switch (in.peek()) {
                case NULL:
                    in.nextNull();
                    return null;
                default:
                    String date = in.nextString();
                    return parseFormatter.parseDateTime(date);
            }
        }
    }

    /**
     * Gson TypeAdapter for Joda LocalDate type
     */
    public static class LocalDateTypeAdapter extends TypeAdapter<LocalDate> {

        private final DateTimeFormatter formatter = ISODateTimeFormat.date();

        @Override
        public void write(JsonWriter out, LocalDate date) throws IOException {
            if (date == null) {
                out.nullValue();
            } else {
                out.value(formatter.print(date));
            }
        }

        @Override
        public LocalDate read(JsonReader in) throws IOException {
            switch (in.peek()) {
                case NULL:
                    in.nextNull();
                    return null;
                default:
                    String date = in.nextString();
                    return formatter.parseLocalDate(date);
            }
        }
    }
}
