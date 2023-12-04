package blackjack.view;

import java.util.Arrays;

public enum HitCommand {

    HIT("y"),
    NO("n"),
    ;

    private final String code;

    HitCommand(String code) {
        this.code = code;
    }

    public static HitCommand findBy(String input) {
        return Arrays.stream(HitCommand.values())
                .filter(hitCommand -> hitCommand.code.equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("히트 커맨드 오류"));
    }
}
