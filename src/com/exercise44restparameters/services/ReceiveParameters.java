package com.exercise44restparameters.services;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.HEAD;
import javax.ws.rs.PUT;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.QueryParam;
import javax.ws.rs.PathParam;
import org.json.JSONObject;

@Path("/Hello")
public class ReceiveParameters {
	
	@POST
	public String SayHello() {
		return "Hello from POST Method";
	}
	
	@GET
	public String SayHelloMsg() {
		return "Hello from GET method";
	}
	
	@PUT
	public String SayHelloPut() {
		return "Hello from PUT method";
	}
	
	@DELETE
	public String SayHelloDelete() {
		return "Hello from DELETE method";
	}
	
	@HEAD
	public String SayHelloHEAD() {
		return "Hello from HEAD method";
	}
	
	@OPTIONS
	public String SayHelloOPTIONS() {
		return "Hello from OPTIONS method";
	}
	
	@GET
	@Path("/HelloWithName")
	public String SayHelloKnown(@QueryParam("name") String name) {
		return "Hello "+name;
	}
	
	@GET
	@Path("/{name}")
	public String SayHelloKnown2(@PathParam("name") String name) {
		return "Hello "+name+" this is generation.";
	}
	
	@POST
	@Path("/SumNumbers")
	public int SumNumbers(@QueryParam("number1") int number1, @QueryParam("number2") int number2) {
		return number1+number2;
	}
	
	@POST
	@Path("/factorial")
	public String FactorialNumber(@QueryParam("number") int number) {
		int tempA = 0;
		int tempB = 1;
		long factorial = 1;
		JSONObject json = new JSONObject();
		for(int i=0;factorial<number;i++) {
			json.put("Iteration "+i, factorial);
			factorial = tempA +tempB;
			tempA = tempB;
			tempB = (int) (factorial);
		}
		return json.toString();
	}
	
}
