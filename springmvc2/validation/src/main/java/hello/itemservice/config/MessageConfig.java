package hello.itemservice.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class MessageConfig {
//    @Bean
//    public MessageSource messageSource() {
//        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
//        //messageSource.setBasename("classpath:messages,classpath:errors"); // message, errors 파일 읽기
//        messageSource.setDefaultEncoding("UTF-8"); // UTF-8 강제 적용
//        messageSource.setUseCodeAsDefaultMessage(true);
//        return messageSource;
//    }
}
