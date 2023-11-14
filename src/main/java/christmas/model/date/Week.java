package christmas.model.date;

import christmas.constant.DateConstant;

public enum Week implements DateConstant {

    WEEKEND(WEEKEND_CONSTANT),
    WEEKDAY(WEEKDAY_CONSTANT);

    private final String name;
    Week(String day) {
        this.name = day;
    }

    public String getName() {
        return name;
    }
}
