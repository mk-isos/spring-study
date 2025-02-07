package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
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

//    @Bean(name = "memoryMemberRepository")
//
//    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }

    //이 경우 수동 빈 등록이 우선권을 가진다. (수동 빈이 자동 빈을 오버라이딩 해버린다.)

}
