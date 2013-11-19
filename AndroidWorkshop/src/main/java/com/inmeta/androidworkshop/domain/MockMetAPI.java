package com.inmeta.androidworkshop.domain;

import com.inmeta.androidworkshop.domain.model.Location;
import com.inmeta.androidworkshop.domain.model.Product;
import com.inmeta.androidworkshop.domain.model.Temperature;
import com.inmeta.androidworkshop.domain.model.Time;
import com.inmeta.androidworkshop.domain.model.WeatherData;
import com.inmeta.androidworkshop.domain.model.WindSpeed;

/**
 * Created by glennbech on 19.11.13
 */
public class MockMetAPI implements IMetAPI {

    private static final String URL_PATTERN = " http://api.met.no/weatherapi/locationforecast/1.8/?lat=%s;lon=%s";

    public WeatherData getLocationData(float lat, float lng) {

        Temperature temp = new Temperature();
        temp.setUnit("celcius");
        temp.setValue(1.2f);

        WindSpeed windSpeed = new WindSpeed();
        windSpeed.setBeaufort(2);
        windSpeed.setMps(2.2f);
        windSpeed.setName("Svak vind");


        Location location = new Location();
        location.setTemperature(temp);
        location.setWindSpeed(windSpeed);

        Time time = new Time();
        time.setDataType("forecast");
        time.getLocationList().add(location);

        Product p = new Product();
        p.getTimeList().add(time);

        WeatherData data = new WeatherData();
        data.setProduct(p);
        return data;
    }

}
