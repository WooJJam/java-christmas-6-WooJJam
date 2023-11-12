package christmas.validator;

import christmas.constant.VisitConstant;
import christmas.exception.VisitException;
import christmas.exception.message.VisitExceptionMessage;

import java.util.regex.Pattern;

public class VisitValidate implements VisitConstant {
    
    public static void validate(String inputDate) {
        validateNumeric(inputDate);
        int date = Integer.parseInt(inputDate);
        validateRange(date);
    }

    private static void validateNumeric(String inputDate) {
        Pattern DATE_REGEX = Pattern.compile(INPUT_DATE_REGEX);
        if (!DATE_REGEX.matcher(inputDate).matches()) {
            throw new VisitException(VisitExceptionMessage.NOT_INTEGER_VALUE);
        }
    }

    private static void validateRange(int date) {
        if (!(date >= MIN_DATE_RANGE && date <= MAX_DATE_RANGE)) {
            throw new VisitException(VisitExceptionMessage.INVALID_DATE_RANGE);
        }
    }
}
