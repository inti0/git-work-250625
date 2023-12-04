package blackjack;

import blackjack.domain.Card;
import blackjack.domain.Player;
import blackjack.domain.PlayingDeck;
import blackjack.service.GameProcessor;
import blackjack.service.GameWinResult;
import blackjack.service.Referee;
import blackjack.view.HitCommand;
import blackjack.view.InputView;
import blackjack.view.OutputView;
import java.util.List;

public class BlackjackController {

    private final InputView inputView;
    private final OutputView outputView;

    public BlackjackController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        List<String> names = inputView.readPlayerNames();
        GameProcessor gameProcessor = GameProcessor.of(PlayingDeck.create(), names);

        for (int i = 0; i < names.size(); i++) {
            HitCommand hitCommand = inputView.readHitCommand(names.get(i));

            if (hitCommand == HitCommand.NO) {
                List<Card> cardOfPlayer = gameProcessor.getCardOfPlayer(i);
                outputView.printCurrentCards(names.get(i), cardOfPlayer);
            }

            while (hitCommand != HitCommand.NO) {
                gameProcessor.hitIndexPlayer(i);
                List<Card> cardOfPlayer = gameProcessor.getCardOfPlayer(i);
                outputView.printCurrentCards(names.get(i), cardOfPlayer);

                hitCommand = inputView.readHitCommand(names.get(i));
            }
        }

        while (gameProcessor.hitDealer()) {
            outputView.printDealerHitMessage();
        }

        List<Player> allPlayersWithDealer = gameProcessor.getAllPlayers();
        List<GameWinResult> judge = Referee.judge(allPlayersWithDealer);

        outputView.printPlayerResult(allPlayersWithDealer);
        outputView.printWinResult(judge);
    }
}
