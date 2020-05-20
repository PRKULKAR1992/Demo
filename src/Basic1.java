import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class Basic1 {

	public static void main(String[] args) {
		
		RestAssured.baseURI="https://reqres.in";
		
		given().log().all().header("Content-Type","application/json").body("{\r\n" + 
				"    \"name\": \"morpheus\",\r\n" + 
				"    \"job\": \"leader\"\r\n" + 
				"}").
        when().post("/api/users").
        then().log().all().assertThat().statusCode(201)
       .body("job", equalTo("leader"));
//        .header("Server", "cloudflare");
	}

}
