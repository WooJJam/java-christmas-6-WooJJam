package christmas.service;

import christmas.model.Order;
import christmas.model.Visit;
import christmas.model.event.ChristmasDiscount;
import christmas.model.event.GiftDiscount;
import christmas.model.event.SpecialDiscount;
import christmas.model.event.WeekOfDayDiscount;

import java.util.Map;

public class DiscountService {

    public ChristmasDiscount applyChristmasDiscountPolicy(Visit visit) {
        return new ChristmasDiscount(visit);

//        return christmasDiscount.getAmount();
    }

    public WeekOfDayDiscount applyWeekOfDayDiscountPolicy(Visit visit, Order order) {
        return new WeekOfDayDiscount(visit, order);

//        return weekOfDayDiscount.getAmount();
    }

    public SpecialDiscount applySpecialDiscountPolicy(Visit visit) {
        return new SpecialDiscount(visit);

//        return specialDiscount.getAmount();
    }

    public GiftDiscount applyGiftPolicy(Order order) {
        return new GiftDiscount(order);

//        return giftDiscount.getAmount();
    }

    public int calculateTotalBenefitAmount(Map<String, Integer> discount, GiftDiscount giftDiscount) {

        return calculateTotalDiscountAmount(discount) + giftDiscount.getAmount();
    }

    public int calculateTotalDiscountAmount(Map<String, Integer> discount) {
        return discount.values().stream()
                .mapToInt(integer -> integer)
                .sum();
    }

    public int calculateFinalAmount(int benefit, GiftDiscount giftDiscount, Order order) {
        return order.getAmount() - benefit + giftDiscount.getAmount();
    }
}
