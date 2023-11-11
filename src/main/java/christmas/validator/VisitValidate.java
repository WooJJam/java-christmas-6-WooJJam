package christmas.validator;

import java.util.regex.Pattern;

public class VisitValidate {

    public static final String INPUT_DATE_REGEX = "^[0-9]*$";

    public static void validate(String inputDate) {
        validateNumeric(inputDate);
        int date = Integer.parseInt(inputDate);
        validateRange(date);
    }

    private static void validateNumeric(String inputDate) {
        Pattern DATE_REGEX = Pattern.compile(INPUT_DATE_REGEX);
        if (!DATE_REGEX.matcher(inputDate).matches()) {
            throw new IllegalArgumentException("[ERROR] 올바른 형식이 아닙니다.");
        }
    }

    private static void validateRange(int date) {
        if (!(date >= 1 && date <= 31)) {
            throw new IllegalArgumentException("[ERROR] 날짜는 1에서 31 사이어야 합니다. 다시 입력해주세요.");
        }
    }
}
