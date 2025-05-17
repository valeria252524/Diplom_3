package api;

import io.restassured.response.Response;
import models.User;

import static io.restassured.RestAssured.given;

public class UserApiClient {
    private final String BASE_URL = "https://stellarburgers.nomoreparties.site";

    public Response createUser(User user) {
        return given()
                .baseUri(BASE_URL)
                .header("Content-Type", "application/json")
                .body(user)
                .post("/api/auth/register");
    }

}
