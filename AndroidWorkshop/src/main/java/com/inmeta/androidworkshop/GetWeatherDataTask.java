package com.inmeta.androidworkshop;

import android.os.AsyncTask;

import com.inmeta.androidworkshop.domain.MockMetAPI;
import com.inmeta.androidworkshop.domain.model.Product;
import com.inmeta.androidworkshop.domain.model.WeatherData;

/**
 * Created by glennbech on 19.11.13.
 */
public class GetWeatherDataTask<V, P, R> extends AsyncTask<Object, Void, WeatherData> {

    private WeatherDataListener weatherDataListener;
    private float lat, lng;

    public GetWeatherDataTask(float lat, float lng, WeatherDataListener weatherDataListener) {
        this.lat = lat;
        this.lng = lng;
        this.weatherDataListener = weatherDataListener;
    }

    @Override
    protected WeatherData doInBackground(Object... objects) {
        return new MockMetAPI().getLocationData(lat, lng);
    }

    @Override
    protected void onPostExecute(WeatherData result) {
        super.onPostExecute(result);
        weatherDataListener.onWeatherDataReady(result);
    }

}
