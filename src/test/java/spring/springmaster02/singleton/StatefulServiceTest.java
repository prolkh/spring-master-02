package spring.springmaster02.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.*;

class StatefulServiceTest {

    @Test
    @DisplayName("상태를 유지하게 설계한 경우에는 문제가 발생한다.")
    void statefulServiceSingleton() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        // ThreadA: userA 10000원 주문
        statefulService1.order("userA", 10000);
        // ThreadB: userB 20000원 주문
        statefulService2.order("userB", 20000);

        // ThreadA: userA 주문 금액 조회
        int price = statefulService1.getPrice();
        System.out.println("stateful userAPrice = " + price);

        // 10000원이 아니고 20000원이 나오게 된다.
        assertThat(statefulService1.getPrice()).isEqualTo(20000);
    }

    @Test
    @DisplayName("무상태로 설계하면 정상적으로 동작한다.")
    void statelessServiceSingleton() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatelessService statelessService1 = ac.getBean(StatelessService.class);
        StatelessService statelessService2 = ac.getBean(StatelessService.class);

        // ThreadA: userA 10000원 주문
        int userAPrice = statelessService1.order("userA", 10000);
        // ThreadB: userB 20000원 주문
        int userBPrice = statelessService2.order("userB", 20000);

        // ThreadA: userA 주문 금액 조회
        System.out.println("stateless userAPrice = " + userAPrice);

        // 10000원이 정상적으로 나오게 된다.
        assertThat(userAPrice).isEqualTo(10000);
    }


    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }

        @Bean
        public StatelessService statelessService() {
            return new StatelessService();
        }
    }
}