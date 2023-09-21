package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest{

    MemoryMemberRepository repositoy = new MemoryMemberRepository();

    //모든 테스트는 메서드의 순서와 상관없이(의존관계 없이) 진행되도록 만들어야한다.
    //때문에 @AfterEach를 통해 메서드가 끝날 때 마다 clear를 진행해준다.
    //TDD: Test를 먼저 만들고 구현 Class를 만드는 방식
    //Test없이 구현하면 안된다.. Test에 대해서는 꼭 공부를 해야된다.
    @AfterEach
    public void afterEach(){
        repositoy.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repositoy.save(member);

        Member result = repositoy.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repositoy.save(member1);

        //위에 코드 복사해서 member1에 shift + f6 누르면 rename 가능
        Member member2 = new Member();
        member2.setName("spring1");
        repositoy.save(member2);

        Member result = repositoy.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repositoy.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repositoy.save(member2);

        List<Member> result = repositoy.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
