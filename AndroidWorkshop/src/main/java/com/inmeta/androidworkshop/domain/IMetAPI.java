package com.inmeta.androidworkshop.domain;

import com.inmeta.androidworkshop.domain.model.Product;
import com.inmeta.androidworkshop.domain.model.WeatherData;

/**
 * Created by glennbech on 19.11.13.
 */
public interface IMetAPI {

    public WeatherData getLocationData(float lat, float lng) throws Exception;

}
