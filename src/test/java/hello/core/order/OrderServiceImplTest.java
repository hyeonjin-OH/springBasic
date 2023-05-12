package hello.core.order;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    @Test
    void createOrder(){
        // 일반 생성자 주입방식 그대로 사용 시
        MemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "ohj", Grade.VIP));

        OrderServiceImpl orderService = new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
        Order order = orderService.CreateOrder(1L, "itemA", 10000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

        // 수정 생성자 사용 시
        //OrderServiceImpl orderService = new OrderServiceImpl(); 에러남
        //Order order = orderService.CreateOrder(1L, "itemA", 10000);
    }


}