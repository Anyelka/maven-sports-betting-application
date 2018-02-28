package org.sports.betting.application.domain.sportevent;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.sports.betting.application.domain.BettingDomainDatabase;
import org.sports.betting.application.domain.bet.Bet;

public class SportEvent {

    protected String title;
    protected LocalDateTime startDate;
    protected LocalDateTime endDate;
    protected Set<Bet> bets = new HashSet<Bet>();
    protected Result result;

    // Constructors:
    public SportEvent() {
        BettingDomainDatabase.getEvents().add(this);
    };

    public SportEvent(String title, LocalDateTime startDate, LocalDateTime endDate) {
        BettingDomainDatabase.getEvents().add(this);
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
    };

    // Getters & setters:

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Set<Bet> getBets() {
        return bets;
    }

    public void setBets(Set<Bet> bets) {
        this.bets = bets;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public String getTitle() {
        return this.title;
    }

    public String getStartDate() {
        return this.startDate.toString();
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
