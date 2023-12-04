package blackjack.service;

import blackjack.domain.Card;
import blackjack.domain.Dealer;
import blackjack.domain.Player;
import java.util.LinkedList;
import java.util.List;

public class GameService {

    private final LinkedList<Card> playingDeck;
    private final List<Player> players;
    private final Dealer dealer;

    private GameService(LinkedList<Card> playingDeck, List<Player> players, Dealer dealer) {
        this.playingDeck = playingDeck;
        this.players = players;
        this.dealer = dealer;
    }

    public static GameService of(LinkedList<Card> playingDeck, List<String> playerNames) {
        List<Player> players = playerNames.stream()
                .map(name -> new Player(name, drawTwoCards(playingDeck)))
                .toList();

        Dealer dealer = new Dealer(drawTwoCards(playingDeck));

        return new GameService(playingDeck, players, dealer);
    }

    private static List<Card> drawTwoCards(LinkedList<Card> playingDeck) {
        return List.of(playingDeck.pollFirst(), playingDeck.pollFirst());
    }

    public void hit(int index) {
        Player player = players.get(index);
        player.hit(playingDeck.pollFirst());
    }

    public List<Card> getCardOfPlayer(int index){
        Player player = players.get(index);
        return player.getCards();
    }

    public int getScoreOfPlayer(int index){
        Player player = players.get(index);
        return player.calculateScore();
    }
}
