package RestApi;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import playload.Payload;
import reuseableJsonpath.jsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.core.IsEqual.equalTo;

public class basicsApi {

    public basicsApi() {

        RestAssured.baseURI = "https://rahulshettyacademy.com";
    }

    public void runAll() {
        String responseString = addPlace();
        System.out.println(responseString);

        String placeId = extractPlaceId(responseString);
        System.out.println("The id is :- " + placeId);

        String newAddress = "70 winter walk, USA";
        updateAddress(placeId, newAddress);

        String getResponse = getPlaceDetails(placeId);
        JsonPath js1 = jsonPath.rawToJson(getResponse);
        System.out.println(js1.getString("address"));

        String deleteResponse  = deleteapi(placeId);


    }

    public String addPlace() {
        return given().log().all()
                .queryParam("key", "qaclick123")
                .header("Content-Type", "application/json")
                .body(Payload.addplace())
                .when()
                .post("maps/api/place/add/json")
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .body("scope", equalTo("APP"))
                .extract().response().asString();
    }

    public String extractPlaceId(String responseString) {
        JsonPath js = new JsonPath(responseString);
        return js.getString("place_id");
    }

    public void updateAddress(String placeId, String newAddress) {
        given().log().all()
                .queryParam("key", "qaclick123")
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "\"place_id\":\"" + placeId + "\",\n" +
                        "\"address\":\"" + newAddress + "\",\n" +
                        "\"key\":\"qaclick123\"\n" +
                        "}")
                .when()
                .put("maps/api/place/update/json")
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .body("msg", equalTo("Address successfully updated"));
    }

    public String getPlaceDetails(String placeId) {
        return given().log().all()
                .queryParam("key", "qaclick123")
                .queryParam("place_id", placeId)
                .when()
                .get("maps/api/place/get/json")
                .then()
                .assertThat().statusCode(200).log().all()
                .extract().response().asString();
    }


    public String deleteapi(String placeId) {
        return given().log().all()
                .queryParam("key", "qaclick123")
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "    \"place_id\":\"" + placeId + "\"\n" +
                        "}")
                .when()
                .delete("maps/api/place/delete/json")
                .then()
                .assertThat().statusCode(200).log().all()
                .extract().response().asString();
    }

    public static void main(String[] args) {
        basicsApi apiDemo = new basicsApi();
        apiDemo.runAll();
    }
}
