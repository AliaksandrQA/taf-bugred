package api;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class ApiTest {
    @Test
    public void testUserCreation() {
        String endPoint = "http://users.bugred.ru/tasks/rest/doregister";
        String name = "BobTest1";
        String email = "BobTest1@mail.com";
        String password = "123455";
        String requestBody = String.format("{\"name\":\"%s\",\"email\":\"%s\",\"password\":\"%s\"}", name, email, password);
        given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .post(endPoint)
                .then().statusCode(200)
                .log().all();
    }

    @Test
    public void testInvalidUserCreation() {
        String endPoint = "http://users.bugred.ru/tasks/rest/doregister";
        String name = "BobTest1";
        String invalidEmail = " ";
        String password = "123455";
        String requestBody = String.format("{\"name\":\"%s\",\"email\":\"%s\",\"password\":\"%s\"}", name, invalidEmail, password);
        given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .post(endPoint)
                .then().statusCode(200)
                .log().all();
    }

    @Test
    void testGetUserInfo() {
        String endPoint = "http://users.bugred.ru/tasks/rest/getuser";
        String email = "ivanov2@vk.com";

        String requestBody = String.format("{\"email\":\"%s\"}", email);
        given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .get(endPoint)
                .then().statusCode(200)
                .log().all()
                .body("email", is(email));
    }

    @Test
    void testGetInvalidUserInfo() {
        String endPoint = "http://users.bugred.ru/tasks/rest/getuser";
        String InvalidEmail = "i";

        String requestBody = String.format("{\"email\":\"%s\"}", InvalidEmail);
        given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .get(endPoint)
                .then().statusCode(200)
                .log().all();
    }

    @Test
    void testUpdateUserInfo() {
        String endPoint = "http://users.bugred.ru/tasks/rest/fullupdateuser";
        String email = "user1@test.ru";
        String inn = "696969";
        String gender = "m";
        String birthday = "1990-02-01";
        String date_start = "2020-10-19";
        String requestBody = String.format("{\"email\":\"%s\",\"inn\":\"%s\",\"gender\":\"%s\",\"birthday\":\"%s\",\"date_start\":\"%s\"}", email, inn, gender, birthday, date_start);

        given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .get(endPoint)
                .then().statusCode(200)
                .log().all()
                .body("email", is(email));
    }

    @Test
    public void testDeleteUser() {
        String endPoint = "http://users.bugred.ru/tasks/rest/deleteuser";
        String email = "BobTest1@mail.com";
        String requestBody = String.format("{\"email\":\"%s\"}", email);
        given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .post(endPoint)
                .then()
                .statusCode(200)
                .log()
                .all();
    }
}
