package api.payload;

public class GetBookingIdResponse {

	private String firstname;
	private String lastname;
	private int totalprice;
	private boolean depositpaid;
	BookingdatesForGetResponse bookingdates;
	private String additionalneeds;
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Integer getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(Integer totalprice) {
		this.totalprice = totalprice;
	}
	public Boolean getDepositpaid() {
		return depositpaid;
	}
	public void setDepositpaid(Boolean depositpaid) {
		this.depositpaid = depositpaid;
	}
	public BookingdatesForGetResponse getBookingdates() {
		return bookingdates;
	}
	public void setBookingdates(BookingdatesForGetResponse bookingdates) {
		this.bookingdates = bookingdates;
	}
	public String getAdditionalneeds() {
		return additionalneeds;
	}
	public void setAdditionalneeds(String additionalneeds) {
		this.additionalneeds = additionalneeds;
	}
}
