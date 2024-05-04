package net.icloudn.alarm.slack;

import com.slack.api.Slack;
import com.slack.api.model.Attachment;
import com.slack.api.model.Field;
import com.slack.api.webhook.Payload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

/**
 * packageName    : net.icloudn.alarm.slack
 * fileName       : SlackService
 * author         : bhhan
 * date           : 2/19/24
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2/19/24        bhhan       최초 생성
 */
@Slf4j
public class SlackService {
    @Value("${webhook.slack.url}")
    private String slackWebhookUrl;

    private final Slack slackClient = Slack.getInstance();

    public void sendMessage(String title, SlackDto.SlackRequest slackRequest, SlackTheme slackTheme) {
        try {
            slackClient.send(slackWebhookUrl, Payload.builder()
                    .text(slackTheme.getEmoji() + " " + title)
                    .attachments(List.of(generateSlackAttachment(slackRequest, slackTheme)))
                    .build());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    private Attachment generateSlackAttachment(SlackDto.SlackRequest slackRequest, SlackTheme slackTheme) {
        return Attachment.builder()
                .color(slackTheme.getColor())
                .fields(slackRequest.toMap().entrySet()
                        .stream()
                        .map(stringStringEntry ->
                                generateSlackField(stringStringEntry.getKey(), stringStringEntry.getValue()))
                        .toList())
                .build();
    }

    private Field generateSlackField(String title, String value) {
        return Field.builder()
                .title(title)
                .value(value)
                .valueShortEnough(false)
                .build();
    }
}
