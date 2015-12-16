package GreenWay;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class Event {
    private String name;
    private Number timeMin;
    private GreenWay_Device device;
    private Service_Provider pointExit;
    private Service_Provider pointEntry;
    private Number cost;
    private HighWayCosts highwaycost;

    public Event(final String name_, final Number timeMin_,
        final GreenWay_Device device_, final Service_Provider pointEntry_,
        final Number cost_) {
        cg_init_Event_1(name_, timeMin_, device_, pointEntry_, cost_);
    }

    public Event(final String name_, final Number timeMin_,
        final GreenWay_Device device_, final Service_Provider pointEntry_,
        final Service_Provider pointExit_, final HighWayCosts highwaycost_) {
        cg_init_Event_2(name_, timeMin_, device_, pointEntry_, pointExit_,
            highwaycost_);
    }

    public Event() {
    }

    public void cg_init_Event_1(final String name_, final Number timeMin_,
        final GreenWay_Device device_, final Service_Provider pointEntry_,
        final Number cost_) {
        name = name_;
        timeMin = timeMin_;
        device = device_;
        pointEntry = pointEntry_;
        cost = cost_;

        return;
    }

    public void cg_init_Event_2(final String name_, final Number timeMin_,
        final GreenWay_Device device_, final Service_Provider pointEntry_,
        final Service_Provider pointExit_, final HighWayCosts highwaycost_) {
        name = name_;
        timeMin = timeMin_;
        device = device_;
        pointEntry = pointEntry_;
        pointExit = pointExit_;
        highwaycost = highwaycost_;
        cost = 0L;

        return;
    }

    public void Cost(final GreenWay_Device device_) {
        if (Utils.equals(pointEntry.getServiceType(),
                    GreenWay.quotes.AutoEstradaQuote.getInstance())) {
            cost = highwaycost.Costs(pointEntry.getServiceLocation(),
                    pointExit.getServiceLocation());
        }

        device_.addDebt(cost);
    }

    public void printEvent() {
        if (Utils.equals(pointEntry.getServiceType(),
                    GreenWay.quotes.DriveThruQuote.getInstance())) {
            IO.println("Event:");
            IO.print("Name: ");
            IO.println(name);
            IO.print("Dispositivo: ");
            IO.println(device.getDeviceID());
            IO.print("Cost: ");
            IO.print(cost);
            IO.println("$");
            IO.print("Point Of Service: ");
            IO.println(pointEntry.getServiceLocation());
            IO.println(" ");
        } else {
            if (Utils.equals(pointEntry.getServiceType(),
                        GreenWay.quotes.EstacionamentoQuote.getInstance())) {
                IO.println("Event:");
                IO.print("Name: ");
                IO.println(name);
                IO.print("Dispositivo: ");
                IO.println(device.getDeviceID());
                IO.print("Cost: ");
                IO.print(cost);
                IO.println("$");
                IO.print("Point Of Service: ");
                IO.println(pointEntry.getServiceLocation());
                IO.println(" ");
            } else {
                if (Utils.equals(pointEntry.getServiceType(),
                            GreenWay.quotes.GasolinaQuote.getInstance())) {
                    IO.println("Event:");
                    IO.print("Name: ");
                    IO.println(name);
                    IO.print("Dispositivo: ");
                    IO.println(device.getDeviceID());
                    IO.print("Cost: ");
                    IO.print(cost);
                    IO.println("$");
                    IO.print("Point Of Service: ");
                    IO.println(pointEntry.getServiceLocation());
                    IO.println(" ");
                } else {
                    if (Utils.equals(pointEntry.getServiceType(),
                                GreenWay.quotes.ScutQuote.getInstance())) {
                        IO.println("Event:");
                        IO.print("Name: ");
                        IO.println(name);
                        IO.print("Dispositivo: ");
                        IO.println(device.getDeviceID());
                        IO.print("Cost: ");
                        IO.print(cost);
                        IO.println("$");
                        IO.print("Point Of Service: ");
                        IO.println(pointEntry.getServiceLocation());
                        IO.println(" ");
                    } else {
                        IO.println("Event:");
                        IO.print("Name: ");
                        IO.println(name);
                        IO.print("Dispositivo: ");
                        IO.println(device.getDeviceID());
                        IO.print("Cost: ");
                        IO.print(cost);
                        IO.println("$");
                        IO.print("Entry: ");
                        IO.println(pointEntry.getServiceLocation());
                        IO.print("Exit: ");
                        IO.println(pointExit.getServiceLocation());
                        IO.println(" ");
                    }
                }
            }
        }
    }

    public String getEventName() {
        return name;
    }

    public Number getEventTime() {
        return timeMin;
    }

    public GreenWay_Device getEventDevice() {
        return device;
    }

    public Service_Provider getEventEntryPoint() {
        return pointEntry;
    }

    public Service_Provider getEventExitPoint() {
        return pointExit;
    }

    public String toString() {
        return "Event{" + "name := " + Utils.toString(name) + ", timeMin := " +
        Utils.toString(timeMin) + ", device := " + Utils.toString(device) +
        ", pointExit := " + Utils.toString(pointExit) + ", pointEntry := " +
        Utils.toString(pointEntry) + ", cost := " + Utils.toString(cost) +
        ", highwaycost := " + Utils.toString(highwaycost) + "}";
    }
}
