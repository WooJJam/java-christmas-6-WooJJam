package christmas.controller;

import christmas.model.Order;
import christmas.model.Visit;
import christmas.model.event.ChristmasDiscount;
import christmas.model.event.GiftDiscount;
import christmas.model.event.SpecialDiscount;
import christmas.model.event.WeekOfDayDiscount;
import christmas.service.BadgeService;
import christmas.service.DiscountService;
import christmas.view.OutputView;

import java.util.HashMap;
import java.util.Map;

public class EventController {

    private final DiscountService discountService = new DiscountService();
    private final BadgeService badgeService = new BadgeService();

    public int applyEventPolicy(Visit visit, Order order) {

        Map<String, Integer> discount;

        ChristmasDiscount christmasDiscount = this.discountService.applyChristmasDiscountPolicy(visit);
        WeekOfDayDiscount weekOfDayDiscount = this.discountService.applyWeekOfDayDiscountPolicy(visit, order);
        SpecialDiscount specialDiscount = this.discountService.applySpecialDiscountPolicy(visit);
        GiftDiscount giftDiscount = this.discountService.applyGiftPolicy(order);

        discount = eventAmountToMap(christmasDiscount, weekOfDayDiscount, specialDiscount);
        OutputView.printBenefitsHistory(christmasDiscount, weekOfDayDiscount, specialDiscount, giftDiscount, order, visit);

        return processResult(discount, giftDiscount, order);
    }

    private Map<String, Integer> eventAmountToMap(ChristmasDiscount christmasDiscount, WeekOfDayDiscount weekOfDayDiscount, SpecialDiscount specialDiscount) {

        Map<String, Integer> discount = new HashMap<>();
        discount.put("christmas", christmasDiscount.getAmount());
        discount.put("weekOfDay", weekOfDayDiscount.getAmount());
        discount.put("special", specialDiscount.getAmount());

        return discount;
    }

    private int processResult(Map<String, Integer> discount, GiftDiscount giftDiscount, Order order) {

        int benefit = this.discountService.calculateTotalBenefitAmount(discount, giftDiscount);
        int finalAmount = this.discountService.calculateFinalAmount(benefit, giftDiscount, order);

        OutputView.printTotalBenefitAmount(benefit);
        OutputView.printFinalAmount(finalAmount);

        return benefit;
    }

    public void processEventBadge(int benefit) {

        String badge = this.badgeService.awardBadgesBasedOnAmount(benefit);
        OutputView.printEventBadge(badge);
    }
}