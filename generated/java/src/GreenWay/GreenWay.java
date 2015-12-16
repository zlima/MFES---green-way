package GreenWay;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class GreenWay {
    private VDMSeq users;
    private VDMSeq servicesProviders;

    public GreenWay(final VDMSeq users_, final VDMSeq services_) {
        cg_init_GreenWay_1(Utils.copy(users_), Utils.copy(services_));
    }

    public GreenWay() {
    }

    public void cg_init_GreenWay_1(final VDMSeq users_, final VDMSeq services_) {
        users = Utils.copy(users_);
        servicesProviders = Utils.copy(services_);

        return;
    }

    public void monthPayment(final User user_) {
        user_.allPayed();
    }

    public void allUsersPayed() {
        for (Iterator iterator_1 = users.iterator(); iterator_1.hasNext();) {
            User u = (User) iterator_1.next();
            monthPayment(u);
        }
    }

    public void printCost() {
        IO.println("Costs from all Devices:");

        for (Iterator iterator_2 = users.iterator(); iterator_2.hasNext();) {
            User u = (User) iterator_2.next();

            if (u.getDevices().size() >= 1L) {
                IO.print("User: ");
                IO.println(u.getName());

                for (Iterator iterator_3 = u.getDevices().iterator();
                        iterator_3.hasNext();) {
                    GreenWay_Device d = (GreenWay_Device) iterator_3.next();
                    IO.print("Device - ");
                    IO.print(d.getDeviceID());
                    IO.print(" Plate - ");
                    IO.print(d.getPlate());
                    IO.print(" to pay: ");
                    IO.print(d.getDebt());
                    IO.println("â‚¬");
                }

                IO.println(" ");
            }
        }

        IO.println(" ");
    }

    public void addUser(final User user_) {
        users = SeqUtil.conc(Utils.copy(users), SeqUtil.seq(user_));
    }

    public void addServiceProvider(final Service_Provider service_) {
        servicesProviders = SeqUtil.conc(Utils.copy(servicesProviders),
                SeqUtil.seq(service_));
    }

    public VDMSeq getServices() {
        return Utils.copy(servicesProviders);
    }

    public VDMSeq getUsers() {
        return Utils.copy(users);
    }

    public String toString() {
        return "GreenWay{" + "users := " + Utils.toString(users) +
        ", servicesProviders := " + Utils.toString(servicesProviders) + "}";
    }
}
