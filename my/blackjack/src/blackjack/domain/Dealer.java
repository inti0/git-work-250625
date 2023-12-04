package blackjack.domain;

import java.util.List;

public class Dealer extends Player{

    private static final int DEALER_HIT_THRESHOLD = 16;

    public Dealer(List<Card> cards) {
        super("딜러", cards);
    }

    @Override
    public void hit(Card card) {
        if (super.calculateScore() >= DEALER_HIT_THRESHOLD) {
            super.hit(card);
        }
    }
}
