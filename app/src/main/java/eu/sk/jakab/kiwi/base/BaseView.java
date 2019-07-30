package eu.sk.jakab.kiwi.base;

import android.support.annotation.StringRes;

/**
 * Created by jakab on 10/15/2018.
 */
public interface BaseView<T extends BasePresenter> {
    void setPresenter(T presenter);

    void showError(Throwable e);

    void showLoadingDialog();

    void hideLoadingDialog();

    void showToast(@StringRes int stringResourceId);
}
