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
@Element(name = "time")
public class Time implements Serializable {

    @Attribute(name = "datatype", required = false)
    private String dataType;

    @Attribute(name = "from")
    private String from;

    @Attribute(name = "to")
    private String to;

    private List<Location> locationList = new ArrayList<Location>();

    public String getDataType() {
        return dataType;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    @ElementList(entry = "location", inline = true)
    public List<Location> getLocationList() {
        return locationList;
    }

    @ElementList(entry = "location", inline = true)
    public void setLocationList(List<Location> locationList) {
        this.locationList = locationList;
    }

    @Override
    public String toString() {
        return "Time{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", dataType='" + dataType + '\'' +
                ", locationList=" + locationList +
                '}';
    }
}
