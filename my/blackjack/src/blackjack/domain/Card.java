package blackjack.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public record Card(Rank rank, Suit suit) {

    public static final List<Card> aces = Arrays.stream(Suit.values())
            .map(suit -> new Card(Rank.ACE, suit))
            .toList();

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Card card)) {
            return false;
        }
        return rank == card.rank && suit == card.suit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, suit);
    }

    public int getValue() {
        return this.rank.getValue();
    }
}
