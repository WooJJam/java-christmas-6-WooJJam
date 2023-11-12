package christmas.model;

import christmas.constant.VisitConstant;
import christmas.validator.VisitValidate;

public class Visit implements VisitConstant {
    private final int date;
    private final Week day;

    public Visit(String inputDate) {
        VisitValidate.validate(inputDate);
        this.date = Integer.parseInt(inputDate);
        this.day = determineDayOfWeek(inputDate);
    }

    public Week determineDayOfWeek(String inputDate) {
        int daysFromStart = Integer.parseInt(inputDate) - CALCULATE_ONE;

        if ((START_DAY + daysFromStart) % DAY_OF_WEEK_COUNT == MODULA_RESULT_ZERO) {
            return Week.WEEKEND;
        }
        return Week.WEEKDAY;
    }
}
