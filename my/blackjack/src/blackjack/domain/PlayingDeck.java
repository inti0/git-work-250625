package blackjack.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PlayingDeck {

    private PlayingDeck() {
    }

    public static LinkedList<Card> create() {
        List<Card> cards = Arrays.stream(Rank.values())
                .flatMap(rank -> {
                    return Arrays.stream(Suit.values())
                            .map(suit -> new Card(rank, suit));
                })
                .toList();

        Collections.shuffle(cards);
        return (LinkedList<Card>) cards;
    }
}
