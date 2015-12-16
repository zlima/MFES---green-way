package GreenWay.quotes;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class AutoEstradaQuote {
    private static int hc = 0;
    private static AutoEstradaQuote instance = null;

    public AutoEstradaQuote() {
        if (Utils.equals(hc, 0)) {
            hc = super.hashCode();
        }
    }

    public static AutoEstradaQuote getInstance() {
        if (Utils.equals(instance, null)) {
            instance = new AutoEstradaQuote();
        }

        return instance;
    }

    public int hashCode() {
        return hc;
    }

    public boolean equals(final Object obj) {
        return obj instanceof AutoEstradaQuote;
    }

    public String toString() {
        return "<AutoEstrada>";
    }
}
