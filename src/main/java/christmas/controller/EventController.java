package christmas.controller;

import christmas.model.Order;
import christmas.model.Visit;
import christmas.model.event.ChristmasDiscount;
import christmas.model.event.GiftDiscount;
import christmas.model.event.SpecialDiscount;
import christmas.model.event.WeekOfDayDiscount;
import christmas.service.DiscountService;
import christmas.view.OutputView;

import java.util.List;

public class EventController {

    private final DiscountService discountService = new DiscountService();

    public void applyDiscountPolicy(Visit visit, Order order) {

        int christmasDiscountAmount = this.discountService.applyChristmasDiscountPolicy(visit);
        int weekOfDayDiscountAmount = this.discountService.applyWeekOfDayDiscountPolicy(visit, order);
        int specialDiscountAmount = this.discountService.applySpecialDiscountPolicy(visit);
        int giftDiscountAmount = this.discountService.applyGiftDiscountPolicy(order);

        OutputView.printBenefitsHistory(christmasDiscountAmount, weekOfDayDiscountAmount, specialDiscountAmount, giftDiscountAmount, visit);

    }
}