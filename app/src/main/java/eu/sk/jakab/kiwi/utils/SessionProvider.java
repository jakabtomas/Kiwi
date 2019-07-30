package eu.sk.jakab.kiwi.utils;

import android.content.Context;

/**
 * Created by jakab on 10/15/2018.
 */
public class SessionProvider {
    private static final String URL = "https://api.skypicker.com/";
    private static SessionProvider sINSTANCE = null;
    private Context mContext;

    public static SessionProvider getInstance() {
        if (sINSTANCE == null) {
            sINSTANCE = new SessionProvider();
        }
        return sINSTANCE;
    }

    public String getBaseUrl() {
        return URL;
    }

    public Context getmContext() {
        return mContext;
    }

    public void setmContext(Context mContext) {
        this.mContext = mContext;
    }
}
