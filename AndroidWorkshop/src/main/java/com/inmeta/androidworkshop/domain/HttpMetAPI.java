package com.inmeta.androidworkshop.domain;

import com.inmeta.androidworkshop.domain.model.Product;
import com.inmeta.androidworkshop.domain.model.WeatherData;

import org.apache.http.params.HttpParams;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.strategy.Strategy;
import org.simpleframework.xml.strategy.TreeStrategy;

import java.io.File;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * Connects to api.met.no to get the forecast for a location.
 * <p/>
 * Created by glennbech on 19.11.13.
 */
public class HttpMetAPI implements IMetAPI {

    private static final String URL_PATTERN = "http://api.met.no/weatherapi/locationforecast/1.8/?lat=%s;lon=%s";

    @Override
    public WeatherData getLocationData(float lat, float lng) throws Exception {
        String url = String.format(URL_PATTERN, String.valueOf(lat), String.valueOf(lng));
        URL u = new URL(url);
        InputStream inputStream = u.openConnection().getInputStream();

        // this is a hack, we need it because met.no returns xml with an attribute calles
        // "class" that has a special meaning for the simple xml library. this fixes it.
        Strategy strategy = new TreeStrategy("myClass", "myLength");
        Serializer serializer = new Persister(strategy);
        return serializer.read(WeatherData.class, inputStream);
    }
}
