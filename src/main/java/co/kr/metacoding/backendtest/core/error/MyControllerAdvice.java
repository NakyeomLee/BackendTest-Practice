package co.kr.metacoding.backendtest.core.error;

import co.kr.metacoding.backendtest.core.error.ex.Exception400;
import co.kr.metacoding.backendtest.core.error.ex.Exception404;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

// 이 클래스의 책임 : 에러 처리
@ControllerAdvice
public class MyControllerAdvice {
    @ResponseBody // 파일 찾는게 아니라 return을 할 때만 붙임
    @ExceptionHandler(Exception400.class)
    public String err400(Exception400 e) {

        String body = """
                <script>
                    alert('${message}');
                    history.back();
                </script>
                """.replace("${message}", e.getMessage()); // msg를 메세지로 변환

        return body;
    }

    @ResponseBody // 파일 찾는게 아니라 return을 할 때만 붙임
    @ExceptionHandler(Exception404.class)
    public String err404(Exception404 e) {

        String body = """
                <script>
                    alert('${message}');
                    history.back();
                </script>
                """.replace("${message}", e.getMessage()); // msg를 메세지로 변환

        return body;
    }
}