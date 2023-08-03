package TestData;

import api.payload.Bookingdates;
import api.payload.CreateBookingRequest;

public class CreateTestData {

	public CreateBookingRequest addBooking()
	{
		CreateBookingRequest createBookingRequest = new CreateBookingRequest();

		createBookingRequest.setFirstname("Jim");
		createBookingRequest.setLastname("Brown");
		createBookingRequest.setTotalprice(111);
		createBookingRequest.setDepositpaid(true);

		Bookingdates bookingdatesRequest = new Bookingdates();

		bookingdatesRequest.setCheckin("2018-01-01");
		bookingdatesRequest.setCheckout("2019-01-01");

		createBookingRequest.setBookingdates(bookingdatesRequest);

		createBookingRequest.setAdditionalneeds("Breakfast");
		
		
		return createBookingRequest;
	}

}