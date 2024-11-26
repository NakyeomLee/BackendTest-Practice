package co.kr.metacoding.backendtest.User;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor // final 필드에 대한 생성자 생성
@RestController
public class UserController {

    private final UserService userService;

    // 회원조회(상세보기) - get
    @GetMapping("/user/{id}")
    public String detail(@PathVariable("id") Integer id, Model model) {

        UserService.ReadDTO userDetail = userService.회원상세보기(id);
        model.addAttribute("model", userDetail);

        return "detail"; // view
    }

    // 회원목록보기 - get
    @GetMapping("/")
    public String list(Model model) {

        List<UserService.DTO> userList = userService.회원목록보기();
        model.addAttribute("models", userList);

        return "list"; // view
    }
}