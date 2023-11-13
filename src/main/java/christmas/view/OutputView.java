package christmas.view;

import christmas.model.*;
import christmas.model.event.ChristmasDiscount;
import christmas.model.event.GiftDiscount;
import christmas.model.event.SpecialDiscount;
import christmas.model.event.WeekOfDayDiscount;
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

        printGiftMenu(order);
    }

    private static void printGiftMenu(Order order) {
        System.out.println(OutputMessage.GIFT_MENU_NAME.getMessage());
        printGiftMenuOver(order);
        printGiftMenuUnder(order);
    }

    private static void printGiftMenuOver(Order order) {
        if (order.getAmount() >= 120000) {
            System.out.printf(OutputMessage.GIFT_MENU.getMessage(), Menu.CHAMPAGNE.getName(), 1);
            System.out.println();
        }
    }

    private static void printGiftMenuUnder(Order order) {
        if (order.getAmount() < 120000) {
            System.out.println(OutputMessage.NON_EXIST.getMessage());
        }
    }

    public static void printBenefitsHistory(ChristmasDiscount christmasDiscount, WeekOfDayDiscount weekOfDayDiscount, SpecialDiscount specialDiscount, GiftDiscount giftDiscount, Order order, Visit visit) {
        System.out.println(OutputMessage.BENEFITS_HISTORY.getMessage());
        if (order.getAmount() < 10000) {
            System.out.println(OutputMessage.NON_EXIST.getMessage());
        }
        if (order.getAmount() >= 10000) {
            if (christmasDiscount.getAmount() != 0) {
                System.out.printf(OutputMessage.CHRISTMAS_DISCOUNT_EVENT.getMessage(), christmasDiscount.getAmount());
            }
            if (visit.determineDayOfWeek() == Week.WEEKDAY && weekOfDayDiscount.getAmount() != 0) {
                System.out.printf(OutputMessage.WEEKDAY_DISCOUNT_EVENT.getMessage(), visit.getDay().getName(),weekOfDayDiscount.getAmount());
            }
            if (visit.determineDayOfWeek() == Week.WEEKEND && weekOfDayDiscount.getAmount() != 0) {
                System.out.printf(OutputMessage.WEEKEND_DISCOUNT_EVENT.getMessage(), visit.getDay().getName(), weekOfDayDiscount.getAmount());
            }
            if (specialDiscount.getAmount() != 0) {
                System.out.printf(OutputMessage.SPECIAL_DISCOUNT_EVENT.getMessage(), specialDiscount.getAmount());
            }
            if (giftDiscount.getAmount() != 0) {
                System.out.printf(OutputMessage.GIFT_DISCOUNT_EVENT.getMessage(), giftDiscount.getAmount());
            }
            System.out.println();
        }
    }

    public static void printTotalBenefitAmount(int totalBenefitAmount) {
        System.out.println(OutputMessage.TOTAL_BENEFIT_AMOUNT.getMessage());
        if (totalBenefitAmount != 0) {
            System.out.printf(OutputMessage.TOTAL_DISCOUNT_AMOUNT.getMessage(), totalBenefitAmount);
        }
        if (totalBenefitAmount == 0) {
            System.out.printf(OutputMessage.NONE_TOTAL_DISCOUNT_AMOUNT.getMessage(), totalBenefitAmount);
        }
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
