package GreenWay;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class HighWayCosts {
    private String name;
    private VDMMap cost;
    private Number scutCost;
    private Number totalCost;
    private String tempLocal;

    public HighWayCosts(final String name_, final VDMMap costs_,
        final Number scutCost_) {
        cg_init_HighWayCosts_1(name_, Utils.copy(costs_), scutCost_);
    }

    public HighWayCosts() {
    }

    public void cg_init_HighWayCosts_1(final String name_, final VDMMap costs_,
        final Number scutCost_) {
        name = name_;
        cost = Utils.copy(costs_);
        scutCost = scutCost_;

        return;
    }

    public Number Costs(final String local1, final String local2) {
        concatLocation(local1, local2);
        totalCost = ((Number) Utils.get(cost, tempLocal));

        return totalCost;
    }

    public void concatLocation(final String local1, final String local2) {
        tempLocal = local1 + local2;
    }

    public String toString() {
        return "HighWayCosts{" + "name := " + Utils.toString(name) +
        ", cost := " + Utils.toString(cost) + ", scutCost := " +
        Utils.toString(scutCost) + ", totalCost := " +
        Utils.toString(totalCost) + ", tempLocal := " +
        Utils.toString(tempLocal) + "}";
    }
}
