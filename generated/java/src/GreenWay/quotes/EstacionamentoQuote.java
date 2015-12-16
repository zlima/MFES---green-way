package GreenWay.quotes;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class EstacionamentoQuote {
    private static int hc = 0;
    private static EstacionamentoQuote instance = null;

    public EstacionamentoQuote() {
        if (Utils.equals(hc, 0)) {
            hc = super.hashCode();
        }
    }

    public static EstacionamentoQuote getInstance() {
        if (Utils.equals(instance, null)) {
            instance = new EstacionamentoQuote();
        }

        return instance;
    }

    public int hashCode() {
        return hc;
    }

    public boolean equals(final Object obj) {
        return obj instanceof EstacionamentoQuote;
    }

    public String toString() {
        return "<Estacionamento>";
    }
}
