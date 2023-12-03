package blackjack.domain;

import java.util.List;

public class Player {

    private static final int ACE_MORE_OPTION_THRESHOLD = 11;

    private final String name;
    private final List<Card> cards;

    public Player(String name, List<Card> cards) {
        this.name = name;
        this.cards = cards;
    }

    public void hit(Card card) {
        cards.add(card);
    }

    public int calculateScore() {
        int score = cards.stream()
                .mapToInt(card -> card.getValue())
                .sum();

        if (score <= ACE_MORE_OPTION_THRESHOLD && Card.aces.contains(cards)) {
            score += Rank.ACE.getOtherValue() - Rank.ACE.getValue();
        }

        return score;
    }
}
