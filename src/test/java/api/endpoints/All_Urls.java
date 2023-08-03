package api.endpoints;

public class All_Urls {

	public static String base_url = "https://restful-booker.herokuapp.com";
	
	public static String POST_CreateToken = base_url + "/auth"; 
	
	public static String GET_BookingIds = base_url + "/booking";
	
	public static String GET_Booking = base_url + "/booking/{id}"; 
	
	public static String POST_CreateBooking = base_url + "/booking";
	
	public static String PUT_UpdateBooking = base_url + "/booking/{id}";
	
	public static String PUT_PartialUpdateBooking = base_url + "/booking/{id}";
	
	public static String DELETE_removeBooking = base_url + "/booking/{id}";
}
