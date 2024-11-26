package co.kr.metacoding.backendtest.User;

import co.kr.metacoding.backendtest.core.error.ex.Exception404;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor // final 필드에 대한 생성자 생성
@Service
public class UserService {

    private final UserRepository userRepository;

    public ReadDTO 회원상세보기(Integer id) {
        // .orElseThrow : 예외처리를 정확하게 할 수있게 길 안내
        // 데이터 무결성 최대화, 변수 최소화
        User user = userRepository.findById(id)
                .orElseThrow(() -> new Exception404("해당 id의 회원이 존재하지 않습니다. : " + id));
        return new ReadDTO(user);
    }

    public List<DTO> 회원목록보기() {
        // 여러개의 데이터를 한번에 처리해야될때 스트림 (일종의 for-each)
        return userRepository.findAll().stream()
                .map(DTO::new)
                .toList();
    }

    // 회원조회(상세보기) DTO
    @Data
    public static class ReadDTO {
        private Integer id;
        private String name;

        // 생성자
        public ReadDTO(User user) {
            this.id = user.getId();
            this.name = user.getName();
        }
    }

    // 회원목록 DTO
    @Data
    public static class DTO {
        private Integer id;
        private String name;

        // 생성자(깊은 복사를 위해 매개변수 User)
        public DTO(User user) {
            this.id = user.getId();
            this.name = user.getName();
        }
    }
}