package com.bhhan.alarm.kakao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * packageName    : net.icloudn.alarm.kakao
 * fileName       : KakaoMessageDto
 * author         : bhhan
 * date           : 2/19/24
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2/19/24        bhhan       최초 생성
 */
public class KakaoMessageDto {
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MessageTemplate {
        static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        private String phoneNumber;
        private String project;
        private LocalDateTime timeStamp;
        private String type;
        private String description;
        private String url;

        public String getTimeStamp() {
            return dateTimeFormatter.format(timeStamp);
        }
    }
}
