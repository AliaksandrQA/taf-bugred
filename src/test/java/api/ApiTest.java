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
        String name = "User";
        String name1 = "User";
        String surname1 = "User";
        String fathername1 = "User";
        String cat = "User";
        String dog = "User";
        String parrot = "User";
        String cavy = "User";
        String hamster = "User";
        String squirrel = "User";
        String phone = "89822510279";
        String inn = "";
        String adres = "dl,lrg";
        String gender = "m";
        String birthday = "1990-02-01";
        String date_start = "2020-10-19";
        String hobby = "java";
        String requestBody = String.format("{\"email\":\"%s\",\"name\":\"%s\",\"name1\":\"%s\",\"surname1\":\"%s\",\"fathername1\":\"%s\",\"cat\":\"%s\",\"dog\":\"%s\",\"parrot\":\"%s\",\"cavy\":\"%s\",\"hamster\":\"%s\",\"squirrel\":\"%s\",\"phone\":\"%s\",\"inn\":\"%s\",\"adres\":\"%s\",\"gender\":\"%s\",\"birthday\":\"%s\",\"date_start\":\"%s\",\"hobby\":\"%s\"}",
                email, name, name1, surname1, fathername1, cat, dog,parrot,cavy,hamster, squirrel,phone,inn,adres,gender,birthday,date_start,hobby);

        given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .get(endPoint)
                .then().statusCode(200)
                .log().all();
        System.out.println(hobby);
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
