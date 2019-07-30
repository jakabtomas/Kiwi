package eu.sk.jakab.kiwi.network;

import eu.sk.jakab.kiwi.utils.SessionProvider;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by jakab on 1/31/2018.
 */

public class BaseApiClient {
    private static final Object sInstanceLock = new Object();
    private static ApiClient sINSTANCE = null;

    public static ApiClient getInstance() {
        if (sINSTANCE == null) {
            synchronized (sInstanceLock) {
                if (sINSTANCE == null) {
                    HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
                    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                    sINSTANCE = new ApiClient();
                    sINSTANCE.getAdapterBuilder().baseUrl(SessionProvider.getInstance().getBaseUrl());
                    sINSTANCE.getOkBuilder()
                            .addInterceptor(loggingInterceptor);
                }
            }
        }
        return sINSTANCE;
    }
}
