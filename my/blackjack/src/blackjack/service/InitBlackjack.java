package blackjack.service;

import blackjack.domain.Card;
import blackjack.domain.Dealer;
import blackjack.domain.Player;
import blackjack.domain.PlayingDeck;
import java.util.LinkedList;
import java.util.List;

public class InitBlackjack {

    private final LinkedList<Card> playingDeck;
    private final List<Player> players;
    private final Dealer dealer;

    private InitBlackjack(LinkedList<Card> playingDeck, List<Player> players, Dealer dealer) {
        this.playingDeck = playingDeck;
        this.players = players;
        this.dealer = dealer;
    }

    public static InitBlackjack of(List<String> playerNames) {
        LinkedList<Card> playingDeck = PlayingDeck.create();

        List<Player> players = playerNames.stream()
                .map(name -> new Player(name, drawTwoCards(playingDeck)))
                .toList();

        Dealer dealer = new Dealer(drawTwoCards(playingDeck));

        return new InitBlackjack(playingDeck, players, dealer);
    }

    private static List<Card> drawTwoCards(LinkedList<Card> playingDeck) {
        return List.of(playingDeck.pollFirst(), playingDeck.pollFirst());
    }
}
