package christmas.service;

import camp.nextstep.edu.missionutils.Console;
import christmas.model.Visit;

public class PromotionService {

    public Visit setVisitDate(String inputDate) {
            return new Visit(inputDate);
    }
}
