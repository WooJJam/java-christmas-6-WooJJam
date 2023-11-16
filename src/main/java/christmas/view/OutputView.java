package christmas.view;

import christmas.constant.ViewConstant;
import christmas.model.date.Visit;
import christmas.model.date.Week;
import christmas.model.event.ChristmasDiscount;
import christmas.model.event.GiftDiscount;
import christmas.model.event.SpecialDiscount;
import christmas.model.event.WeekOfDayDiscount;
import christmas.model.menu.Menu;
import christmas.model.order.Order;
import christmas.model.order.OrderItem;
import christmas.view.message.OutputMessage;

public class OutputView implements ViewConstant {

    public static void printOrderSummary(Order order) {

        System.out.println(OutputMessage.ORDER_MENU.getMessage());
        printMenuList(order);
        System.out.println();

        System.out.println(OutputMessage.TOTAL_ORDER_AMOUNT_BEFORE_DISCOUNT.getMessage());
        System.out.printf(OutputMessage.FORMAT_PRICE_WITH_COMMA.getMessage(), order.getAmount());
        System.out.println();

        printGiftMenu(order);
    }

    private static void printMenuList(Order order) {

        for (OrderItem orderItem : order.getOrderItems()) {
            System.out.printf(OutputMessage.MENU_LIST.getMessage(), orderItem.getMenu(), orderItem.getQuantity());
        }
    }

    private static void printGiftMenu(Order order) {

        System.out.println(OutputMessage.GIFT_MENU_NAME.getMessage());
        printGiftMenuOver(order);
        printGiftMenuUnder(order);
    }

    private static void printGiftMenuOver(Order order) {

        if (order.getAmount() >=GIFT_AMOUNT_THRESHOLD) {
            System.out.printf(OutputMessage.GIFT_MENU.getMessage(), Menu.CHAMPAGNE.getName(), GIFT_CHAMPAGNE_COUNT);
            System.out.println();
        }
    }

    private static void printGiftMenuUnder(Order order) {

        if (order.getAmount() < GIFT_AMOUNT_THRESHOLD) {
            System.out.println(OutputMessage.NON_EXIST.getMessage());
        }
    }

    public static void printBenefitsHistory(ChristmasDiscount christmasDiscount, WeekOfDayDiscount weekOfDayDiscount, SpecialDiscount specialDiscount, GiftDiscount giftDiscount, Order order, Visit visit) {

        System.out.println(OutputMessage.BENEFITS_HISTORY.getMessage());
        if (order.getAmount() < ORDER_AMOUNT_THRESHOLD) {
            printLowOrderAmount(order);
        }
        if (order.getAmount() >= ORDER_AMOUNT_THRESHOLD) {
            printHighOrderAmount(christmasDiscount, weekOfDayDiscount, specialDiscount, giftDiscount, visit);
        }
    }

    private static void printLowOrderAmount(Order order) {

        System.out.println(OutputMessage.NON_EXIST.getMessage());
    }

    private static void printHighOrderAmount(ChristmasDiscount christmasDiscount, WeekOfDayDiscount weekOfDayDiscount, SpecialDiscount specialDiscount, GiftDiscount giftDiscount, Visit visit) {

        printChristmasDiscount(christmasDiscount);
        printWeekOfDayDiscount(weekOfDayDiscount, visit);
        printSpecialDiscount(specialDiscount);
        printGiftAmount(giftDiscount);
        System.out.println();
    }

    private static void printChristmasDiscount(ChristmasDiscount christmasDiscount) {

        if (christmasDiscount.getAmount() != ZERO_AMOUNT) {
            System.out.printf(OutputMessage.CHRISTMAS_DISCOUNT_EVENT.getMessage(), christmasDiscount.getAmount());
        }
    }

    private static void printWeekOfDayDiscount(WeekOfDayDiscount weekOfDayDiscount, Visit visit) {

        if (visit.determineDayOfWeek() == Week.WEEKDAY && weekOfDayDiscount.getAmount() != ZERO_AMOUNT) {
            System.out.printf(OutputMessage.WEEK_OF_DAY_DISCOUNT_EVENT.getMessage(), visit.getDay().getName(), weekOfDayDiscount.getAmount());
        }

        if (visit.determineDayOfWeek() == Week.WEEKEND && weekOfDayDiscount.getAmount() != ZERO_AMOUNT) {
            System.out.printf(OutputMessage.WEEK_OF_DAY_DISCOUNT_EVENT.getMessage(), visit.getDay().getName(), weekOfDayDiscount.getAmount());
        }
    }

    private static void printSpecialDiscount(SpecialDiscount specialDiscount) {

        if (specialDiscount.getAmount() != ZERO_AMOUNT) {
            System.out.printf(OutputMessage.SPECIAL_DISCOUNT_EVENT.getMessage(), specialDiscount.getAmount());
        }
    }

    private static void printGiftAmount(GiftDiscount giftDiscount) {

        if (giftDiscount.getAmount() != ZERO_AMOUNT) {
            System.out.printf(OutputMessage.GIFT_DISCOUNT_EVENT.getMessage(), giftDiscount.getAmount());
        }
    }

    public static void printTotalBenefitAmount(int totalBenefitAmount) {

        System.out.println(OutputMessage.TOTAL_BENEFIT_AMOUNT.getMessage());

        if (totalBenefitAmount != ZERO_AMOUNT) {
            System.out.printf(OutputMessage.TOTAL_DISCOUNT_AMOUNT.getMessage(), totalBenefitAmount);
        }
        if (totalBenefitAmount == ZERO_AMOUNT) {
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
