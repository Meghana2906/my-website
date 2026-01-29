package Stepfiles;

import RestApi.basicsApi;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import reuseableJsonpath.jsonPath;

public class RestApiStepFile {

    basicsApi api = new basicsApi();
    String responseString;
    String placeId;
    String getResponse;
    String newAddress = "70 winter walk, USA";
    String delete1;

    @Given("the user is navigating to base url")
    public void theUserIsNavigatingToBaseUrl() {
        // baseURI set in api constructor
    }

    @When("Adding place and extracting respones")
    public void addingPlaceAndExtractingRespones() {
        responseString = api.addPlace();
    }

    @And("Extract place_id from response")
    public void extractPlace_idFromResponse() {
        placeId = api.extractPlaceId(responseString);
    }

    @And("Update the place with a new address")
    public void updateThePlaceWithANewAddress() {
        api.updateAddress(placeId, newAddress);
    }

    @And("Get place details to verify the address")
    public void getPlaceDetailsToVerifyTheAddress() {
        getResponse = api.getPlaceDetails(placeId);
        System.out.println("Verified address: " + jsonPath.rawToJson(getResponse).getString("address"));
    }

    @Then("Delete api")
    public void deleteApi() {
        delete1=api.deleteapi(placeId);

    }
}
