package clients;

import com.google.gson.JsonObject;
import data.Token;
import data.User;
import data.UserCredentials;
import io.qameta.allure.Step;

public class UserClient extends RestClient {
    private final String REGISTRATION_URL = "/auth/register";
    private final String USER_URL = "/auth/user";
    private final String LOGIN_URL = "/auth/login";
    private final String LOGOUT_URL = "/auth/logout";

    @Step("Создание УЗ")
    public Token create(User user) {
        var response = reqSpec
                .body(user)
                .when()
                .post(REGISTRATION_URL)
                .then()
                .assertThat()
                .statusCode(200)
                .extract();
        return new Token(response.path("accessToken"), response.path("refreshToken"));
    }

    @Step("Удаление УЗ")
    public void delete(Token token) {
        reqSpec
                .header("authorization", token.getAccessToken())
                .when()
                .delete(USER_URL)
                .then()
                .assertThat()
                .statusCode(202);
    }

    @Step("Авторизация УЗ")
    public Token login(UserCredentials creds) {
        var response = reqSpec
                .body(creds)
                .when()
                .post(LOGIN_URL)
                .then()
                .assertThat()
                .statusCode(200)
                .extract();
        return new Token(response.path("accessToken"), response.path("refreshToken"));
    }

    @Step("Logout УЗ")
    public void logout(Token token) {
        var json = new JsonObject();
        json.addProperty("token", token.getRefreshToken());
        reqSpec
                .body(json.toString())
                .when()
                .post(LOGOUT_URL)
                .then()
                .assertThat()
                .statusCode(200);
    }
}
