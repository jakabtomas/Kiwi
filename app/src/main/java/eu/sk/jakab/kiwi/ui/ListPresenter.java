package eu.sk.jakab.kiwi.ui;

import eu.sk.jakab.kiwi.network.model.FlightSearchResult;
import eu.sk.jakab.kiwi.network.operations.FlightSearchOperations;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by jakab on 7/29/2019.
 */
public class ListPresenter implements Contracts.ListPresenter {
    private Contracts.ListView view;
    private FlightSearchOperations flightSearchOperations = new FlightSearchOperations();

    public ListPresenter(Contracts.ListView view) {
        this.view = view;
        this.view.setPresenter(this);
    }

    @Override
    public void subscribe() {
        flightSearchOperations.getDailyFlights()
                .subscribeWith(new DisposableObserver<FlightSearchResult>() {
                    @Override
                    public void onNext(FlightSearchResult flightSearchResult) {
                        view.showData(flightSearchResult);
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void unsubscribe() {

    }
}
