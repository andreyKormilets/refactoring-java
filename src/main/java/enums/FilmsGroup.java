package enums;

import java.util.function.Function;

public enum FilmsGroup {

    REGULAR(days -> {
        double basic = 2;
        double extraDaysMultiplier = 1.5;
        if (days > basic) {
            return (days - basic) * extraDaysMultiplier + basic;
        }
        return basic;
    }),
    CHILDRENS(days -> {
        double basic = 1.5;
        double extraDaysMultiplier = 1.5;
        int multiplierStartDay = 3;
        if (days > basic) {
            return (days - multiplierStartDay) * extraDaysMultiplier + basic;
        }
        return basic;

    }),
    NEW(days -> {
        double daysMultiplier = 3;
        return (double) days * daysMultiplier;
    });
    public final Function<Integer, Double> priceMultiplier;

    FilmsGroup(Function<Integer, Double> priceMultiplier) {
        this.priceMultiplier = priceMultiplier;
    }

}
