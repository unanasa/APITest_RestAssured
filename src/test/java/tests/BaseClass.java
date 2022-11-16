package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfig = new ReadConfig();
	Response res;
	JsonPath jsnPath;
	
	public String baseURL = readconfig.getBaseURL();
	public static Logger logger;
	
	
	@BeforeClass
	public void extractResponse() {
		try{
			logger = Logger.getLogger("Assurity_APITest");
			PropertyConfigurator.configure("log4j.properties");
			baseURI = baseURL;
		
		res = 	given().
				get("/v1/Categories/6327/Details.json?catalogue=false").
				then().
				statusCode(200).
				log().
				body().extract().response();
		logger.info("------- Opened the url and extracted response ----------");
		jsnPath = res.jsonPath();
		}catch(Exception e) {
			System.out.println("An issue has been detected.. : "+e.getMessage());
			logger.error(e);
		}
	}
	
	

}
