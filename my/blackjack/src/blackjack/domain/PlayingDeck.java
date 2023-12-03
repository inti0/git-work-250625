package blackjack.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PlayingDeck {

    private PlayingDeck() {
    }

    public static List<Card> create() {
        List<Card> cards = Arrays.stream(Rank.values())
                .flatMap(rank -> {
                    return Arrays.stream(Suit.values())
                            .map(suit -> new Card(rank, suit));
                })
                .toList();

        Collections.shuffle(cards);
        return cards;
    }
}
