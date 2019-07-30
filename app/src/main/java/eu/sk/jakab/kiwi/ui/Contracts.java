package eu.sk.jakab.kiwi.ui;

import eu.sk.jakab.kiwi.base.BasePresenter;
import eu.sk.jakab.kiwi.base.BaseView;
import eu.sk.jakab.kiwi.network.model.FlightSearchResult;

/**
 * Created by jakab on 7/29/2019.
 */
public interface Contracts {

    interface ListView extends BaseView<ListPresenter>{

        void showData(FlightSearchResult flightSearchResult);
    }

    interface ListPresenter extends BasePresenter{

    }
}
