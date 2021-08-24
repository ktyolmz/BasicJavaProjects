
public class Customer {

	private String id;
	private String name;
	private String surname;
	private String dob;
	private String nation;
	private String phone;
	private int rentedCarIndex;
	private String dateCollection; 
	private String dateReturned;

	Customer(String id) {

		this.id = id;

	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getRentedCarIndex() {
		return rentedCarIndex;
	}

	public void setRentedCarIndex(int rentedCarIndex) {
		this.rentedCarIndex = rentedCarIndex;
	}

	public String getDateCollection() {
		return dateCollection;
	}

	public void setDateCollection(String dateCollection) {
		this.dateCollection = dateCollection;
	}

	public String getDateReturned() {
		return dateReturned;
	}

	public void setDateReturned(String dateReturned) {
		this.dateReturned = dateReturned;
	}

	public void setCustomerInfo(String name, String surname, String dob, String nation, String phone, int carIndex, String dateCollection, String dateReturned) {

		setName(name);
		setSurname(surname);
		setDob(dob);
		setNation(nation);
		setPhone(phone);
		setRentedCarIndex(carIndex);
		setDateCollection(dateCollection);
		setDateReturned(dateReturned);
	}

	public void printCustomerInfo(String ID) {

		System.out.println("Name Surname: " + getName().toUpperCase() + " " + getSurname().toUpperCase() + " " + getNation().toUpperCase());
		System.out.println("Date of Birth: " + getDob());
		System.out.println("ID: " + id + " Contact Number: " + getPhone());
		System.out.println("Date Of Collection: " + getDateCollection());
		System.out.println("Date Returned: " + getDateReturned());
		System.out.println("");
	}
	
	

}
