
public class Customer {
	//Customer informations
	private String customerName;
	private String customerID;
	private String customerJob;
	public Customer(String customerName, String customerID, String customerJob) {
		this.customerName = customerName;
		this.customerID = customerID;
		this.customerJob = customerJob;
	}
	
	public String getCustomerName() {
		return customerName;
	}

	public String getCustomerID() {
		return customerID;
	}

	public String getCustomerJob() {
		return customerJob;
	}
	
	public String toString() {
		return customerName + "\nID: " + customerID + "\nJob: " + customerJob;
		
	}
	
}
