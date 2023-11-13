package christmas.service;

import christmas.model.event.Badge;

public class BadgeService {
    
    public String awardBadgesBasedOnAmount(int benefit) {
        return Badge.getBadge(benefit);
    }
}
