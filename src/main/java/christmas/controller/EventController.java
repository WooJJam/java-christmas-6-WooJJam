package christmas.controller;

import christmas.model.Order;
import christmas.model.Visit;
import christmas.service.DiscountService;
import christmas.view.OutputView;

import java.util.List;

public class EventController {

    private final DiscountService discountService = new DiscountService();

    public List<Integer> setDiscountPolicy(Visit visit, Order order) {

       int christmasDiscountAmount = this.discountService.applyChristmasDiscountPolicy(visit);
       int weekOfDayDiscountAmount = this.discountService.applyWeekOfDayDiscountPolicy(visit,order);
       int specialDiscountAmount = this.discountService.applySpecialDiscountPolicy(visit);
       int giftDiscountAmount = this.discountService.applyGiftDiscountPolicy(order);

        OutputView.printBenefitsHistory (christmasDiscountAmount, weekOfDayDiscountAmount, specialDiscountAmount, giftDiscountAmount, visit);

        return List.of(christmasDiscountAmount,weekOfDayDiscountAmount,specialDiscountAmount,giftDiscountAmount);

    }

    public void processTotalDiscountAmount(List<Integer> discount, Order order) {
        int totalDiscountAmount = this.discountService.calculateTotalDiscountAmount(discount);
        OutputView.printTotalBenefitAmount(totalDiscountAmount);
        int finalAmount = this.discountService.calculateFinalAmount(totalDiscountAmount, order);
        OutputView.printFinalAmount(finalAmount);
    }
}