package org.sports.betting.application.app.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.sports.betting.application.app.ui.SBController;
import org.sports.betting.application.domain.BettingDomainDatabase;
import org.sports.betting.application.domain.bet.Bet;
import org.sports.betting.application.domain.bet.BetType;
import org.sports.betting.application.domain.outcome.Outcome;
import org.sports.betting.application.domain.outcome.OutcomeOdd;
import org.sports.betting.application.domain.sportevent.FootballSportEvent;
import org.sports.betting.application.domain.sportevent.Result;
import org.sports.betting.application.domain.sportevent.SportEvent;
import org.sports.betting.application.domain.sportevent.TennisSportEvent;
import org.sports.betting.application.domain.user.Player;

public class TestDataGenerator {
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public static void create() {
        createEvent("Everton - Manchester United", "2018-01-01 18:30", "2018-01-01 20:20", "FOOTBALL");
        createBet("Everton - Manchester United", "Full Time Result", BetType.FOOTBALL_WINNER);
        Bet bet1 = BettingDomainDatabase.getBet("Everton - Manchester United" + " -- " + "Full Time Result");
        createOutcome(bet1, "HOME", 5.75, "2018-01-01 12:00", "2018-01-03 12:00");
        createOutcome(bet1, "AWAY", 1.70, "2018-01-01 12:00", "2018-01-03 12:00");
        createOutcome(bet1, "DRAW", 3.75, "2018-01-01 12:00", "2018-01-03 12:00");
        createEvent("Arsenal - Chelsea", "2018-01-03 20:45", "2018-01-03 22:35", "FOOTBALL");
        createBet("Arsenal - Chelsea", "Full Time Result", BetType.FOOTBALL_WINNER);
        Bet bet2 = BettingDomainDatabase.getBet("Arsenal - Chelsea" + " -- " + "Full Time Result");
        createOutcome(bet2, "HOME", 2.80, "2018-01-01 12:00", "2018-01-03 12:00");
        createOutcome(bet2, "AWAY", 2.62, "2018-01-01 12:00", "2018-01-03 12:00");
        createOutcome(bet2, "DRAW", 3.50, "2018-01-01 12:00", "2018-01-03 12:00");
        createBet("Arsenal - Chelsea", "Goals Over/Under (2.5)", BetType.FOOTBALL_GOALS);
        Bet bet3 = BettingDomainDatabase.getBet("Arsenal - Chelsea" + " -- " + "Goals Over/Under (2.5)");
        createOutcome(bet3, "OVER", 1.66, "2018-01-01 12:00", "2018-01-03 12:00");
        createOutcome(bet3, "UNDER", 2.15, "2018-01-01 12:00", "2018-01-03 12:00");
        createEvent("Shapovalov - Edmund", "2018-01-02 03:30", "2018-01-02 07:20", "TENNIS");
        createBet("Shapovalov - Edmund", "Winner", BetType.TENNIS_WINNER);
        Bet bet5 = BettingDomainDatabase.getBet("Shapovalov - Edmund" + " -- " + "Winner");
        createOutcome(bet5, "HOME", 2.00, "2018-01-01 12:00", "2018-01-02 03:30");
        createOutcome(bet5, "AWAY", 1.65, "2018-01-01 12:00", "2018-01-02 03:30");
    }

    public static void createEvent(String title, String startDate, String endDate, String type) {
        LocalDateTime start = LocalDateTime.parse(startDate, formatter);
        LocalDateTime end = LocalDateTime.parse(endDate, formatter);
        if (type.equals("FOOTBALL"))
            new FootballSportEvent(title, start, end);
        else
            new TennisSportEvent(title, start, end);
    }

    public static void createBet(String eventTitle, String description, BetType betType) {
        SportEvent event = BettingDomainDatabase.getEventByTitle(eventTitle);
        String fullDescription = (eventTitle + " -- " + description);

        Bet bet = new Bet(event, fullDescription, betType);
        BettingDomainDatabase.getEventByTitle(eventTitle).getBets().add(bet);
    }

    public static void createOutcome(Bet bet, String value, double oddValue, String validFrom, String validTo) {
        OutcomeOdd odd = createOutcomeOdd(oddValue, validFrom, validTo);

        Outcome outcome = new Outcome(bet, value, odd);
        bet.getOutcomes().add(outcome);
    }

    public static OutcomeOdd createOutcomeOdd(double oddValue, String validFrom, String validTo) {
        LocalDateTime from = LocalDateTime.parse(validFrom, formatter);
        LocalDateTime to = LocalDateTime.parse(validTo, formatter);

        OutcomeOdd odd = new OutcomeOdd(oddValue, from, to);
        return odd;
    }

    public static Player createPlayer() {
        String[] string = { "Tak�cs M�rton", "1234-5678-9101112", "5000", "HUF", "1995-02-16" };
        Player player = PlayerService.createPlayer(string);
        System.out.println("Player succesfully created:");
        SBController.displayPlayer(PlayerService.getPlayerByName("Tak�cs M�rton"));
        return player;
    }

    public static void randomResults() {
        for (SportEvent event : BettingDomainDatabase.getEvents()) {
            randomResult(event);
        }
    }

    public static Result randomResult(SportEvent event) {
        Set<Bet> bets = event.getBets();
        List<Outcome> randomOutcomes = new ArrayList<Outcome>();
        for (Bet bet : bets) {
            randomOutcomes.add(randomOutcome(bet));
        }
        Result result = new Result(event, randomOutcomes);
        event.setResult(result);
        return result;
    }

    public static Outcome randomOutcome(Bet bet) {
        Object[] outcomes = bet.getOutcomes().toArray();
        int a = (int) (outcomes.length * Math.random());
        for (int i = 0; i < outcomes.length; i++) {
            if (i == a) {
                return (Outcome) outcomes[i];
            }
        }
        return null;
    }
}
