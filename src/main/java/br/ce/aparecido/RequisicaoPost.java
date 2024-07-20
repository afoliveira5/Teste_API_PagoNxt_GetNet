package br.ce.aparecido;

import br.ce.aparecido.User;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import static org.hamcrest.Matchers.*;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;


import java.util.Map;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class RequisiçãoPost {
	@BeforeClass
	public static void primeiroPassoDoPost() {
		RestAssured.baseURI = "https://reqres.in";
		RestAssured.basePath = "/api";
	}
	
@Test
	public void deveSalvarUsuárioAparecidoViaObjeto() {
		User user = new User ("Aparecido","TeamLead");
		given()
		.log().all()
		.contentType("application/json")
		.body(user)
		.when()
				.post("/users")
			.then()
				.log().all()
				.statusCode(201)
				.body("id", is(notNullValue()))
				.body("name", is("Aparecido"))
				.body("job", is("TeamLead"));
	};	
	
	
	@Test
	public void deveSalvarUsuárioAnderson() {
		User user = new User ("Anderson","LeadQualityAssurance");
		given().log().all().contentType("application/json")
				.body(user)
				.when()
				.post("/users")
				.then().log().all()
				.statusCode(201)
				.body("id", is(notNullValue()))
				.body("name", is("Anderson"))
				.body("job", is("LeadQualityAssurance"));

	}

	@Test
	public void deveSalvarUsuárioAlef() {
		User user = new User ("Alef","ManageQualityAssurance");
		given().log().all().contentType("application/json")
				.body(user)
				.when().post("/users")
				.then().log().all()
				.statusCode(201)
				.body("id", is(notNullValue()))
				.body("name", is("Alef"))
				.body("job", is("QualityAssurance"));

	}

	@Test
	public void testandoContratoDaApiNoAssert() {
		User user = new User ("Alef","ManageQualityAssurance");
		given().log().all().contentType("application/json")
				.body(user)
				.when().post("/users")
				.then().log().all()
				.statusCode(201)
				.body("id", is(notNullValue()))
				.body("name", is("")).body("job", is(""));

	}

	@Test
	public void testandoContratoDaApiNoJson() {
		given().log().all().contentType("application/json").body("{\"name\":\"\",\"job\":\"\"}")
				.when()
				.post("/users")
				.then().log().all()
				.statusCode(201)
				.body("id", is(notNullValue()))
				.body("name", is("Alef"))
				.body("job", is("QualityAssurance"));

	}
}
