package org.sports.betting.application.app.ui;

import java.util.Set;

import org.sports.betting.application.domain.BettingDomainDatabase;
import org.sports.betting.application.domain.bet.Bet;
import org.sports.betting.application.domain.outcome.Outcome;
import org.sports.betting.application.domain.sportevent.SportEvent;
import org.sports.betting.application.domain.user.Player;

public class BettingDomainUI {

    public static void displayEvent(SportEvent event) {
        System.out.print("\n" + event.getTitle());
        String eventDate = event.getStartDate();
        System.out.print("  -  date: " + eventDate.substring(0, eventDate.indexOf("T")) + ", " + eventDate.substring((eventDate.indexOf("T") + 1)));

    }

    public static void displayAllEvents(Set<SportEvent> events) {
        for (SportEvent event : events) {
            System.out.println("\t-> '" + event.getTitle() + "'");
        }

    }

    public static void displayBet(String description, int option) {
        System.out.println();
        Bet bet = BettingDomainDatabase.getBet(description);
        System.out.println(" - PRESS [" + option + "]" + "> Bet for " + formatBD(bet.getDescription()));
        displayOutcomes(bet);
    }

    public static void displayBets(SportEvent event) {
        Set<Bet> bets = event.getBets();
        System.out.println();
        for (Bet bet : bets) {
            System.out.println("\t-> Bet for: " + formatBD(bet.getDescription()));
            displayOutcomes(bet);
            System.out.println();
        }
    }

    public static void displayOutcomes(Bet bet) {
        System.out.print("");
        for (Outcome outcome : BettingDomainDatabase.getOutcomes()) {
            if (outcome.getBet().equals(bet)) {
                System.out.print("\t" + outcome.getValue());
                System.out.print(" = " + outcome.getOdd().getOdd());
            }
        }
    }

    public static void displayChosenBet(Bet chosenBet, Outcome chosenOutcome, int stake, Player currentPlayer) {
        System.out.println(
                "Your bet:  " + chosenBet.getDescription() + " -- " + chosenOutcome.getValue() + " -- Stake: " + stake + " " + currentPlayer.getCurrency());
    }

    public static String formatBD(String string) {
        String rtn = string.substring(string.indexOf("-"), string.length()).substring(1);
        rtn = rtn.substring(rtn.indexOf("-"), rtn.length()).substring(1);
        rtn = rtn.substring(rtn.indexOf("-"), rtn.length()).substring(1);
        return rtn;
    }
}
