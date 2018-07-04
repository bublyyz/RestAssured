package com.restassured.test;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class CRUDOperationsTest {
	
	//@Test
	public void getTest(){
		
		Response response = RestAssured.get("http://localhost:3000/posts");
		int statuscode = response.getStatusCode();
		System.out.println(statuscode);
		
		String body = response.asString();
		System.out.println(body);
		Assert.assertEquals(statuscode, 200);
	}
	
	//@Test
	public void postTest(){
		try{
		//given() provides Request details	
		RequestSpecification request = RestAssured.given();	
		request.header("Content-Type","application/json");
		
		//Create Json object
		JSONObject jsonobj= new JSONObject();
		jsonobj.put("id", "5");
		jsonobj.put("name", "veena");
		jsonobj.put("title", "QA");
		
		//add json object into body
		request.body(jsonobj.toString());
		
		Response response = request.post("http://localhost:3000/posts");
		int statuscode = response.getStatusCode();
		System.out.println(statuscode);
		
		String body = response.asString();
		System.out.println(body);
		Assert.assertEquals(statuscode, 201);	
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//@Test
	public void putTest(){
		//given() provides Request details	
		RequestSpecification request = RestAssured.given();			
		request.header("Content-Type","application/json");
		
		//Create Json object
		JSONObject jsonobj= new JSONObject();
		jsonobj.put("id", "5");
		jsonobj.put("name", "veena");
		jsonobj.put("title", "SQA");
		
		//add json object into body
		request.body(jsonobj.toString());
		
		Response response = request.put("http://localhost:3000/posts/5");
		int statuscode = response.getStatusCode();
		System.out.println(statuscode);
		
		String body = response.asString();
		System.out.println(body);
		Assert.assertEquals(statuscode, 200);			
	}
	
	//@Test
	public void patchTest(){
		//given() provides Request details	
		RequestSpecification request = RestAssured.given();			
		request.header("Content-Type","application/json");
		
		//Create Json object
		JSONObject jsonobj= new JSONObject();
		jsonobj.put("id", "5");
		jsonobj.put("title", "Automation Eng");
		
		//add json object into body
		request.body(jsonobj.toString());
		
		Response response = request.patch("http://localhost:3000/posts/5");
		int statuscode = response.getStatusCode();
		System.out.println(statuscode);
		
		String body = response.asString();
		System.out.println(body);
		Assert.assertEquals(statuscode, 200);	
	}
	
	@Test
	public void deleteTest(){
		//given() provides Request details	
		RequestSpecification request = RestAssured.given();	
		Response response = request.delete("http://localhost:3000/posts/5");
		int statuscode = response.getStatusCode();
		System.out.println(statuscode);
		Assert.assertEquals(statuscode, 200);	
		
		
	}

}
