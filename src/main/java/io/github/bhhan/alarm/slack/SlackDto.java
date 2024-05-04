package io.github.bhhan.alarm.slack;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * packageName    : net.icloudn.alarm.slack
 * fileName       : SlackDto
 * author         : bhhan
 * date           : 2/19/24
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2/19/24        bhhan       최초 생성
 */
public class SlackDto {
    public static class SlackRequest {
        static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        private final String project;
        private final LocalDateTime timeStamp;
        private final String type;
        private final String description;

        public SlackRequest(String project, LocalDateTime timeStamp, String type, String description) {
            this.project = project;
            this.timeStamp = timeStamp;
            this.type = type;
            this.description = description;
        }

        public Map<String, String> toMap() {
            LinkedHashMap<String, String> map = new LinkedHashMap<>();
            map.put("프로젝트", project);
            map.put("시간", dateTimeFormatter.format(timeStamp));
            map.put("분류", type);
            map.put("내용", description);

            return map;
        }
    }
}
