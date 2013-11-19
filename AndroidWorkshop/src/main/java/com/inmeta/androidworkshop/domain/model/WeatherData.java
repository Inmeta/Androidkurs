package com.inmeta.androidworkshop.domain.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.Serializable;

/**
 * Created by glennbech on 19.11.13.
 */

@Root(name = "weatherdata", strict = false)
public class WeatherData implements Serializable {

    @Element(name = "product")
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "WeatherData{" +
                "product=" + product +
                '}';
    }
}
