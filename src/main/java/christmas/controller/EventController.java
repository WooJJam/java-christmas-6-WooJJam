package christmas.controller;

import christmas.model.Order;
import christmas.model.Visit;
import christmas.model.event.ChristmasDiscount;
import christmas.service.DiscountService;

public class EventController {

    private final DiscountService discountService = new DiscountService();

    public void applyDiscountPolicy(Visit visit, Order order) {
        this.discountService.setChristmasDiscountPolicy(visit, order);
    }
}
