package com.doil.springboot.web.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트() {
        // 해당 테스트로 롬복에 @Getter, @RequiredArgsConstructor의 기능
        // get 메소드, 생성자 잘 되는지 체크했다!!!!

        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
        // assertj라는 테스트 검증 라이브러리의 메소드
        // 검증 대상을 메소드 인자로 받는다.
        // 메소드 체이닝 지원됨
        // assertThat에 있는 값과 비교해서 성공 따짐
    }
}
