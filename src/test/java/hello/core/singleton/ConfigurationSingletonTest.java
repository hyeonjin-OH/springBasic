package hello.core.singleton;

import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.AppConfig;
import hello.core.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {

    /* AppConfig에서 참조에 참조를 거듭하는 부분
     *  @Bean
        public MemberService memberService(){
            return new MemberServiceImpl(memberRepository());
        }
     *  @Bean
        public OrderService orderService(){
            return new OrderServiceImpl(memberRepository(), discountPolicy());
        }
     *  @Bean
        public static MemoryMemberRepository memberRepository() {
            return new MemoryMemberRepository();
        }
     * memberRepository()를 두번 선언하는 부분에 싱글톤 원칙이 지켜지는지 테스트하는 내용
     */
    @Test
    void configurationTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();

        System.out.println("memberService -> memberRepository = " + memberRepository1);
        System.out.println("orderService -> memberRepository = " + memberRepository2);

    }

    @Test
    void configurationDeep(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);    //AnnotationConfig~~ 에 인자값을 넘기면 AppConfig를 bean으로 등록함 ?
        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println("bean = " + bean.getClass());

    }
}
