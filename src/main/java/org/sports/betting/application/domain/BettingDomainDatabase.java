package org.sports.betting.application.domain;

import java.util.HashSet;

import java.util.Set;

import org.sports.betting.application.domain.bet.Bet;
import org.sports.betting.application.domain.outcome.Outcome;
import org.sports.betting.application.domain.sportevent.SportEvent;
import org.sports.betting.application.domain.user.Player;

public class BettingDomainDatabase {

    private static Set<SportEvent> footballEvents = new HashSet<SportEvent>();
    private static Set<SportEvent> tennisEvents = new HashSet<SportEvent>();
    private static Set<SportEvent> events = new HashSet<SportEvent>();

    private static Set<Bet> bets = new HashSet<Bet>();

    private static Set<Outcome> outcomes = new HashSet<Outcome>();

    private static Set<Player> players = new HashSet<Player>();

    public static Set<SportEvent> getEvents() {
        return events;
    }

    public static Set<SportEvent> getFootballEvents() {
        return footballEvents;
    }

    public static Set<SportEvent> getTennisEvents() {
        return tennisEvents;
    }

    public static Set<Bet> getBets() {
        return bets;
    }

    public static Set<Outcome> getOutcomes() {
        return outcomes;
    }

    public static Set<Player> getPlayers() {
        return players;
    }

    public static SportEvent getEventByTitle(String title) {
        for (SportEvent event : events) {
            if (event.getTitle().equals(title)) {
                return event;
            }
        }
        System.out.println("No events found with the given title :(");
        return null;
    }

    public static Bet getBet(String description) {
        for (Bet bet : bets) {
            if (bet.getDescription().equals(description)) {
                return bet;
            }
        }
        System.out.println("No bets found with the given description :(");
        return null;
    }

    public static Outcome getOutcome(Bet bet, String value) {
        for (Outcome outcome : outcomes) {
            if (outcome.getBet() == bet && outcome.getValue().equals(value)) {
                return outcome;
            }
        }
        System.out.println("No outcomes found with the given bet & value :(");
        return null;
    }

    public static Outcome choseOutcome(Bet bet, char outcomeLetter) {
        for (Outcome outcome : outcomes) {
            if (outcomeLetter == outcome.getValue().charAt(0)) {
                return outcome;
            }
        }
        return null;
    }

}
