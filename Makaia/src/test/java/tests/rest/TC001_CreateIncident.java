package tests.rest;

import java.io.File;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import lib.rest.RESTAssuredBase;


public class TC001_CreateIncident extends RESTAssuredBase{
	
	@BeforeTest//Reporting
	public void setValues() {
		testCaseName = "Create a new Incident (REST)";
		testDescription = "Create a new Incident and Verify";
		nodes = "Incident";
		authors = "Sarath";
		category = "REST";
		dataFileName = "TC001";
		dataFileType = "JSON";
	}

	@Test(dataProvider = "fetchData")
	public void createIncident(File file) {		
				
		Response response = postWithBodyAsFileAndUrl(file, "table/incident");

		verifyContentType(response, "application/Json");
		
		verifyResponseCode(response, 201);
		
		verifyContentWithKey(response, "result.short_description", "This is Rest Assured Automation framework - Makaia");
		
	}


}





