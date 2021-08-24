import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Customer[] customers = new Customer[0];
		Cars cars = new Cars();
		Scanner input = new Scanner(System.in);
		int num;

		System.out.println("Welcome to Rent a Car Company");
		do {

			System.out.println("1 View All\r\n" + "2 View Available\r\n" + "3 View Brands\r\n" + "4 View By Price\r\n"
					+ "5 Rent\r\n" + "6 Return\r\n" + "7 Receipt" + "\n8 Exit");
			System.out.println("Operation: ");
			num = input.nextInt();

			switch (num) {

			case 1:
				cars.viewAll();
				break;
			case 2:
				cars.viewAvaible();
				break;
			case 3:
				cars.viewBrands();
				break;
			case 4:
				System.out.println("Please enter minimum and maximum price: ");
				int min = input.nextInt();
				int max = input.nextInt();
				cars.viewByPrice(min, max);
				break;
			case 5:
				cars.viewAll();
				System.out.println("Please select a car to rent: ");
				int select = input.nextInt();
				int index = select - 1;
				System.out.println("Date of Collection (DD/MM/YYYY) : ");
				String dateCollection = input.next();
				System.out.println("Date Return (DD/MM/YYYY) : ");
				String dateReturned = input.next();

				if (cars.isAvaible(index)) {

					System.out.println("Please enter your ID: ");
					String id = input.next();
					System.out.println("Please enter your name and surname: ");
					String name = input.next();
					String surname = input.next();
					System.out.println("Please enter your date of birth (DD/MM/YY): ");
					String dob = input.next();
					System.out.println("Please enter your nationality: ");
					String nation = input.next();
					System.out.println("Please enter your phone number: ");
					String phone = input.next();

					Customer customer = new Customer(id);

					customer.setCustomerInfo(name, surname, dob, nation, phone, index, dateCollection, dateReturned);
					Customer[] tempArr = new Customer[customers.length + 1];

					for (int i = 0; i < customers.length; i++) {
						tempArr[i] = customers[i];

					}
					tempArr[customers.length] = customer;
					customers = tempArr;

					customer.printCustomerInfo(id);
					cars.rent(index, dateCollection, dateReturned);
					cars.printRentedCar(index);
					cars.totalPrice(index, dateCollection, dateReturned);
				} else {
					System.out.println("Car is not avaible. \n");
				}

				break;
			case 6:

				cars.viewAll();
				System.out.println("Please select a car to return: ");
				select = input.nextInt();
				index = select - 1;
				System.out.println("Please enter your ID: ");
				String id = input.next();

				for (int i = 0; i < customers.length; i++) {

					if (customers[i].getId().equals(id)) {
						customers[i].printCustomerInfo(id);
						int customerCarIndex = customers[i].getRentedCarIndex();
						String dateCollected = customers[i].getDateCollection();
						String dateReturn = customers[i].getDateReturned();
						if (customerCarIndex == index) {
							cars.retunCar(index);
							cars.totalPrice(index, dateCollected, dateReturn);
						} else {
							System.out.println("You have not rented the vehicle you want to return.");
						}

					} else {
						System.out.println("Wrong ID");
					}
				}

				break;
			case 7:
				System.out.println("Please enter your ID for receipt.");
				id = input.next();

				for (int i = 0; i < customers.length; i++) {

					if (customers[i].getId().equals(id)) {
						customers[i].printCustomerInfo(id);
						int customerCarIndex = customers[i].getRentedCarIndex();
						String dateCollected = customers[i].getDateCollection();
						String dateReturn = customers[i].getDateReturned();
						
						cars.printRentedCar(customerCarIndex);
						cars.totalPrice(customerCarIndex, dateCollected, dateReturn);
						
					} else {
						System.out.println("Wrong ID");
					}
				}

				break;
			case 8:
				System.out.println("Have a nice day...");
				break;
			default:
				System.out.println("Invalid Input. Please try again. \n");
				break;
			}

		} while (num != 8);

		input.close();
	}

}
