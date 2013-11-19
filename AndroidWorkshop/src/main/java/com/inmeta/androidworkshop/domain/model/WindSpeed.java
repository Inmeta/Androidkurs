package com.inmeta.androidworkshop.domain.model;

import org.simpleframework.xml.Root;

import java.io.Serializable;

/**
 * Created by glennbech on 19.11.13.
 */
@Root(strict = false)
public class WindSpeed implements Serializable {

    private float mps;
    private float beaufort;
    private String name;

    public float getMps() {
        return mps;
    }

    public void setMps(float mps) {
        this.mps = mps;
    }

    public float getBeaufort() {
        return beaufort;
    }

    public void setBeaufort(float beaufort) {
        this.beaufort = beaufort;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "WindSpeed{" +
                "mps=" + mps +
                ", beaufort=" + beaufort +
                ", name='" + name + '\'' +
                '}';
    }
}
