package com.inmeta.androidworkshop;

import com.inmeta.androidworkshop.domain.model.Product;
import com.inmeta.androidworkshop.domain.model.WeatherData;

/**
 * Interface for classes that wants to use the class GetWeatherDataTask.
 * An instance of a class implementing this interface is given as a callback
 * mechanism
 * <p/>
 * Created by glennbech on 19.11.13.
 */
public interface WeatherDataListener {
    void onWeatherDataReady(WeatherData data);
}
