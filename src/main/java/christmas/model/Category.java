package christmas.model;

import java.util.Arrays;

public enum Category {
    APPETIZER(0),
    MAIN_COURSE(0),
    DESSERT(0),
    BEVERAGE(0);

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
