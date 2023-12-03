package blackjack.domain;

import java.util.ArrayList;
import java.util.List;

public enum Rank {
    ACE(1, 11),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(10),
    QUEEN(10),
    KING(10),
    ;

    private int value;
    private int otherValue;

    Rank(int value) {
        this.value = value;
    }

    Rank(int value, int otherValue) {
        this.value = value;
        this.otherValue = otherValue;
    }


}
