package eu.sk.jakab.kiwi.network.operations;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Locale;

import eu.sk.jakab.kiwi.network.model.FlightSearchResult;
import eu.sk.jakab.kiwi.network.services.FlightSearchService;
import eu.sk.jakab.kiwi.utils.SchedulerProvider;
import io.reactivex.Observable;

/**
 * Created by jakab on 7/29/2019.
 */
public class FlightSearchOperations {

    public Observable<FlightSearchResult> getDailyFlights() {
        DateTime dateTime = new DateTime();
        dateTime = dateTime.plusDays(1);
        DateTimeFormatter fmt = DateTimeFormat.forPattern("dd/MM/yyyy");
        return FlightSearchService.getInstance()
                .getDailyFlights(2,"popularity", Locale.getDefault().getCountry().toLowerCase(),
                        "48.76-21.21-250km", "anywhere",
                        "aggregateResults", fmt.print(dateTime), fmt.print(dateTime),
                        "oneway",1,5, 1)
                .subscribeOn(SchedulerProvider.getInstance().io())
                .observeOn(SchedulerProvider.getInstance().ui());
    }
}
