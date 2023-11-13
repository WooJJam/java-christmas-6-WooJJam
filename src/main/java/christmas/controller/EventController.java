package christmas.controller;

import christmas.model.Order;
import christmas.model.Visit;
import christmas.service.BadgeService;
import christmas.service.DiscountService;
import christmas.view.OutputView;

import java.util.HashMap;
import java.util.Map;

public class EventController {

    private final DiscountService discountService = new DiscountService();
    private final BadgeService badgeService = new BadgeService();

    public int applyEventPolicy(Visit visit, Order order) {

        int christmasDiscountAmount = this.discountService.applyChristmasDiscountPolicy(visit);
        int weekOfDayDiscountAmount = this.discountService.applyWeekOfDayDiscountPolicy(visit, order);
        int specialDiscountAmount = this.discountService.applySpecialDiscountPolicy(visit);
        int giftAmount = this.discountService.applyGiftPolicy(order);

        Map<String, Integer> discount;
        discount = eventAmountToMap(christmasDiscountAmount, weekOfDayDiscountAmount, specialDiscountAmount);

        return processResult(discount, giftAmount, order, visit);
    }

    private Map<String, Integer> eventAmountToMap(int christmasDiscountAmount, int weekOfDayDiscountAmount, int specialDiscountAmount) {

        Map<String, Integer> discount = new HashMap<>();
        discount.put("christmas",christmasDiscountAmount);
        discount.put("weekOfDay",weekOfDayDiscountAmount);
        discount.put("special",specialDiscountAmount);
        return discount;
    }

    private int processResult(Map<String,Integer> discount, int giftAmount, Order order, Visit visit) {

        int benefit = this.discountService.calculateTotalBenefitAmount(discount, giftAmount);
        int finalAmount = this.discountService.calculateFinalAmount(benefit, giftAmount, order);

        OutputView.printBenefitsHistory(discount, giftAmount, visit);
        OutputView.printTotalBenefitAmount(benefit);
        OutputView.printFinalAmount(finalAmount);

        return benefit;
    }

    public void processEventBadge(int benefit) {
        String badge = this.badgeService.awardBadgesBasedOnAmount(benefit);
        OutputView.printEventBadge(badge);
    }
}