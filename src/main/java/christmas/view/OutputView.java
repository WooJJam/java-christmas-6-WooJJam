package christmas.view;

import christmas.model.Order;
import christmas.model.OrderItem;
import christmas.model.Visit;
import christmas.model.Week;
import christmas.view.message.OutputMessage;

public class OutputView {

    public static void printOrderMenu() {
        System.out.println(OutputMessage.ORDER_MENU.getMessage());
    }
    public static void printMenuList(Order order) {
        for (OrderItem orderItem : order.getOrderItems()) {
            System.out.printf(OutputMessage.MENU_LIST.getMessage(), orderItem.getMenu(), orderItem.getQuantity());
        }
        System.out.println();

    }

    public static void printTotalAmountBeforeDiscount(Order order) {
        System.out.println(OutputMessage.TOTAL_ORDER_AMOUNT_BEFORE_DISCOUNT.getMessage());
        System.out.printf(OutputMessage.FORMAT_PRICE_WITH_COMMA.getMessage(), order.getAmount());
        System.out.println();
    }

    public static void printBenefitsHistory(int christmasDiscountAmount, int weekOfDayDiscountAmount, int specialDiscountAmount, int giftDiscountAmount, Visit visit) {
        System.out.println(OutputMessage.BENEFITS_HISTORY.getMessage());
        System.out.printf(OutputMessage.CHRISTMAS_DISCOUNT_EVENT.getMessage(), christmasDiscountAmount);
        if (visit.determineDayOfWeek() == Week.WEEKDAY) {
            System.out.printf(OutputMessage.WEEKDAY_DISCOUNT_EVENT.getMessage(), weekOfDayDiscountAmount);
        }
        if (visit.determineDayOfWeek() == Week.WEEKEND) {
            System.out.printf(OutputMessage.WEEKEND_DISCOUNT_EVENT.getMessage(), weekOfDayDiscountAmount);
        }
        System.out.printf(OutputMessage.SPECIAL_DISCOUNT_EVENT.getMessage(), specialDiscountAmount);
        System.out.printf(OutputMessage.GIFT_DISCOUNT_EVENT.getMessage(), giftDiscountAmount);
    }

    public static void printTotalBenefitAmount(int totalDiscountAmount) {
        System.out.println(OutputMessage.TOTAL_BENEFIT_AMOUNT.getMessage());
        System.out.printf(OutputMessage.TOTAL_DISCOUNT_AMOUNT.getMessage(), totalDiscountAmount);
    }
}
