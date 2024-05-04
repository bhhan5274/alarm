package net.icloudn.alarm.kakao;

import jakarta.annotation.PostConstruct;
import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.model.KakaoOption;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.request.SingleMessageSendingRequest;
import net.nurigo.sdk.message.service.DefaultMessageService;
import org.springframework.beans.factory.annotation.Value;

import java.util.HashMap;

/**
 * packageName    : net.icloudn.alarm.kakao
 * fileName       : KakaoService
 * author         : bhhan
 * date           : 2/19/24
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2/19/24        bhhan       최초 생성
 */
public class KakaoService {
    private DefaultMessageService messageService;
    private static final String SOLAPI_API_URL = "https://api.solapi.com";

    @Value("${kakao.key}")
    private String apiKey;

    @Value("${kakao.secret}")
    private String apiSecret;

    @Value("${kakao.channel}")
    private String channelId;

    @Value("${kakao.template}")
    private String templateId;

    @Value("${cloudn.tel}")
    private String cloudnTel;

    @PostConstruct
    public void init(){
        this.messageService = NurigoApp.INSTANCE.initialize(apiKey, apiSecret,
                SOLAPI_API_URL);
    }

    public void sendMessage(KakaoMessageDto.MessageTemplate messageTemplate) {
        KakaoOption kakaoOption = new KakaoOption();
        kakaoOption.setDisableSms(true);
        kakaoOption.setPfId(channelId);
        kakaoOption.setTemplateId(templateId);

        HashMap<String, String> variables = new HashMap<>();
        variables.put("#{name}", messageTemplate.getProject());
        variables.put("#{timestamp}", messageTemplate.getTimeStamp());
        variables.put("#{type}", messageTemplate.getType());
        variables.put("#{description}", messageTemplate.getDescription());
        variables.put("#{url}", messageTemplate.getUrl());

        kakaoOption.setVariables(variables);

        Message message = new Message();
        message.setFrom(cloudnTel);
        message.setTo(messageTemplate.getPhoneNumber());
        message.setKakaoOptions(kakaoOption);

        messageService.sendOne(new SingleMessageSendingRequest(message));
    }
}
