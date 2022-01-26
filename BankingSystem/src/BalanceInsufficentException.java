
public class BalanceInsufficentException extends Exception{
	private String message;
	private String currency;
	public BalanceInsufficentException(String currency) {
		this.currency=currency;
	}
	
	@Override
	public String getMessage() {
	message = "Insufficient "+ currency +" funds" ;
		return this.message;
	}
}
