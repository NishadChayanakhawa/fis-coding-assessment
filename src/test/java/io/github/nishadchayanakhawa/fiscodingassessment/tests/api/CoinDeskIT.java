package io.github.nishadchayanakhawa.fiscodingassessment.tests.api;

//import section
//java utilities
import java.util.Map;
//testng
import org.testng.annotations.Test;

//custom framework libraries
import io.nishadc.automationtestingframework.testngcustomization.TestFactory;
import io.nishadc.automationtestingframework.testinginterface.restapi.RESTAPITestHelper;
import io.nishadc.automationtestingframework.testinginterface.restapi.RESTAPITestHelper.RequestMethod;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

/**
 * <b>Class Name</b>: CoinDeskIT<br>
 * <b>Description</b>: API Test assessment<br>
 * 
 * @author nishad.chayanakhawa
 */
public class CoinDeskIT {

	/**
	 * <b>Method Name</b>: gbpDescriptionTest<br>
	 * <b>Description</b>: Call coinbase service and validate response body<br>
	 */
	@Test
	void gbpDescriptionTest() {

		// Record the test name
		TestFactory.recordTest("GBP description test");

		// Create a request object using the helper method to form a request
		// Parameters are null, indicating no specific headers, query parameters, or
		// body are required
		RequestSpecification request = RESTAPITestHelper.formRequest(null, null, null);

		// Make an API call to the CoinDesk API to get the current Bitcoin price in JSON
		// format
		// Using the GET request method, passing the endpoint URL
		ValidatableResponse response = RESTAPITestHelper.getRespones(request,
				"https://api.coindesk.com/v1/bpi/currentprice.json", RequestMethod.GET);

		// Define the expected response body validation map
		// This checks if the "description" field for GBP (British Pound) in the
		// response body matches the expected value
		Map<String, Object> bodyValidationMap = Map.of("bpi.GBP.description", "British Pound Sterling");

		// Validate the response by checking:
		// 1. The response status code is 200 (HTTP OK)
		// 2. The response body contains the expected values as per the validation map
		RESTAPITestHelper.validateResponse(response, 200, bodyValidationMap);
	}
}
