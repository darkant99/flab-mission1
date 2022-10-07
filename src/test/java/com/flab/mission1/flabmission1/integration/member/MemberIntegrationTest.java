package com.flab.mission1.flabmission1.integration.member;

import static org.assertj.core.api.Assertions.assertThat;

import com.flab.mission1.member.service.dto.request.MemberRequest;
import com.flab.mission1.member.service.dto.response.MemberResponse;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

@SuppressWarnings("NonAsciiCharacters")
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MemberIntegrationTest {
    @LocalServerPort
    int port;

    private ValidatableResponse latestThen;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
    }

    @DisplayName("Member Crud 인수 테스트 (통합)")
    @Test
    void 테스트_통합() {
        등록("김재원", 26);
        String memberId = 반환된_ID();

        // 중복 이름에 대한 실패
        등록("김재원", 50);
        요청_실패();

        수정(memberId, 27);
        요청_성공();

        조회(memberId);
        유저_정보_확인("김재원", 27);

        삭제(memberId);
        요청_성공();

        조회(memberId);
        요청_실패();
    }

    void 등록(String name, int age) {
        latestThen = RestAssured
            .given()
            .body(new MemberRequest(name, age))
            .when()
            .post("/api/v1/members")
            .then();
    }

    void 삭제(String id) {
        latestThen = RestAssured
            .when()
            .delete("/api/v1/members/{id}", id)
            .then()
            .statusCode(HttpStatus.NO_CONTENT.value());
    }

    void 수정(String id, int age) {
        latestThen = RestAssured
            .given()
            .body(new MemberRequest(null, age))
            .when()
            .patch("/api/v1/members/{id}/age", id)
            .then();
    }

    void 조회(String id) {
        latestThen = RestAssured
            .when()
            .get("/api/v1/members/{id}", id)
            .then();
    }

    void 요청_성공() {
        var statusCode = latestThen.extract()
            .statusCode();
        assertThat(statusCode + "")
            .withFailMessage("예상과 다른 Status Code 조회됨 // " + statusCode)
            .startsWith("2");
    }

    void 요청_실패() {
        var statusCode = latestThen.extract()
            .statusCode();
        assertThat(statusCode + "")
            .withFailMessage("예상과 다른 Status Code 조회됨 // " + statusCode)
            .startsWith("4");
    }


    String 반환된_ID() {
        String location = latestThen.extract()
            .header("location");
        return location.substring(
            location.lastIndexOf("/") + 1
        );
    }

    void 유저_정보_확인(String expertName, int expertAge) {
        var member = latestThen.extract()
            .body()
            .as(MemberResponse.class);

        assertThat(member.getName())
            .withFailMessage("예상과 다른 이름 조회됨 // " + member.getName())
            .isEqualTo(expertName);
        assertThat(member.getAge())
            .withFailMessage("예상과 다른 나이 조회됨 // " + member.getAge())
            .isEqualTo(expertAge);
    }
}
