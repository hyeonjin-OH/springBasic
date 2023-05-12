package hello.core;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {


        //MemberService memberService = new MemberServiceImpl(); -> 1.기존에 MemberServiceImpl에서 new MemoryMemberRepository() 선언했을 때 선언된 방식

        //AppConfig appConfig = new AppConfig();
        //MemberService memberService = appConfig.memberService(); -> 2. Spring 으로 바꾸기 전

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class); // (불러올 객체의 선언된 이름, 리턴할 형태)

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new Member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
