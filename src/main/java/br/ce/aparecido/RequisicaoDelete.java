package br.ce.aparecido;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.BeforeClass;
import org.junit.Test;

public class RequisiçãoDelete {
	
	@Test
	public void deveSalvarUsuárioAlef() {
		User user = new User ("Alef","ManageQualityAssurance");
		given().log().all().contentType("application/json")
				.body(user)
				.when()
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
				.statusCode(204);
				//.body("id", is(notNullValue()))
				//.body("name", is("Alef"))
				//.body("job", is("ManageQualityAssuranceS"))
	}
	@Test
	public void verificarUsuárioAlef() {
		given().log().all().contentType("application/json")
				.body("{\"name\":\"Alef\",\"job\":\"ManageQualityAssurance\"}").when()
				.get("https://reqres.in/api/users/2")
				.then()
				.log().all()
				.statusCode(200);
				//.body("id", is(notNullValue()))
				//.body("name", is("Alef"))
				//.body("job", is("ManageQualityAssuranceS"));

	}
}
