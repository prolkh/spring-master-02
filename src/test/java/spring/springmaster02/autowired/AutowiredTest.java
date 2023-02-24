package spring.springmaster02.autowired;

import jakarta.annotation.Nullable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.springmaster02.member.Member;

import java.util.Optional;

public class AutowiredTest {
    
    @Test
    @DisplayName("@Autowired 자동주입 옵션이 정상 돟작한다.")
    void AutowiredOption() {
        // Given
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean {

        // required = false 자동 주입할 대상이 없으면 수정자 메서드가 호출 안 됨
        @Autowired(required = false)
        public void setNoBean1(Member noBean1) {
            System.out.println("noBean1 = " + noBean1);
        }

        // @Nullable 호출은 되지만 대상이 없으면 null 로 받환된다.
        @Autowired
        public void setNoBean2(@Nullable Member noBean2) {
            System.out.println("noBean2 = " + noBean2);
        }

        // Optional 대상이 없으면 Optional.empty 가 반환이 된다.
        @Autowired
        public void setNoBean3(Optional<Member> noBean3) {
            System.out.println("noBean3 = " + noBean3);
        }
    }
}
