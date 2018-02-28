package org.sports.betting.application.domain.sportevent;

import java.util.List;

import org.sports.betting.application.domain.outcome.Outcome;

import org.sports.betting.application.domain.bet.Bet;

public class Result {
    private SportEvent event;
    private List<Outcome> outcomes;

    public Result(SportEvent event, List<Outcome> outcomes) {
        super();
        this.event = event;
        this.outcomes = outcomes;
    }

    public SportEvent getEvent() {
        return event;
    }

    public void setEvent(SportEvent event) {
        this.event = event;
    }

    public List<Outcome> getOutcomes() {
        return outcomes;
    }

    public void setOutcomes(List<Outcome> outcomes) {
        this.outcomes = outcomes;
    }

    public Outcome getOutcome(Bet bet) {
        for (Outcome outcome : getOutcomes()) {
            if (outcome.getBet().equals(bet)) {
                return outcome;
            }
        }
        return null;
    }
}
