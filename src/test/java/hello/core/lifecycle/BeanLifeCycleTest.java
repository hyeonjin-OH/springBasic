package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {
    @Test
    public void lifeCycleTest(){
       ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
       NetworkClient client = ac.getBean(NetworkClient.class);
       ac.close();  //ApplicationContext는 close를 제공하지 않고 상위인 ConfigurableApplicationContext는 제공함
    }

    @Configuration
    static class LifeCycleConfig{
        @Bean//(initMethod = "init", destroyMethod = "close") //destroy는 굳이 지정하지 않아도 close shutdown등의 메서드를 추론으로 불러온다.
        public NetworkClient networkClient(){
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://hello-spring.dev");
            return networkClient;
        }
    }
}
