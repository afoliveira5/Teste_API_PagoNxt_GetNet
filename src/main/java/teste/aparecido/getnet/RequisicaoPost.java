package teste.aparecido.getnet;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class RequisicaoPost {
	@BeforeClass
	public static void primeiroPassoDoPost() {
		RestAssured.baseURI = "https://reqres.in";
		RestAssured.basePath = "/api";
	}

	@Test
	public void criareSalvarUsuarioAparecido() {
		User user = new User("Aparecido", "TeamLead");

		User usuarioInserido = given().log().all().contentType("application/json").body(user).when().post("/users")
				.then().log().all().statusCode(201).extract().body().as(User.class);
		System.out.println(usuarioInserido);
		Assert.assertThat(usuarioInserido.getId(), notNullValue());
		assertEquals("Aparecido", usuarioInserido.getName());

	}

	@Test
	public void criareSalvarUsuarioAnderson() {

		User user = new User("Anderson", "LeadQualityAssurance");

		User usuarioInserido = given().log().all().contentType("application/json").body(user).when().post("/users")
				.then().log().all().statusCode(201).extract().body().as(User.class);
		System.out.println(usuarioInserido);
		Assert.assertThat(usuarioInserido.getId(), notNullValue());
		assertEquals("Aparecido", usuarioInserido.getName());

	}

}
