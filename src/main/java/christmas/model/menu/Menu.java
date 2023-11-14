package christmas.model.menu;

import christmas.constant.MenuConstant;

public enum Menu implements MenuConstant {

    YANGSONG_SOUP(YANGSONG_SOUP_NAME, YANGSONG_SOUP_PRICE, Category.APPETIZER),
    TAPAS(TAPAS_NAME, TAPAS_PRICE, Category.APPETIZER),
    CAESAR_SALAD(CAESAR_SALAD_NAME, CAESAR_SALAD_PRICE, Category.APPETIZER),

    T_BONE_STEAK(T_BONE_STEAK_NAME, T_BONE_STEAK_PRICE, Category.MAIN_COURSE),
    BBQ_RIB(BBQ_RIB_NAME, BBQ_RIB_PRICE, Category.MAIN_COURSE),
    SEAFOOD_PASTA(SEAFOOD_PASTA_NAME, SEAFOOD_PASTA_PRICE, Category.MAIN_COURSE),
    CHRISTMAS_PASTA(CHRISTMAS_PASTA_NAME, CHRISTMAS_PASTA_PRICE, Category.MAIN_COURSE),

    CHOCO_CAKE(CHOCO_CAKE_NAME, CHOCO_CAKE_PRICE, Category.DESSERT),
    ICE_CREAM(ICE_CREAM_NAME, ICE_CREAM_PRICE, Category.DESSERT),

    ZERO_COLA(ZERO_COLA_NAME, ZERO_COLA_PRICE, Category.BEVERAGE),
    RED_WINE(RED_WINE_NAME, RED_WINE_PRICE, Category.BEVERAGE),
    CHAMPAGNE(CHAMPAGNE_NAME, CHAMPAGNE_PRICE, Category.BEVERAGE);

    private final String name;
    private final int price;
    private final Category category;

    Menu(String name, int price, Category category) {

        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }
}
