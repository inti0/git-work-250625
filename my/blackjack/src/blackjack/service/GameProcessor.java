package blackjack.service;

import blackjack.domain.Card;
import blackjack.domain.Dealer;
import blackjack.domain.Player;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GameProcessor {

    private final LinkedList<Card> playingDeck;
    private final List<Player> players;
    private final Dealer dealer;

    private GameProcessor(LinkedList<Card> playingDeck, List<Player> players, Dealer dealer) {
        this.playingDeck = playingDeck;
        this.players = players;
        this.dealer = dealer;
    }

    public static GameProcessor of(LinkedList<Card> playingDeck, List<String> playerNames) {
        List<Player> players = playerNames.stream()
                .map(name -> new Player(name, drawTwoCards(playingDeck)))
                .toList();

        Dealer dealer = new Dealer(drawTwoCards(playingDeck));

        return new GameProcessor(playingDeck, players, dealer);
    }

    private static List<Card> drawTwoCards(LinkedList<Card> playingDeck) {
        return List.of(drawCard(playingDeck), drawCard(playingDeck));
    }

    private static Card drawCard(LinkedList<Card> playingDeck) {
        return playingDeck.pollFirst();
    }

    public void hitIndexPlayer(int index) {
        Player player = players.get(index);
        player.hit(drawCard(playingDeck));
    }

    public List<Card> getCardOfPlayer(int index) {
        Player player = players.get(index);
        return player.getCards();
    }

    public boolean hitDealer() {
        return dealer.hit(drawCard(playingDeck));
    }

    public List<Player> getAllPlayers() {
        List<Player> players = new ArrayList<>(this.players);
        players.add(0, dealer);
        return players;
    }
}
