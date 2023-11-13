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
import christmas.view.message.OutputMessage;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class EventController {

    private final DiscountService discountService = new DiscountService();
    private final BadgeService badgeService = new BadgeService();

    public int applyEventPolicy(Visit visit, Order order) {

        ChristmasDiscount christmasDiscount = this.discountService.applyChristmasDiscountPolicy(visit);
        int christmasDiscountAmount = christmasDiscount.getAmount();

        WeekOfDayDiscount weekOfDayDiscount = this.discountService.applyWeekOfDayDiscountPolicy(visit, order);
        int weekOfDayDiscountAmount = weekOfDayDiscount.getAmount();
        SpecialDiscount specialDiscount = this.discountService.applySpecialDiscountPolicy(visit);
        int specialDiscountAmount = specialDiscount.getAmount();
        GiftDiscount giftDiscount = this.discountService.applyGiftPolicy(order);
        int giftAmount = giftDiscount.getAmount();

        OutputView.printBenefitsHistory(christmasDiscount,weekOfDayDiscount,specialDiscount,giftDiscount,order,visit);

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

//        OutputView.printBenefitsHistory(discount, giftAmount, order, visit);
        OutputView.printTotalBenefitAmount(benefit);
        OutputView.printFinalAmount(finalAmount);

        return benefit;
    }

    public void processEventBadge(int benefit) {
        String badge = this.badgeService.awardBadgesBasedOnAmount(benefit);
        OutputView.printEventBadge(badge);
    }
}