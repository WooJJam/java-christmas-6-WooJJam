package christmas.controller;

import camp.nextstep.edu.missionutils.Console;
import christmas.model.Visit;
import christmas.service.PromotionService;

public class PromotionController {
    private final PromotionService promotionService;
    public static final String INPUT_DATE_REGEX = "^[0-9]*$";

    public PromotionController(PromotionService promotionService) {
        this.promotionService = promotionService;
    }

    public void run() {
        inputVisitDate();
    }

    public void inputVisitDate() {
        try {
            System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
            String inputDate = Console.readLine();
            Visit visit = this.promotionService.setVisitDate(inputDate);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            inputVisitDate();
        }

    }
}
