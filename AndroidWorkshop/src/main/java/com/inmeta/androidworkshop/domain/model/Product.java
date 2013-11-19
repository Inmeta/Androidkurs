package com.inmeta.androidworkshop.domain.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by glennbech on 19.11.13.
 */

@Root(strict = false)
@Element(name = "product")
public class Product implements Serializable {

    private List<Time> timeList;

    @Attribute(name = "class", required = false)
    private String productClass;


    public String getProductClass() {
        return productClass;
    }

    public void setProductClass(String productClass) {
        this.productClass = productClass;
    }

    @ElementList(entry = "time", inline = true)
    public List<Time> getTimeList() {
        return timeList;
    }

    @ElementList(entry = "time", inline = true)
    public void setTimeList(List<Time> timeList) {
        this.timeList = timeList;
    }


    @Override
    public String toString() {
        return "Product{" +
                "timeList=" + timeList +
                '}';
    }
}
