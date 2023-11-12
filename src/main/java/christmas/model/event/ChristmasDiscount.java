package christmas.model.event;

import christmas.model.Visit;
import christmas.model.Week;

public class DdayDiscount extends Discount {

    public DdayDiscount(Visit visit) {
        this.amount = 1000;
        applyDiscount(visit);
    }
    @Override
    public void applyDiscount(Visit visit) {
        if (visit.getDate() > 25) {
            this.amount = 0;
            return;
        }
        this.amount += (visit.getDate() - 1) * 100;
    }

}
