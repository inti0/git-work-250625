package blackjack.view;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public List<String> readPlayerNames() {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)\n");
        String input = scanner.nextLine();
        String[] split = input.split(",");
        return List.of(split);
    }

    public HitCommand readHitCommand(String playerName) {
        System.out.println("%s는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n))".formatted(playerName));
        String input = scanner.nextLine();
        return HitCommand.findBy(input);
    }
}
