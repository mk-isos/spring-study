package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        //basePackages = "hello.core",
        // 이를 안붙혀도 @ComponetScan 이 붙은 설정 정보 클래스의 패키지가 시작 위치가 된다.

        //예제 유지를 위해 일단은 뺌. 안전하게.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Configuration.class})
)

public class AutoAppConfig {

}
