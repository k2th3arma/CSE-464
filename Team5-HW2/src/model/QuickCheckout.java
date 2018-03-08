package model;

public class QuickCheckout {
	private String firstName;
	private String lastName;
	private String cardType;
	private String cardNumber;
	private String cvv;
	private String month;
	private String year;
	private String billing;
	private String shipping;
	
	public QuickCheckout(){
		super();
	}

	public QuickCheckout(String firstName, String lastName, String cardType,
			String cardNumber, String cvv, String month, String year,
			String billing, String shipping) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.cardType = cardType;
		this.cardNumber = cardNumber;
		this.cvv = cvv;
		this.month = month;
		this.year = year;
		this.billing = billing;
		this.shipping = shipping;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getBilling() {
		return billing;
	}

	public void setBilling(String billing) {
		this.billing = billing;
	}

	public String getShipping() {
		return shipping;
	}

	public void setShipping(String shipping) {
		this.shipping = shipping;
	}
	
	
	
	
}
