package io.github.bhhan.alarm;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * packageName    : net.icloudn.alarm
 * fileName       : EnableAlarm
 * author         : bhhan
 * date           : 2/19/24
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2/19/24        bhhan       최초 생성
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import({MessengerConfig.class})
public @interface EnableAlarm {
}
