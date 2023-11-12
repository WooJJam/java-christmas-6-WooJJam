package christmas.service;

import christmas.model.Visit;
import christmas.model.event.ChristmasDiscount;

public class DiscountService {

    public void setChristmasDiscountPolicy(Visit visit) {
        ChristmasDiscount christmasDiscount = new ChristmasDiscount(visit);
    }
}
