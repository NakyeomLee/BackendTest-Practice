package co.kr.metacoding.backendtest.User;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor // 풀 생성자
@NoArgsConstructor // 빈 생성자
@Getter
@Table(name = "user") // 테이블 이름 지정
@Entity // 엔티티(모델) 지정, DB 테이블과 매핑 가능
public class User {
    @Id // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AutoIncrement
    private Integer id; // null일 경우를 대비해서 Integer
    private String name;
}