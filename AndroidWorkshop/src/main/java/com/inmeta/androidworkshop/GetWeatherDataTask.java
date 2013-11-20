package com.inmeta.androidworkshop;

import android.os.AsyncTask;
import android.util.Log;

import com.inmeta.androidworkshop.domain.HttpMetAPI;
import com.inmeta.androidworkshop.domain.model.WeatherData;

/**
 * This class gets the WeatherForecast for a location given by its Latitude/Longtitude pair.
 * The AsynchTask makes sure that the network io us run in a separate thread.
 * <p/>
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
        try {
            return new HttpMetAPI().getLocationData(lat, lng);
        } catch (Exception e) {
            //todo Assignment: Add error Method to callback interface (WeatherDataListener)
            Log.e(GetWeatherDataTask.class.getName(), e.getMessage(), e);
            return null;
        }
    }

    @Override
    protected void onPostExecute(WeatherData result) {
        super.onPostExecute(result);
        weatherDataListener.onWeatherDataReady(result);
    }

}
