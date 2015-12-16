package GreenWay;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class GreenWay_Device {
    public Number id;
    public Number userID;
    public String plate;
    public VDMSeq historic;
    private Number debt;
    private String location;

    public GreenWay_Device(final Number ID, final Number userID_,
        final String plate_) {
        cg_init_GreenWay_Device_1(ID, userID_, plate_);
    }

    public GreenWay_Device() {
    }

    public void cg_init_GreenWay_Device_1(final Number ID,
        final Number userID_, final String plate_) {
        id = ID;
        userID = userID_;
        plate = plate_;
        historic = SeqUtil.seq();
        debt = 0L;

        return;
    }

    public void addLocation(final Event event) {
        location = event.getEventEntryPoint().getServiceLocation();
        historic = SeqUtil.conc(SeqUtil.seq(location), Utils.copy(historic));

        event.Cost(this);
    }

    public void clearDebts() {
        debt = 0L;
    }

    public void addDebt(final Number value) {
        debt = debt.doubleValue() + value.doubleValue();
    }

    public void printDeviceHist() {
        IO.println("Historico do Dispositivo:");
        IO.print("Matricula: ");
        IO.println(plate);

        for (Iterator iterator_4 = historic.iterator(); iterator_4.hasNext();) {
            String i = (String) iterator_4.next();
            IO.println(i);
        }

        IO.println(" ");
    }

    public Number getDeviceID() {
        return id;
    }

    public String getPlate() {
        return plate;
    }

    public VDMSeq getDeviceHist() {
        return Utils.copy(historic);
    }

    public Number getDebt() {
        return debt;
    }

    public VDMSeq getHistoricLoc() {
        return Utils.copy(historic);
    }

    public String toString() {
        return "GreenWay_Device{" + "id := " + Utils.toString(id) +
        ", userID := " + Utils.toString(userID) + ", plate := " +
        Utils.toString(plate) + ", historic := " + Utils.toString(historic) +
        ", debt := " + Utils.toString(debt) + ", location := " +
        Utils.toString(location) + "}";
    }
}
