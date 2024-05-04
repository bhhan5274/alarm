package io.github.bhhan.alarm.slack;

import lombok.Getter;

/**
 * packageName    : net.icloudn.alarm.slack
 * fileName       : SlackColor
 * author         : bhhan
 * date           : 2/19/24
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2/19/24        bhhan       최초 생성
 */
@Getter
public enum SlackTheme {
    RED("EF476F", ":rotating_light:"), YELLOW("FFD166", ":warning:"), GREEN("06D6A0", ":white_check_mark:"),
    BLUE("118AB2", ":large_blue_diamond:");

    private final String color;
    private final String emoji;

    private SlackTheme(String color, String emoji) {
        this.color = color;
        this.emoji = emoji;
    }
}
