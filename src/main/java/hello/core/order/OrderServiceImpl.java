package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;    // final은 생성자에 들어오는 값이 무조건 있어야 함
    private final DiscountPolicy discountPolicy;

    //@RequiredArgsConstructor 가 클래스 상위에 선언되면 final이 붙은 객체는 자동으로 아래 생성자 선언을 해줌
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository,  @Qualifier("mainDiscountPolicy") DiscountPolicy discountPolicy) {   //빈에 달린 일종의 별칭
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }
/*
    // 7. 의존관계 - setter
    @Autowired
    public void setMemberRepository(MemberRepository memberRepository){
        System.out.println("memberRepository = " + memberRepository);
        this.memberRepository = memberRepository;
    }
    // 7. 의존관계 - setter
    @Autowired
    public void setDiscountPolicy(DiscountPolicy discountPolicy){
        System.out.println("discountPolicy = " + discountPolicy);
        this.discountPolicy = discountPolicy;
    }

    // 7.의존관계 - 일반메서드 주입
    @Autowired
    public void init(MemberRepository memberRepository, DiscountPolicy discountPolicy){
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

 */

    @Override
    public Order CreateOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
