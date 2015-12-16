package GreenWay.quotes;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class GasolinaQuote {
    private static int hc = 0;
    private static GasolinaQuote instance = null;

    public GasolinaQuote() {
        if (Utils.equals(hc, 0)) {
            hc = super.hashCode();
        }
    }

    public static GasolinaQuote getInstance() {
        if (Utils.equals(instance, null)) {
            instance = new GasolinaQuote();
        }

        return instance;
    }

    public int hashCode() {
        return hc;
    }

    public boolean equals(final Object obj) {
        return obj instanceof GasolinaQuote;
    }

    public String toString() {
        return "<Gasolina>";
    }
}
