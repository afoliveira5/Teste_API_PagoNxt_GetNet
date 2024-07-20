package br.ce.aparecido;

import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;

public class RequisiçãoGet {

	@BeforeClass
	public static void getInicial() {
		RestAssured.baseURI = "https://reqres.in";
		RestAssured.basePath = "/api";

	}

	@Test
	public void devoVerTodosOsUsers() {
		given().log().all().contentType("application/json")
		.when()
		.get("/users?page=1");
		Response response = RestAssured.request(Method.GET, "/users?page=1");
		System.out.println(response.body());

	}

}
