package christmas.constant;

public interface OrderConstant {
    static final String INPUT_ORDER_ITEM_REGEX = "([가-힣]+)-([0-9]+)";
    static final String INPUT_ORDER_REPLACE_BLANK_REGEX = " ";
    static final String INPUT_ORDER_REPLACE_REPLACEMENT= "";
    static final String INPUT_ORDER_SPLIT_DELIMITER_REGEX= ",";
    static final String INPUT_ORDER_SPLIT_HYPHEN_REGEX = "-";
    static final int MATCHER_GROUP_FIRST = 1;
    static final int MATCHER_GROUP_SECOND = 2;
}