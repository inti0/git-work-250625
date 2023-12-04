package blackjack.service;

import blackjack.domain.Player;

public record GameWinResult(Player player, JudgeResult judgeResult) {

}
