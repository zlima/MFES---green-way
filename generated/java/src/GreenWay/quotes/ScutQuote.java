package GreenWay.quotes;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class ScutQuote {
    private static int hc = 0;
    private static ScutQuote instance = null;

    public ScutQuote() {
        if (Utils.equals(hc, 0)) {
            hc = super.hashCode();
        }
    }

    public static ScutQuote getInstance() {
        if (Utils.equals(instance, null)) {
            instance = new ScutQuote();
        }

        return instance;
    }

    public int hashCode() {
        return hc;
    }

    public boolean equals(final Object obj) {
        return obj instanceof ScutQuote;
    }

    public String toString() {
        return "<Scut>";
    }
}
