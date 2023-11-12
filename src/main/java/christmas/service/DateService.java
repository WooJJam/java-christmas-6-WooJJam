package christmas.service;

import christmas.model.Visit;
import christmas.view.InputView;

public class DateService {

    public Visit determineVisitDate() {

        try {
            String inputDate = InputView.readDate();
            return new Visit(inputDate);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return determineVisitDate();
        }
    }
}
