package teste.aparecido.getnet;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;

public class RequisicaoGet {
	@BeforeClass
	public static void getInicial() {
		RestAssured.baseURI = "https://reqres.in";
		RestAssured.basePath = "/api";
//		https://reqres.in/api/users?page=2
	}
	@Test
	public void devoVerTodosOsUser() {
		given()
		.log().all()
		.contentType("application/json")
		.when()
				.get("/users")
			.then()
				.log().all()
				.statusCode(201);
				
	}
	
}
