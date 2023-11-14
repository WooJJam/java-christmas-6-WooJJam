package christmas.model.event;

import christmas.model.Visit;

public class ChristmasDiscount extends Discount {

    public ChristmasDiscount(Visit visit) {

        this.amount = 1000;
        applyDiscount(visit);
    }

    public void applyDiscount(Visit visit) {

        if (visit.getDate() > 25) {
            this.amount = 0;
            return;
        }

        this.amount += (visit.getDate() - 1) * 100;
    }

}
