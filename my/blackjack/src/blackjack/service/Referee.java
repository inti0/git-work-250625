package blackjack.service;

import blackjack.domain.Player;
import java.util.ArrayList;
import java.util.List;

public class Referee {

    public Referee() {
    }

    public static List<GameWinResult> judge(List<Player> allPlayers) {
        Player dealer = allPlayers.get(0);
        int dealerScore = dealer.calculateScore();
        List<GameWinResult> result = new ArrayList<>();

        addResults(allPlayers, dealerScore, result);
        return result;
    }

    private static void addResults(List<Player> allPlayers, int dealerScore, List<GameWinResult> result) {
        for (int i = 1; i < allPlayers.size(); i++) {
            Player player = allPlayers.get(i);
            int playerScore = player.calculateScore();
            JudgeResult judge = JudgeResult.judge(dealerScore, playerScore);
            result.add(new GameWinResult(player, judge));
        }
    }
}
