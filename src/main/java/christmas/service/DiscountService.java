package christmas.service;

import christmas.model.Order;
import christmas.model.Visit;
import christmas.model.event.ChristmasDiscount;
import christmas.model.event.GiftDiscount;
import christmas.model.event.SpecialDiscount;
import christmas.model.event.WeekOfDayDiscount;

public class DiscountService {

    public int applyChristmasDiscountPolicy(Visit visit) {
        ChristmasDiscount christmasDiscount = new ChristmasDiscount(visit);

        return christmasDiscount.getAmount();
    }

    public int applyWeekOfDayDiscountPolicy(Visit visit, Order order) {
        WeekOfDayDiscount weekOfDayDiscount = new WeekOfDayDiscount(visit,order);

        return weekOfDayDiscount.getAmount();
    }

    public int applySpecialDiscountPolicy(Visit visit) {
        SpecialDiscount specialDiscount = new SpecialDiscount(visit);

        return specialDiscount.getAmount();
    }

    public int applyGiftDiscountPolicy(Order order) {
        GiftDiscount giftDiscount = new GiftDiscount(order);

        return giftDiscount.getAmount();
    }
}
