package christmas.service;

import christmas.model.Order;
import christmas.model.Visit;
import christmas.model.event.ChristmasDiscount;
import christmas.model.event.GiftDiscount;
import christmas.model.event.SpecialDiscount;
import christmas.model.event.WeekOfDayDiscount;

import java.util.List;

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

    public int applyGiftPolicy(Order order) {
        GiftDiscount giftDiscount = new GiftDiscount(order);

        return giftDiscount.getAmount();
    }

    public int calculateTotalBenefitAmount(List<Integer> discount, int giftAmount) {

        return calculateTotalDiscountAmount(discount) + giftAmount;
    }

    public int calculateTotalDiscountAmount(List<Integer> discount) {
        return discount.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public int calculateFinalAmount(int benefit, int giftAmount,  Order order) {
        return order.getAmount() - benefit + giftAmount;
    }
}
