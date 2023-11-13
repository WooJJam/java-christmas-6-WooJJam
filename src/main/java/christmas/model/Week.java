package christmas.model;

public enum Week {
    WEEKEND("주말"),
    WEEKDAY("평일");

    private final String name;
    Week(String day) {
        this.name = day;
    }

    public String getName() {
        return name;
    }
}
