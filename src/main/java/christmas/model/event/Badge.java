package christmas.model.event;

public enum Badge {
    STAR(5000, "별"),
    TREE(10000, "트리"),
    SANTA(20000, "산타");

    private final int benefit;
    private final String label;

    Badge(int benefit, String label) {
        this.benefit = benefit;
        this.label = label;
    }

    public static String getBadge(int amount) {
        String result = "없음" ;
        for (Badge badge : Badge.values()) {
            if (amount >= badge.benefit) {
                result = badge.label;
            }
        }
        return result;
    }
}
