package org.sports.betting.application.app.ui;

import java.util.List;
import java.util.Set;

import org.sports.betting.application.domain.BettingDomainDatabase;
import org.sports.betting.application.domain.bet.Bet;
import org.sports.betting.application.domain.outcome.Outcome;
import org.sports.betting.application.domain.sportevent.SportEvent;

public class TestDataUI {

    public static void listBets() {
        System.out.println("Chose your bet! Available bets:");
        String eventTitle1 = "Arsenal - Chelsea";
        SportEvent event1 = BettingDomainDatabase.getEventByTitle(eventTitle1);
        BettingDomainUI.displayEvent(event1);
        BettingDomainUI.displayBet("Arsenal - Chelsea" + " -- " + "Full Time Result", 1);
        BettingDomainUI.displayBet("Arsenal - Chelsea" + " -- " + "Goals Over/Under (2.5)", 2);

        String eventTitle2 = "Everton - Manchester United";
        SportEvent event2 = BettingDomainDatabase.getEventByTitle(eventTitle2);
        BettingDomainUI.displayEvent(event2);
        BettingDomainUI.displayBet("Everton - Manchester United" + " -- " + "Full Time Result", 3);

        String eventTitle3 = "Shapovalov - Edmund";
        SportEvent event3 = BettingDomainDatabase.getEventByTitle(eventTitle3);
        BettingDomainUI.displayEvent(event3);
        BettingDomainUI.displayBet("Shapovalov - Edmund" + " -- " + "Winner", 4);
    }

    public static void listEvents() {
        Set<SportEvent> footballEvents = BettingDomainDatabase.getFootballEvents();
        Set<SportEvent> tennisEvents = BettingDomainDatabase.getTennisEvents();

        System.out.println("Available events are listed below:\n-FOOTBALL:");
        BettingDomainUI.displayAllEvents(footballEvents);

        System.out.println("-TENNIS:");
        BettingDomainUI.displayAllEvents(tennisEvents);
    }

    public static List<Outcome> listOutcomes(Bet chosenBet) {
        System.out.println("Chosen bet:\t" + chosenBet.getDescription());
        System.out.println("Chose one of the outcomes: (Write the first letter of the outcome,eg. H for HOME, O for OVER ...) ");
        BettingDomainUI.displayOutcomes(chosenBet);
        System.out.println();
        return chosenBet.getOutcomes();
    }

    public static Bet choseBet(int betNumber) {
        switch (betNumber) {
        case 1:
            return BettingDomainDatabase.getBet("Arsenal - Chelsea" + " -- " + "Full Time Result");
        case 2:
            return BettingDomainDatabase.getBet("Arsenal - Chelsea" + " -- " + "Goals Over/Under (2.5)");
        case 3:
            return BettingDomainDatabase.getBet("Everton - Manchester United" + " -- " + "Full Time Result");
        case 4:
            return BettingDomainDatabase.getBet("Shapovalov - Edmund" + " -- " + "Winner");
        }
        return null;
    }

}
