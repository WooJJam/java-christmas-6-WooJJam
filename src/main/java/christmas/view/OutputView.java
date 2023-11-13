package christmas.view;

import christmas.model.*;
import christmas.view.message.OutputMessage;

public class OutputView {

    public static void printOrderSummary(Order order) {
        System.out.println(OutputMessage.ORDER_MENU.getMessage());
        for (OrderItem orderItem : order.getOrderItems()) {
            System.out.printf(OutputMessage.MENU_LIST.getMessage(), orderItem.getMenu(), orderItem.getQuantity());
        }
        System.out.println();

        System.out.println(OutputMessage.TOTAL_ORDER_AMOUNT_BEFORE_DISCOUNT.getMessage());
        System.out.printf(OutputMessage.FORMAT_PRICE_WITH_COMMA.getMessage(), order.getAmount());
        System.out.println();

        System.out.println(OutputMessage.GIFT_MENU_NAME.getMessage());
        System.out.printf(OutputMessage.GIFT_MENU.getMessage(), Menu.CHAMPAGNE.getName(), 1);
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
        System.out.println();
    }

    public static void printTotalBenefitAmount(int totalBenefitAmount) {
        System.out.println(OutputMessage.TOTAL_BENEFIT_AMOUNT.getMessage());
        System.out.printf(OutputMessage.TOTAL_DISCOUNT_AMOUNT.getMessage(), totalBenefitAmount);
        System.out.println();
    }

    public static void printFinalAmount(int finalAmount) {
        System.out.println(OutputMessage.ESTIMATED_AMOUNT_AFTER_DISCOUNT.getMessage());
        System.out.printf(OutputMessage.FINAL_AMOUNT.getMessage(),finalAmount);
        System.out.println();
    }

    public static void printEventBadge(String badge) {
        System.out.println(OutputMessage.DECEMBER_EVENT_BADGE.getMessage());
        System.out.printf(OutputMessage.EVENT_BADGE.getMessage(),badge);
    }

}
