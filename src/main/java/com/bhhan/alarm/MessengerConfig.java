package com.bhhan.alarm;

import com.bhhan.alarm.kakao.KakaoService;
import com.bhhan.alarm.slack.SlackService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * packageName    : net.cloudn.alarm
 * fileName       : MessengerConfig
 * author         : bhhan
 * date           : 2/19/24
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2/19/24        bhhan       최초 생성
 */
@Configuration
public class MessengerConfig {
    @Bean
    public SlackService slackService() {
        return new SlackService();
    }

    @Bean
    public KakaoService kakaoService(){
        return new KakaoService();
    }
}
