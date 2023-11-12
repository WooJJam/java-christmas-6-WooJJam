package christmas.controller;

import christmas.model.Visit;
import christmas.service.DateService;

public class DateController {
    private final DateService dateService = new DateService();
    public Visit inputVisitDate() {
        Visit visit = this.dateService.determineVisitDate();
        return visit;
    }

}
