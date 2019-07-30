package eu.sk.jakab.kiwi.utils;

import android.content.Context;
import android.graphics.LightingColorFilter;
import android.support.annotation.NonNull;
import android.support.v4.widget.CircularProgressDrawable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.module.AppGlideModule;
import com.bumptech.glide.request.RequestOptions;

import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import eu.sk.jakab.kiwi.R;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by jakab on 7/29/2019.
 */
@GlideModule
public class mGlideModule extends AppGlideModule {
    @Override
    public void registerComponents(Context context, Glide glide, Registry registry) {
        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(5, TimeUnit.SECONDS)
                .connectTimeout(5, TimeUnit.SECONDS)
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC))
                .build();

        OkHttpUrlLoader.Factory factory = new OkHttpUrlLoader.Factory(client);

        glide.getRegistry().replace(GlideUrl.class, InputStream.class, factory);
    }

    @Override
    public void applyOptions(@NonNull Context context, @NonNull GlideBuilder builder) {
        CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(context);
        circularProgressDrawable.setStrokeWidth(5);
        circularProgressDrawable.setCenterRadius(30);
        circularProgressDrawable.setColorFilter(new LightingColorFilter(0xFF000000,0xFFFFFFFF));
        circularProgressDrawable.start();

        RequestOptions requestOptions = new RequestOptions()
                .placeholder(circularProgressDrawable)
                .error(R.drawable.ic_image_gray)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .centerCrop();
        builder.setDefaultRequestOptions(requestOptions);
        //super.applyOptions(context, builder);
    }
}
