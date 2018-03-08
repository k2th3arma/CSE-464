package model;

public class Transaction {

	private int creditCardID;
	private String cardHolderName;
	private String cardNumber;
	private float balance;
	private String cardType;
	private int userID;
	private String CVV;
	private String expiration;
	
	public Transaction(){
		super();
	}

	public Transaction(String cardHolderName, String cardNumber, float balance,
			String cardType, int userID, String CVV, String expiration) {
		super();
		this.cardHolderName = cardHolderName;
		this.cardNumber = cardNumber;
		this.balance = balance;
		this.cardType = cardType;
		this.userID = userID;
		this.CVV = CVV;
		this.expiration = expiration;
	}
	public int getCreditCardID() {
		return creditCardID;
	}
	public void setCreditCardID(int creditCardID) {
		this.creditCardID = creditCardID;
	}
	public String getCardHolderName() {
		return cardHolderName;
	}
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getCVV() {
		return CVV;
	}
	public void setCVV(String cVV) {
		CVV = cVV;
	}
	public String getExpiration() {
		return expiration;
	}
	public void setExpiration(String expiration) {
		this.expiration = expiration;
	}
	
	
	
	
}
