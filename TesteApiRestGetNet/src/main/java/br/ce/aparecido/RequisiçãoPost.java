package br.ce.aparecido;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matchers;
import org.junit.Test;

public class RequisiçãoPost {
	@Test
	public void deveSalvarUsuárioAparecido() {
		given().log().all().contentType("application/json").body("{\"name\":\"Aparecido\",\"job\":\"teamLead\"}").when()
				.post("https://reqres.in/api/users").then().log().all().statusCode(201).body("id", is(notNullValue()))
				.body("name", is("Aparecido")).body("job", is("teamLead"));

	};

	@Test
	public void deveSalvarUsuárioAnderson() {
		given().log().all().contentType("application/json")
				.body("{\"name\":\"Anderson\",\"job\":\"LeadQualityAssurance\"}").when()
				.post("https://reqres.in/api/users").then().log().all().statusCode(201).body("id", is(notNullValue()))
				.body("name", is("Anderson")).body("job", is("LeadQualityAssurance"));

	}

	@Test
	public void deveSalvarUsuárioAlef() {
		given().log().all().contentType("application/json")
				.body("{\"name\":\"Alef\",\"job\":\"ManageQualityAssurance\"}").when()
				.post("https://reqres.in/api/users")
				.then()
				.log().all()
				.statusCode(201)
				.body("id", is(notNullValue()))
				.body("name", is("Alef"))
				.body("job", is("QualityAssurance"));

	}
	@Test
	public void testandoContratoDaApiNoAssert() {
		given().log().all().contentType("application/json")
				.body("{\"name\":\"Alef\",\"job\":\"ManageQualityAssurance\"}").when()
				.post("https://reqres.in/api/users")
				.then()
				.log().all()
				.statusCode(201)
				.body("id", is(notNullValue()))
				.body("name", is(""))
				.body("job", is(""));

	}
	@Test
	public void testandoContratoDaApiNoJson() {
		given().log().all().contentType("application/json")
				.body("{\"name\":\"\",\"job\":\"\"}").when()
				.post("https://reqres.in/api/users")
				.then()
				.log().all()
				.statusCode(201)
				.body("id", is(notNullValue()))
				.body("name", is("Alef"))
				.body("job", is("QualityAssurance"));

	}
}
