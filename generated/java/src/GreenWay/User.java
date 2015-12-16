package GreenWay;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class User {
    public String name;
    public VDMSet devices;
    public Number userid;
    public Number balance;

    public User(final Number ID, final String name_, final Number cardbalance_) {
        cg_init_User_1(ID, name_, cardbalance_);
    }

    public User() {
    }

    public void cg_init_User_1(final Number ID, final String name_,
        final Number cardbalance_) {
        userid = ID;
        name = name_;
        balance = cardbalance_;
        devices = SetUtil.set();

        return;
    }

    public void addBalance(final Number balan) {
        balance = balance.doubleValue() + balan.doubleValue();
    }

    public void addDevice(final GreenWay_Device device_) {
        devices = SetUtil.union(SetUtil.set(device_), Utils.copy(devices));
    }

    public VDMSet getDevices() {
        return Utils.copy(devices);
    }

    public String getName() {
        return name;
    }

    public Number getBalance() {
        return balance;
    }

    public void Payment(final GreenWay_Device device_) {
        balance = balance.doubleValue() - device_.getDebt().doubleValue();
        device_.clearDebts();
    }

    public void allPayed() {
        for (Iterator iterator_5 = devices.iterator(); iterator_5.hasNext();) {
            GreenWay_Device d = (GreenWay_Device) iterator_5.next();
            Payment(d);
        }
    }

    public String toString() {
        return "User{" + "name := " + Utils.toString(name) + ", devices := " +
        Utils.toString(devices) + ", userid := " + Utils.toString(userid) +
        ", balance := " + Utils.toString(balance) + "}";
    }
}
