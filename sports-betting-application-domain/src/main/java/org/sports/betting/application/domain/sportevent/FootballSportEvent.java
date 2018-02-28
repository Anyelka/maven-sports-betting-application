package org.sports.betting.application.domain.sportevent;

import java.time.LocalDateTime;

import org.sports.betting.application.domain.BettingDomainDatabase;

public class FootballSportEvent extends SportEvent {

    // Constructors:
    public FootballSportEvent() {
        BettingDomainDatabase.getFootballEvents().add(this);
    }

    public FootballSportEvent(String title, LocalDateTime startDate, LocalDateTime endDate) {
        BettingDomainDatabase.getFootballEvents().add(this);
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Getters & setters:

}
