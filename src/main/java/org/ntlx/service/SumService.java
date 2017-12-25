package org.ntlx.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("sum")
public class SumService {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public String dummyGet() {
    JsonObject result = new JsonObject();
    result.addProperty("getCall", "succeeded");
    return result.toString();
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  public String dummyPost(String body) {
    CalculatorInput input = new Gson().fromJson(body, CalculatorInput.class);
    JsonObject result = new JsonObject();
    result.addProperty("result", input.calculateSum());
    return result.toString();
  }
}
