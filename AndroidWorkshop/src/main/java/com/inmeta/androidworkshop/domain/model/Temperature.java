package com.inmeta.androidworkshop.domain.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.Serializable;

/**
 * Created by glennbech on 19.11.13.
 */
@Root(strict = false)
@Element(name = "temperature")
public class Temperature implements Serializable {

    @Attribute
    private String unit;

    @Attribute
    private float value;

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Temperature{" +
                "unit='" + unit + '\'' +
                ", value=" + value +
                '}';
    }
}
