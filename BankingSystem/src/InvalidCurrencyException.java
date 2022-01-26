
public class InvalidCurrencyException extends Exception{
	private String message;
	private String userInput;
	
	
	public InvalidCurrencyException(String userInput) {
		this.userInput=userInput;
	}
	
	@Override
	public String getMessage() {
		message = userInput + " is invalid. Please use TRY/EUR/USD";
		return message;
	}

}
