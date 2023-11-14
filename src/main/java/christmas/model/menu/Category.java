package christmas.model.menu;

import christmas.constant.MenuConstant;

import java.util.Arrays;

public enum Category implements MenuConstant {
    APPETIZER(CATEGORY_COUNT),
    MAIN_COURSE(CATEGORY_COUNT),
    DESSERT(CATEGORY_COUNT),
    BEVERAGE(CATEGORY_COUNT);

    private int count;

    Category(int count) {
        this.count = count;
    }


    public int getCount() {
        return count;
    }

    public static int getTotalCount() {

        return Arrays.stream(Category.values())
                .mapToInt(Category::getCount)
                .sum();
    }

    public void addCount(int quantity) {
        count += quantity;
    }

}
