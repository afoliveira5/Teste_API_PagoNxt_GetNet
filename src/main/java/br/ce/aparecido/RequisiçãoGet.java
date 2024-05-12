package br.ce.aparecido;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;

public class RequisiçãoGet {

	public static void main(String[] args) {
		Response response = RestAssured.request(Method.GET, "https://reqres.in/api/users?page=1");
		//Response response = RestAssured.request(Method.GET, "http://restapi.wcaquino.me/ola");

		System.out.println(response.getBody().asString());
	}
}
