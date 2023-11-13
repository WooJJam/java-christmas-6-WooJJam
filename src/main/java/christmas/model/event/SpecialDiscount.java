package christmas.model.event;

import christmas.constant.DateConstant;
import christmas.model.Visit;

public class SpecialDiscount extends Discount implements DateConstant{

    public SpecialDiscount(Visit visit) {
        this.amount = applyDiscount(visit);
    }

    private int applyDiscount(Visit visit) {
        int date = visit.getDate();
        if(SPECIAL_DAYS.contains(date)) {
             return 1000;
        }
        return 0;
    }
}
