package api.payload;

public class UpdateBookingRequest {

	private String firstname;
	private String lastname;
	private int totalprice;
	private boolean depositpaid;
	BookingdatesforUpdateRequest bookingdatesforUpdateRequest;
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
	public BookingdatesforUpdateRequest getBookingdates() {
		return bookingdatesforUpdateRequest;
	}
	public void setBookingdates(BookingdatesforUpdateRequest bookingdatesforUpdateRequest) {
		this.bookingdatesforUpdateRequest = bookingdatesforUpdateRequest;
	}
	public String getAdditionalneeds() {
		return additionalneeds;
	}
	public void setAdditionalneeds(String additionalneeds) {
		this.additionalneeds = additionalneeds;
	}
}
