package GreenWay;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class Service_Provider {
    private String name;
    private String location;
    private Object type;
    private Number cordX;
    private Number cordY;

    public Service_Provider(final Object type_, final String name_,
        final String location_, final Number cordX_, final Number cordY_) {
        cg_init_Service_Provider_1(((Object) type_), name_, location_, cordX_,
            cordY_);
    }

    public Service_Provider() {
    }

    public void cg_init_Service_Provider_1(final Object type_,
        final String name_, final String location_, final Number cordX_,
        final Number cordY_) {
        name = name_;
        type = type_;
        location = location_;
        cordX = cordX_;
        cordY = cordY_;

        return;
    }

    public String getServiceName() {
        return name;
    }

    public String getServiceLocation() {
        return location;
    }

    public Number getServiceCordX() {
        return cordX;
    }

    public Number getServiceCordY() {
        return cordY;
    }

    public Object getServiceType() {
        return type;
    }

    public String toString() {
        return "Service_Provider{" + "name := " + Utils.toString(name) +
        ", location := " + Utils.toString(location) + ", type := " +
        Utils.toString(type) + ", cordX := " + Utils.toString(cordX) +
        ", cordY := " + Utils.toString(cordY) + "}";
    }
}
