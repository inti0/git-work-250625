package blackjack.service;

import java.util.List;

public enum JudgeResult {

    WIN("승"),
    DRAW("무"),
    LOSE("패"),
    ;

    private final String result;

    JudgeResult(String result) {
        this.result = result;
    }

    public static JudgeResult judge(int dealerScore, int playerScore) {
        if (dealerScore > playerScore) {
            return WIN;
        }
        if (dealerScore < playerScore) {
            return LOSE;
        }
        return DRAW;
    }

    public String getResult() {
        return result;
    }
}
