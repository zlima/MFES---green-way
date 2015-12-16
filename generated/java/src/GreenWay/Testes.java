package GreenWay;

import org.overture.codegen.runtime.*;

import java.util.*;

@SuppressWarnings("all")
public class Testes extends TestCaseUtils {
    public Testes() {
    }

    private void teste1() {
        User u = new User(1L, "Jose Lima", 999999L);
        User u2 = new User(2L, "John Cena", 999999L);
        User u3 = new User(3L, "Josefino Ferreira Filho", 999999L);
        User u4 = new User(4L, "Nilmar de Jesus", 999999L);
        User u5 = new User(5L, "Washington Silva", 999999L);
        User u6 = new User(6L, "Sofia Ramos", 999999L);
        User u7 = new User(7L, "Andreia Silva", 999999L);
        User u8 = new User(8L, "Ana Ferreira", 999999L);
        User u9 = new User(9L, "Tatiana Silva", 999999L);
        User u10 = new User(10L, "Wellington da Silva Junior", 999999L);
        User u11 = new User(11L, "Rebeca Bueno", 999999L);
        User u12 = new User(12L, "Wesley Souza", 999999L);
        User u13 = new User(13L, "Rodolfo Oliveira Quatro", 999999L);
        GreenWay_Device d = new GreenWay_Device(1L, 1L, "25-GG-31");
        GreenWay_Device d1 = new GreenWay_Device(2L, 1L, "39-FH-01");
        GreenWay_Device d2 = new GreenWay_Device(3L, 1L, "17-AA-99");
        GreenWay_Device d3 = new GreenWay_Device(4L, 1L, "38-HL-31");
        GreenWay_Device d4 = new GreenWay_Device(5L, 1L, "68-GP-39");
        GreenWay_Device d5 = new GreenWay_Device(6L, 1L, "69-GP-69");
        GreenWay_Device d6 = new GreenWay_Device(7L, 1L, "21-II-77");
        GreenWay_Device d7 = new GreenWay_Device(8L, 1L, "29-AF-01");
        GreenWay_Device d8 = new GreenWay_Device(9L, 1L, "14-OV-90");
        GreenWay_Device d9 = new GreenWay_Device(10L, 1L, "12-19-VU");
        GreenWay_Device d10 = new GreenWay_Device(11L, 1L, "87-67-RX");
        GreenWay_Device d11 = new GreenWay_Device(12L, 1L, "14-37-BM");
        GreenWay_Device d12 = new GreenWay_Device(13L, 1L, "43-BM-87");
        GreenWay_Device d13 = new GreenWay_Device(14L, 1L, "SV-28-01");
        Service_Provider sp = new Service_Provider(GreenWay.quotes.AutoEstradaQuote.getInstance(),
                "ponto1", "LocalA", 123L, 234L);
        Service_Provider sp2 = new Service_Provider(GreenWay.quotes.AutoEstradaQuote.getInstance(),
                "ponto2", "LocalB", 456L, 567L);
        Service_Provider sp3 = new Service_Provider(GreenWay.quotes.EstacionamentoQuote.getInstance(),
                "parque1", "LocalB", 456L, 567L);
        Service_Provider sp4 = new Service_Provider(GreenWay.quotes.DriveThruQuote.getInstance(),
                "macBoavista", "macBoavista", 500L, 489L);
        Service_Provider sp5 = new Service_Provider(GreenWay.quotes.GasolinaQuote.getInstance(),
                "galpBoavista", "Bomba Galp Boavista", 500L, 489L);
        Service_Provider sp6 = new Service_Provider(GreenWay.quotes.ScutQuote.getInstance(),
                "a25 scut Ovar Norte", "a25 s. Ovar norte", 500L, 490L);
        HighWayCosts hc = new HighWayCosts("estrada1",
                MapUtil.map(new Maplet("LocalALocalB", 0.6),
                    new Maplet("LocalBLocalA", 0.6)), 12L);
        Event ev = new Event("AutoEstrada", 10L, d, sp, sp2, hc);
        Event ev2 = new Event("Estacionamento", 60L, d, sp3, 3L);
        Event ev3 = new Event("DriveThru mac", 66L, d, sp4, 14L);
        Event ev4 = new Event("Gasolina", 80L, d, sp5, 50L);
        Event ev5 = new Event("A25 Scut ovar norte", 200L, d, sp6, 0.5);
        GreenWay greenway = new GreenWay(SeqUtil.seq(u),
                SeqUtil.seq(sp, sp2, sp3, sp4, sp6));
        greenway.addUser(u2);
        super.assertEqual(SeqUtil.seq(u, u2), greenway.getUsers());
        greenway.addServiceProvider(sp5);
        super.assertEqual(SeqUtil.seq(sp, sp2, sp3, sp4, sp6, sp5),
            greenway.getServices());
        u.addDevice(d);
        u.addDevice(d1);
        super.assertEqual(SetUtil.set(d, d1), u.getDevices());
        d.addLocation(ev);
        d.addLocation(ev2);
        d.addLocation(ev3);
        super.assertEqual(SeqUtil.seq(ev3.getEventEntryPoint()
                                         .getServiceLocation(),
                ev2.getEventEntryPoint().getServiceLocation(),
                ev.getEventEntryPoint().getServiceLocation()),
            d.getHistoricLoc());
        d.addLocation(ev4);
        d.addLocation(ev5);
        super.assertEqual(SeqUtil.seq(ev5.getEventEntryPoint()
                                         .getServiceLocation(),
                ev4.getEventEntryPoint().getServiceLocation(),
                ev3.getEventEntryPoint().getServiceLocation(),
                ev2.getEventEntryPoint().getServiceLocation(),
                ev.getEventEntryPoint().getServiceLocation()),
            d.getHistoricLoc());
        d.printDeviceHist();
        ev.printEvent();
        ev2.printEvent();
        ev3.printEvent();
        ev4.printEvent();
        ev5.printEvent();
        super.assertEqual(68.1, d.getDebt());
        greenway.printCost();
        greenway.allUsersPayed();
        IO.println("After payment: ");
        greenway.printCost();
        super.assertEqual(999999L - 68.1, u.getBalance());
        u.addBalance(50L);
        super.assertEqual(999999L - 68.1 + 50L, u.getBalance());
        super.assertEqual("AutoEstrada", ev.getEventName());
        super.assertEqual(10L, ev.getEventTime());
        super.assertEqual(d, ev.getEventDevice());
        super.assertEqual(sp2, ev.getEventExitPoint());
        super.assertEqual(SeqUtil.seq(ev5.getEventEntryPoint()
                                         .getServiceLocation(),
                ev4.getEventEntryPoint().getServiceLocation(),
                ev3.getEventEntryPoint().getServiceLocation(),
                ev2.getEventEntryPoint().getServiceLocation(),
                ev.getEventEntryPoint().getServiceLocation()), d.getDeviceHist());
        super.assertEqual("ponto1", sp.getServiceName());
    }

    public static void main() {
        new Testes().teste1();
    }

    public String toString() {
        return "Testes{}";
    }
}
