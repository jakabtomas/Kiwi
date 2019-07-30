package eu.sk.jakab.kiwi.network.services;

import eu.sk.jakab.kiwi.network.BaseApiClient;
import eu.sk.jakab.kiwi.network.api.FlightsSearchAPI;

/**
 * Created by jakab on 7/29/2019.
 */
public class FlightSearchService {
    private static final Object sInstanceLock = new Object();
    private static FlightsSearchAPI sINSTANCE = null;

    public static FlightsSearchAPI getInstance() {
        if (sINSTANCE == null) {
            synchronized (sInstanceLock) {
                if (sINSTANCE == null)
                    sINSTANCE = BaseApiClient.getInstance().createService(FlightsSearchAPI.class);
            }
        }

        return sINSTANCE;
    }
}
