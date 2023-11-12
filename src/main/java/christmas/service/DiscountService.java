package christmas.service;

import christmas.model.Order;
import christmas.model.Visit;
import christmas.model.event.ChristmasDiscount;
import christmas.model.event.WeekOfDayDiscount;
import christmas.view.OutputView;

public class DiscountService {

    public void setChristmasDiscountPolicy(Visit visit, Order order) {
        ChristmasDiscount christmasDiscount = new ChristmasDiscount(visit);
        OutputView.printBenefitsHistory(christmasDiscount);
        WeekOfDayDiscount weekOfDayDiscount = new WeekOfDayDiscount(visit, order);
        System.out.println("weekOfDayDiscount.getAmount() = " + weekOfDayDiscount.getAmount());
    }
}
