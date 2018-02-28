package org.sports.betting.application.domain.outcome;

import java.time.LocalDateTime;

public class OutcomeOdd {
    private Outcome outcome;
    private double odd;
    private LocalDateTime validFrom;
    private LocalDateTime validTo;

    public OutcomeOdd() {
    }

    public OutcomeOdd(double odd, LocalDateTime validFrom, LocalDateTime validTo) {
        this.odd = odd;
        this.validFrom = validFrom;
        this.validTo = validTo;
    }
    // Getters & setters:

    public double getOdd() {
        return odd;
    }

    public void setOdd(double odd) {
        this.odd = odd;
    }

    public LocalDateTime getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(LocalDateTime validFrom) {
        this.validFrom = validFrom;
    }

    public LocalDateTime getValidTo() {
        return validTo;
    }

    public void setValidTo(LocalDateTime validTo) {
        this.validTo = validTo;
    }

    public Outcome getOutcome() {
        return outcome;
    }

    public void setOutcome(Outcome outcome) {
        this.outcome = outcome;
    }
}
