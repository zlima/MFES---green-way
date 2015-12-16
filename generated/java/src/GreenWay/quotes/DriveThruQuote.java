package GreenWay.quotes;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class DriveThruQuote {
    private static int hc = 0;
    private static DriveThruQuote instance = null;

    public DriveThruQuote() {
        if (Utils.equals(hc, 0)) {
            hc = super.hashCode();
        }
    }

    public static DriveThruQuote getInstance() {
        if (Utils.equals(instance, null)) {
            instance = new DriveThruQuote();
        }

        return instance;
    }

    public int hashCode() {
        return hc;
    }

    public boolean equals(final Object obj) {
        return obj instanceof DriveThruQuote;
    }

    public String toString() {
        return "<DriveThru>";
    }
}
