package christmas.model.date;

import christmas.constant.DateConstant;
import christmas.constant.VisitConstant;
import christmas.validator.VisitValidate;

public class Visit implements VisitConstant, DateConstant {
    private final int date;
    private final Week day;

    public Visit(String inputDate) {

        VisitValidate.validate(inputDate);
        this.date = Integer.parseInt(inputDate);
        this.day = determineDayOfWeek();
    }

    public Week determineDayOfWeek() {

        if(WEEKEND_DAYS.contains(date)) {
            return Week.WEEKEND;
        }

        return Week.WEEKDAY;
    }

    public int getDate() {
        return date;
    }

    public Week getDay() {
        return day;
    }
}
