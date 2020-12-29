package com.doil.springboot.web;

import com.doil.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // 해당 컨트롤러 -> JSON을 반환하는 컨트롤러로
public class HelloController {

    @GetMapping("/hello") // HTTP method인 GET요청 받을 수 있는 API 생성
    public String hello() {  // /hello로 요청이 오면 문자열 hello를 반환
        return "hello";
    }

    @GetMapping("/hello/dto") // 외부에서 name (@RequestParam("name"))이란 이름으로 넘긴 파라미터를
                                 // 메소드 파라미터인 name(String name)에 저장
                                 // name과 amount는 API를 호출하는 곳에서 넘겨준 값
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }
}
