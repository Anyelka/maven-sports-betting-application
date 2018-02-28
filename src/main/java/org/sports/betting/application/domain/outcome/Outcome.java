package org.sports.betting.application.domain.outcome;


import org.sports.betting.application.domain.BettingDomainDatabase;
import org.sports.betting.application.domain.bet.Bet;

public class Outcome {
    private Bet bet;
    private String value;
    private OutcomeOdd odd;

    public Outcome(Bet bet, String value, OutcomeOdd odd) {
        BettingDomainDatabase.getOutcomes().add(this);
        this.bet = bet;
        this.value = value;
        this.odd = odd;
    }

    public Bet getBet() {
        return bet;
    }

    public void setBet(Bet bet) {
        this.bet = bet;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public OutcomeOdd getOdd() {
        return odd;
    }

    public void setOdd(OutcomeOdd odd) {
        this.odd = odd;
    }

}
