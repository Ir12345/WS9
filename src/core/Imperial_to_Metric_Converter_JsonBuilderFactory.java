package core;

import java.text.DecimalFormat;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import javax.json.Json;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;


@Path("/")
public class Imperial_to_Metric_Converter_JsonBuilderFactory { 

	DecimalFormat df = new DecimalFormat("####0.00");

	@GET
	@Path("json/kg=>lb/{input}")
	@Produces("application/json")
	public Response kg_to_lb_json(@DefaultValue("1") @PathParam("input") Double input)
	{
		   
		Double kg = input;
		Double lb = kg * 2.2046;

		String kg_out = df.format(kg).toString();
		String lb_out = df.format(lb).toString();
		
		JsonBuilderFactory factory = Json.createBuilderFactory(null);
        JsonObject json = factory.createObjectBuilder()
                
.add("calc", factory.createObjectBuilder().add("conversion", "kg to lb").add("kg", kg_out).add("lb", lb_out)) 
		// adding root element
                 // adding object
                              // adding object
                             // adding object


.add("other conversions", factory.createArrayBuilder().add(factory.createObjectBuilder().add("length", "cm to in").add("temperature", "C to F"))).build();   
                		// adding array
             // adding object
                // adding object of array
           // adding object of array

          
          String out = json.toString(); 
		
		//return "{\"calc\": {\"conversion\": \"kg to lb\", \"kg\": " + kg_out + ", \"lb\": " + lb_out+"," +
//"\"other conversions\":"+
//"[{\"length\":\"cm to in\"},"+
//"{\"temperature\": \"C to F\"}]"
//+"}}";
        // http://localhost/hw8/wsi/conv/json/kg=>lb/100 
         return Response.status(200).entity(out).build();
	}

	@GET
	@Path("json/lb=>kg/{input}")
	@Produces("application/json")
	public Response lb_to_kg_json(@DefaultValue("1") @PathParam("input") Double input)
	{
		
		Double lb = input;
		Double kg = lb * 0.4536; // Formula: kg = lb * 0.4536

		String kg_out = df.format(kg).toString();
		String lb_out = df.format(lb).toString();
		
		JsonBuilderFactory factory = Json.createBuilderFactory(null);
		JsonObject json = factory.createObjectBuilder()
	                
.add("calc", factory.createObjectBuilder().add("conversion", "lb to kg").add("lb", lb_out).add("kg", kg_out)) 

.add("other conversions", factory.createArrayBuilder().add(factory.createObjectBuilder().add("length", "cm to in").add("temperature", "C to F"))).build();   

		
		 String out = json.toString();
		 
		 return Response.status(200).entity(out).build();
	}

	@GET
	@Path("json/cm=>in/{input}")
	@Produces("application/json")
	public Response cm_to_in_json(@DefaultValue("1") @PathParam("input") Double input)
	{

		Double cm = input;
		Double in = cm * 0.3937; // Formula: in = cm * 0.3937

		String cm_out = df.format(cm).toString();
		String in_out = df.format(in).toString();
		
		JsonBuilderFactory factory = Json.createBuilderFactory(null);
		JsonObject json = factory.createObjectBuilder()
	                
.add("calc", factory.createObjectBuilder().add("conversion", "cm to in").add("cm", cm_out).add("in", in_out)) 

.add("other conversions", factory.createArrayBuilder().add(factory.createObjectBuilder().add("weight", "kg to lb").add("temperature", "C to F"))).build();   

		
		 String out = json.toString();
		 
		 return Response.status(200).entity(out).build();

	}

	@GET
	@Path("json/in=>cm/{input}")
	@Produces("application/json")
	public Response in_to_cm_json(@DefaultValue("1") @PathParam("input") Double input)
	{

		
		Double in = input;
		Double cm = in * 2.54; // Formula: cm = in * 2.54

		String cm_out = df.format(cm).toString();
		String in_out = df.format(in).toString();

		JsonBuilderFactory factory = Json.createBuilderFactory(null);
		JsonObject json = factory.createObjectBuilder()
	                
.add("calc", factory.createObjectBuilder().add("conversion", "in to cm").add("in", in_out).add("cm", cm_out)) 

.add("other conversions", factory.createArrayBuilder().add(factory.createObjectBuilder().add("weight", "kg to lb").add("temperature", "C to F"))).build();   

		
		 String out = json.toString();
		 
		 return Response.status(200).entity(out).build();
}

}