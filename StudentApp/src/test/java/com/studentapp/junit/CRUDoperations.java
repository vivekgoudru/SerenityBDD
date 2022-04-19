package com.studentapp.junit;

import org.assertj.core.api.Assertions;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.studentapp.model.StudentClass;
import com.studentapp.testbase.TestBase;

import org.junit.AfterClass;
import org.junit.Assert;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
public class CRUDoperations extends TestBase{
	

	
	static int id=101;
	static String employeeName="Viv";
	static int employeeSalary=200000;
	static int employeeAge=25;
	static String profileImage=":)";
	
	
	@Title("This opeartion will create new record in application")
	@Test
	public void post() {
		
		StudentClass st = new StudentClass();
		
		st.setID(id);
		st.setEmplyeeName(employeeName);
		st.setEmployeeSalary(employeeSalary);
		st.setEmployeeAge(employeeAge);
		st.setProfileImage(profileImage);
		SerenityRest.given()
		.header("Content-type", "application/json")
		.when()
		.log()
		.all()
		.body(st)
		.post("/create")
		.then()
		.log()
		.all()
		.statusCode(200);
		
		Assertions.assertThat(201);
		
		
	}
	

}
