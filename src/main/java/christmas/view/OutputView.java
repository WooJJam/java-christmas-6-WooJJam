package christmas.view;

import christmas.model.*;
import christmas.view.message.OutputMessage;

import java.util.Map;

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

        printGiftMenu(order);
    }

    private static void printGiftMenu(Order order) {
        System.out.println(OutputMessage.GIFT_MENU_NAME.getMessage());
        if (order.getAmount() >= 120000) {
            System.out.printf(OutputMessage.GIFT_MENU.getMessage(), Menu.CHAMPAGNE.getName(), 1);
            System.out.println();
        }

        if (order.getAmount() < 120000) {
            System.out.println(OutputMessage.NONE_GIFT_MENU.getMessage());
        }
    }

    public static void printBenefitsHistory(Map<String, Integer> discount, int giftAmount, Visit visit) {
        System.out.println(OutputMessage.BENEFITS_HISTORY.getMessage());
        System.out.printf(OutputMessage.CHRISTMAS_DISCOUNT_EVENT.getMessage(), discount.get("christmas"));
        if (visit.determineDayOfWeek() == Week.WEEKDAY) {
            System.out.printf(OutputMessage.WEEKDAY_DISCOUNT_EVENT.getMessage(), discount.get("weekOfDay"));
        }
        if (visit.determineDayOfWeek() == Week.WEEKEND) {
            System.out.printf(OutputMessage.WEEKEND_DISCOUNT_EVENT.getMessage(), discount.get("weekOfDay"));
        }
        System.out.printf(OutputMessage.SPECIAL_DISCOUNT_EVENT.getMessage(), discount.get("special"));
        System.out.printf(OutputMessage.GIFT_DISCOUNT_EVENT.getMessage(), giftAmount);
        System.out.println();
    }

    public static void printTotalBenefitAmount(int totalBenefitAmount) {
        System.out.println(OutputMessage.TOTAL_BENEFIT_AMOUNT.getMessage());
        System.out.printf(OutputMessage.TOTAL_DISCOUNT_AMOUNT.getMessage(), totalBenefitAmount);
        System.out.println();
    }

    public static void printFinalAmount(int finalAmount) {
        System.out.println(OutputMessage.ESTIMATED_AMOUNT_AFTER_DISCOUNT.getMessage());
        System.out.printf(OutputMessage.FINAL_AMOUNT.getMessage(), finalAmount);
        System.out.println();
    }

    public static void printEventBadge(String badge) {
        System.out.println(OutputMessage.DECEMBER_EVENT_BADGE.getMessage());
        System.out.printf(OutputMessage.EVENT_BADGE.getMessage(), badge);
    }

}
