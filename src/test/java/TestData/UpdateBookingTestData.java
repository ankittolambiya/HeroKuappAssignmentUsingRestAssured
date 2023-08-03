package TestData;

import api.payload.BookingdatesforUpdateRequest;
import api.payload.UpdateBookingRequest;

public class UpdateBookingTestData {

	public UpdateBookingRequest updateBooking()
	{
		UpdateBookingRequest updateBookingRequest = new UpdateBookingRequest();

		updateBookingRequest.setFirstname("James");
		updateBookingRequest.setLastname("Prince");
		updateBookingRequest.setTotalprice(222);
		updateBookingRequest.setDepositpaid(false);

		BookingdatesforUpdateRequest bookingdatesforUpdateRequest = new BookingdatesforUpdateRequest();

		bookingdatesforUpdateRequest.setCheckin("2019-01-01");
		bookingdatesforUpdateRequest.setCheckout("2020-01-01");

		updateBookingRequest.setBookingdates(bookingdatesforUpdateRequest);

		updateBookingRequest.setAdditionalneeds("Brunch");
		
		
		return updateBookingRequest;
	}

}
