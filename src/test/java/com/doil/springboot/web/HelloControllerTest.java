package com.doil.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class) // SpringBootTest와 JUnit의 연결
@WebMvcTest(controllers = HelloController.class) // Web(Spring MVC)에 집중할 수 있는 어노테이션, @Controller, @ControllerAdvice 사용가능
public class HelloControllerTest {

    @Autowired // Spring이 관리하는 Bean을 주입받음
    private MockMvc mvc; // web API 테스트시 사용, 스프링 MVC테스트 시작점, HTTP GET, POST등 테스트

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello")) // MockMvc를 통해 /hello 주소로 HTTP GET 요청
                .andExpect(status().isOk()) // mvc.perform의 결과, HTTP Header의 status 검증, OK는 200인지 체크
                .andExpect(content().string(hello)); // mvc.perform의 결과, 응답 본문 내용 검증, 컨트롤러에서 'hello'를 리턴하기 때문에 이 값이 맞는 지 검증
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto")
                // API 테스트 시, 사용될 요청 파라미터 설정
                // 값은 String만!!, 숫자->문자열로 변경!!!
                .param("name", name)
                .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                // JSON 응답값을 필드별로 검증, $를 기준으로 필드명 명시
                .andExpect(jsonPath("$.name",is(name)))
                .andExpect(jsonPath("$.amount",is(amount)));
    }
}
