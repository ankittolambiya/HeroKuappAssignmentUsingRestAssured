package api.endpoints;

import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import api.payload.CreateBookingRequest;
import api.payload.CreateBookingResponse;
import api.payload.CreateTokenRequest;
import api.payload.UpdateBookingRequest;
import api.test.CreateTokenTest;

// Create for performing CRUD operation mainly such as Create, Read, Update, Delete requests 

public class BookingEndPoints {

	public static Response createToken(CreateTokenRequest tokenrequest_Payload)
	{
		Response  response = given()
				.header("Content-Type","application/json")
				.body(tokenrequest_Payload)
				.when()
				.post(All_Urls.POST_CreateToken);

		return response;
	}

	public static Response readBookingIds()
	{
		Response response = given()
				.when()
				.get(All_Urls.GET_BookingIds);

		return response;
	}

	public static Response readBooking(int booking_id)
	{
		Response response = given()
				.pathParam("id", booking_id)
				.when()
				.get(All_Urls.GET_Booking);

		return response;
	}

	public static Response createBooking(CreateBookingRequest createbookingPayload)
	{
		Response  response = given()
				.header("Content-Type","application/json")
				//	.contentType(ContentType.JSON)
				.body(createbookingPayload)
				//	.expect().defaultParser(Parser.JSON)
				.when()
				.post(All_Urls.POST_CreateBooking);

		return response;
	}



	public static Response updateBooking(int update_BookingId, UpdateBookingRequest updatebookingPayload)
	{
		Response  response = given()

				.header("Content-Type","application/json")

				.header("Accept","application/json")

				.header("Cookie","token="+CreateTokenTest.token)

				.pathParam("id", update_BookingId)

				.body(updatebookingPayload)

				.when()

				.put(All_Urls.PUT_UpdateBooking);

		return response;
	}

	public static Response deleteBooking(int delete_BookingId)
	{
		Response  response = given()

				.header("Content-Type","application/json")

				.header("Cookie","token="+CreateTokenTest.token)

				.pathParam("id", delete_BookingId)

				.when().log().all()

				.delete(All_Urls.DELETE_removeBooking);

		return response;
	} 
}
