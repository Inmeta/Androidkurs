package com.inmeta.androidworkshop;

import com.inmeta.androidworkshop.domain.model.Product;
import com.inmeta.androidworkshop.domain.model.WeatherData;

/**
 * Interface for classes that wants to use the GetWeatherDataTask
 * to get

 * Created by glennbech on 19.11.13.
 */
public interface WeatherDataListener {
    void onWeatherDataReady(WeatherData data);
}
