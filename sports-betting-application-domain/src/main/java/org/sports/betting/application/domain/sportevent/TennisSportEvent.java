package org.sports.betting.application.domain.sportevent;

import java.time.LocalDateTime;

import org.sports.betting.application.domain.BettingDomainDatabase;

public class TennisSportEvent extends SportEvent {

    public TennisSportEvent() {
        BettingDomainDatabase.getTennisEvents().add(this);
    }

    public TennisSportEvent(String title, LocalDateTime startDate, LocalDateTime endDate) {
        BettingDomainDatabase.getTennisEvents().add(this);
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
    }

}
