package co.kr.metacoding.backendtest.User;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor // final 필드에 대한 생성자 생성
@Repository
public class UserRepository {

    // JPA는 EntityManager로 DB에 접근
    private final EntityManager em;

    // 회원 목록
    public List<User> findAll() {
        return em.createQuery("select user from User user order by user.id desc", User.class)
                .getResultList();
    }

    // 회원 조회(상세보기)
    // null 처리위해 옵셔널
    public Optional<User> findById(int id) {
        return Optional.ofNullable(em.find(User.class, id));
    }



}