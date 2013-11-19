package com.inmeta.androidworkshop;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.inmeta.androidworkshop.domain.model.Product;
import com.inmeta.androidworkshop.domain.model.WeatherData;


/**
 * This is this applications start Activity. The class name is referenced from Androidmanifest.xml
 *
 * @author Glenn Bech
 */
public class StartActivity extends ActionBarActivity implements WeatherDataListener {


    public static final String KEY_WEATHERDATA = "key_weatherdata";
    private WeatherData weatherData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            weatherData = (WeatherData) savedInstanceState.getSerializable(KEY_WEATHERDATA);
            doLayout();
        }

    }

    @Override
    protected void onStart() {
        super.onStart();

        if (weatherData == null) {
            GetWeatherDataTask task = new GetWeatherDataTask(50.0f, 50.0f, this);
            task.execute(null);
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(KEY_WEATHERDATA, weatherData);
    }

    /**
     * Override this method to create a menu, or action bar items for Android 3.0 +
     *
     * @param menu the menu resource to "inflate"
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.start, menu);
        return true;
    }

    /**
     * This method is called when a menu item is selected.
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
            }
            return super.onOptionsItemSelected(item);
    }

    /**
     * This method is called when the weather data is ready, this is the right place
     * to update the UI. This is called in the UI thread from the async task method
     * after
     *
     * @param data
     */
    @Override
    public void onWeatherDataReady(WeatherData data) {
        this.weatherData = data;
        doLayout();
    }

    private void doLayout() {
        setContentView(R.layout.activity_start);
        TextView tvTemperature = (TextView) findViewById(R.id.temperature);
        float temperatureValue = weatherData.getProduct().getTimeList().get(0).getLocationList().get(0).getTemperature().getValue();
        tvTemperature.setText(String.valueOf(temperatureValue));
    }
}
