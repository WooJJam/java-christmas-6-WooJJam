package christmas.model;

import christmas.validator.VisitValidate;

public class Visit {
    private final int date;
    private final Week day;

    public Visit(String inputDate) {
        VisitValidate.validate(inputDate);
        this.date = Integer.parseInt(inputDate);
        this.day = determineDayOfWeek(inputDate);
    }

    public Week determineDayOfWeek(String inputDate) {
        int startDay = 6;
        int daysFromStart = Integer.parseInt(inputDate) - 1;

        if ((startDay + daysFromStart) % 7 == 0) {
            return Week.WEEKEND;
        }
        return Week.WEEKDAY;
    }
}
