package christmas.model.event;

import christmas.constant.EventConstant;

public enum Badge implements EventConstant {
    STAR(STAR_BADGE_BENEFIT, START_BADGE_LABEL),
    TREE(TREE_BADGE_BENEFIT, TREE_BADGE_LABEL),
    SANTA(SANTA_BADGE_BENEFIT, SANTA_BADGE_LABEL);

    private final int benefit;
    private final String label;

    Badge(int benefit, String label) {
        this.benefit = benefit;
        this.label = label;
    }

    public static String getBadge(int amount) {

        String result = BADGE_RESULT ;

        for (Badge badge : Badge.values()) {
            if (amount >= badge.benefit) {
                result = badge.label;
            }
        }

        return result;
    }
}
