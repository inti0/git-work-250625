package blackjack.view;

import blackjack.domain.Card;
import blackjack.domain.Player;
import blackjack.service.GameWinResult;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public void printCurrentCards(String name, List<Card> cardOfPlayer) {
        String cards = toStringCards(cardOfPlayer);
        String result = String.format("%s카드: %s", name, cards);
        System.out.println(result);
    }

    private static String toStringCards(List<Card> cardOfPlayer) {
        return cardOfPlayer.stream()
                .map(card -> card.getValue() + card.getSuitName())
                .collect(Collectors.joining(","));
    }

    public void printDealerHitMessage() {
        System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.");
    }

    public void printPlayerResult(List<Player> allPlayersWithDealer) {
        String format = "%s카드: %s - %d";

        String result = allPlayersWithDealer.stream()
                .map(player -> format.formatted(
                        player.getName(),
                        player.getCards(),
                        player.calculateScore()
                ))
                .collect(Collectors.joining("\n"));

        System.out.println(result);
    }

    public void printWinResult(List<GameWinResult> judge){
        String format = "%s: %s";

        String joining = judge.stream()
                .map(gameWinResult -> format.formatted(
                        gameWinResult.player().getName(),
                        gameWinResult.judgeResult().getResult()
                ))
                .collect(Collectors.joining("\n"));

        System.out.println(joining);
    }
}
