package christmas.controller;

import christmas.model.Order;
import christmas.model.Visit;
import christmas.service.BadgeService;
import christmas.service.DiscountService;
import christmas.view.OutputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventController {

    private final DiscountService discountService = new DiscountService();
    private final BadgeService badgeService = new BadgeService();

    public int applyEventPolicy(Visit visit, Order order) {

        int christmasDiscountAmount = this.discountService.applyChristmasDiscountPolicy(visit);
        int weekOfDayDiscountAmount = this.discountService.applyWeekOfDayDiscountPolicy(visit, order);
        int specialDiscountAmount = this.discountService.applySpecialDiscountPolicy(visit);
        int giftAmount = this.discountService.applyGiftPolicy(order);

        OutputView.printBenefitsHistory(christmasDiscountAmount, weekOfDayDiscountAmount, specialDiscountAmount, giftAmount, visit);
        List<Integer> discount = List.of(christmasDiscountAmount, weekOfDayDiscountAmount, specialDiscountAmount);

        return processResult(discount, giftAmount, order);
    }

    private int processResult(List<Integer> discount, int giftAmount, Order order) {

        int benefit = this.discountService.calculateTotalBenefitAmount(discount, giftAmount);
        OutputView.printTotalBenefitAmount(benefit);

        int finalAmount = this.discountService.calculateFinalAmount(benefit, giftAmount, order);
        OutputView.printFinalAmount(finalAmount);

        return benefit;
    }

    public void processEventBadge(int benefit) {
        String badge = this.badgeService.awardBadgesBasedOnAmount(benefit);
    }
}