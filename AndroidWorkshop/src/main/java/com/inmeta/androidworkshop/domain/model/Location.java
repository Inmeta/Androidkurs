package com.inmeta.androidworkshop.domain.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.Serializable;

/**
 * Created by glennbech on 19.11.13.
 */

@Root(strict = false)
@Element(name = "location")
public class Location implements Serializable {

    @Element(name = "temperature",required = false)
    private Temperature temperature;

    @Element(name = "windSpeed", required = false)
    private WindSpeed windSpeed;

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public WindSpeed getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(WindSpeed windSpeed) {
        this.windSpeed = windSpeed;
    }

    @Override
    public String toString() {
        return "Location{" +
                "temperature=" + temperature +
                ", windSpeed=" + windSpeed +
                '}';
    }
}
