package christmas.controller;

import christmas.model.date.Visit;
import christmas.service.DateService;

public class DateController {
    private final DateService dateService = new DateService();

    public Visit inputVisitDate() {

        return this.dateService.determineVisitDate();
    }

}
