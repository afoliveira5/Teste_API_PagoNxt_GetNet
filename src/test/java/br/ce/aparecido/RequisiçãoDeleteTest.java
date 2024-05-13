package br.ce.aparecido;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.Test;

public class RequisiçãoDeleteTest {
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
				.body("job", is("ManageQualityAssurance"));

	}
	@Test
	public void deletarUsuárioAlef() {
		given().log().all().contentType("application/json")
				.body("{\"name\":\"Alef\",\"job\":\"ManageQualityAssurance\"}").when()
				.delete("https://reqres.in/api/users/2")
				.then()
				.log().all()
				.statusCode(201)
				.body("id", is(notNullValue()))
				.body("name", is("Alef"))
				.body("job", is("ManageQualityAssuranceS"));

	}
	@Test
	public void verificarUsuárioAlef() {
		given().log().all().contentType("application/json")
				.body("{\"name\":\"Alef\",\"job\":\"ManageQualityAssurance\"}").when()
				.get("https://reqres.in/api/users/2")
				.then()
				.log().all()
				.statusCode(201)
				.body("id", is(notNullValue()))
				.body("name", is("Alef"))
				.body("job", is("ManageQualityAssuranceS"));

	}
}
