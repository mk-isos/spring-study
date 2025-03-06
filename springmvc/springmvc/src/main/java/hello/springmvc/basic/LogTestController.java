package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j //롬복이 제공해줌
@RestController
public class LogTestController {
    //@Slf4j 어노테이션 사용하면 귀찮게 아래 안적어도 됨
    //private final Logger log  = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest() {

        String name = "Spring";

        // 기존 (이렇게 쓰면 어떤 로깅 레벨이든 다 찍히기 때문에 나중에 콘솔을 보면 너무 지저분 불편)
        System.out.println("name = " + name);
        // log 사용 (아래는 레벨순) 기본은 info
        log.trace("trace log={}", name);
        log.debug("debug log={}", name);
        log.info("info log={}", name);
        log.warn("warn log={}", name);
        log.error("error log={}", name);
        return "ok";

    }
}
