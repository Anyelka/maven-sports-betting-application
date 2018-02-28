package org.sports.betting.application.domain.bet;

import java.util.ArrayList;
import java.util.List;

import org.sports.betting.application.domain.BettingDomainDatabase;
import org.sports.betting.application.domain.outcome.Outcome;
import org.sports.betting.application.domain.sportevent.SportEvent;


public class Bet {
    private SportEvent event;
    private String description;
    private List<Outcome> outcomes = new ArrayList<Outcome>();
    private BetType betType;

    // Constructors:
    public Bet() {
        BettingDomainDatabase.getBets().add(this);
    }

    public Bet(SportEvent event, String description, BetType betType) {
        BettingDomainDatabase.getBets().add(this);
        this.event = event;
        this.description = description;
        this.betType = betType;
    }

    // Getters & Setters:
    public SportEvent getEvent() {
        return event;
    }

    public void setEvent(SportEvent event) {
        this.event = event;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Outcome> getOutcomes() {
        return outcomes;
    }

    public void setOutcomes(List<Outcome> outcomes) {
        this.outcomes = outcomes;
    }

    public BetType getBetType() {
        return betType;
    }

    public void setBetType(BetType betType) {
        this.betType = betType;
    }

}
