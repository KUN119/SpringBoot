package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    //회원을 저장하면 저장된 회원이 반환
    Member save(Member member);
    //Optional: null일 경우 Optional로 감싸서 반환 (java8)
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
