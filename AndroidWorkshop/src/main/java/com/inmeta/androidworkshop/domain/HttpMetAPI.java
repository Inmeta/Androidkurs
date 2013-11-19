package com.inmeta.androidworkshop.domain;

import com.inmeta.androidworkshop.domain.model.Product;
import com.inmeta.androidworkshop.domain.model.WeatherData;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.strategy.Strategy;
import org.simpleframework.xml.strategy.TreeStrategy;

import java.io.File;

/**
 * Created by glennbech on 19.11.13.
 */
public class HttpMetAPI implements IMetAPI {
    @Override
    public WeatherData getLocationData(float lat, float lng) {
        return null;
    }

    public static void main(String[] args) throws Exception {
        Strategy strategy = new TreeStrategy("myClass", "myLength");
        Serializer serializer = new Persister(strategy);
        File source = new File("weatherdata.xml");
        WeatherData data = serializer.read(WeatherData.class, source);
        System.out.println(data);
    }
}
