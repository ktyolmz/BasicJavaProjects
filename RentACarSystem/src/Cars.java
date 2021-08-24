
public class Cars {

	private String cars[] = { "Ford, Fiesta, 2015", "Ford, Focus, 2011", "Opel, Astra, 2018", "Opel, Insignia, 2017",
			"Honda, Civic, 2016", "BMW, 118i, 2015", "BMW, 320d, 2016", "Mercedes, CLK 500, 2007",
			"Mercedes, S 600, 2010", "Bugatti, Chiron, 2018" };
	private int prices[] = { 100, 150, 180, 200, 170, 230, 260, 250, 280, 500 };
	private int counts[] = { 10, 3, 5, 2, 4, 3, 2, 4, 2, 1 };
	private boolean avaible;
	private String dateCollection;
	private String dateReturned;

	public boolean isAvaible(int i) {
		if (counts[i] >= 1) {
			avaible = true;
			return avaible;
		} else {
			avaible = false;
			return avaible;
		}

	}

	public void setAvaible(boolean avaible) {
		this.avaible = avaible;
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

	public void viewAll() {

		for (int i = 0, j = 1; i < cars.length && j <= cars.length; i++, j++) {
			String car = cars[i];
			String name = car.substring(0, car.indexOf(','));
			String model = car.substring(car.indexOf(" "), car.lastIndexOf(','));
			String year = car.substring(car.lastIndexOf(' ') + 1);
			String carName = name.concat(model);
			System.out.println(j + "-" + carName + " " + year + " (" + prices[i] + " TL)");
		}
		System.out.println("");

	}

	public void viewAvaible() {

		for (int i = 0, j = 1; i < cars.length && j <= cars.length; i++, j++) {
			String car = cars[i];
			String name = car.substring(0, car.indexOf(','));
			String model = car.substring(car.indexOf(" "), car.lastIndexOf(','));
			String carName = name.concat(model);
			System.out.println(j + "-" + carName + " (" + prices[i] + " TL) - " + counts[i] + " available.");
		}
		System.out.println("");

	}

	public void viewBrands() {

		String[] brands = new String[cars.length];
		for (int i = 0; i < cars.length; i++) {
			String car = cars[i];
			String brand = car.substring(0, car.indexOf(','));
			brands[i] = brand;
		}
		for (int i = 0; i < brands.length; i++) {
			if (!brands[i].equals(brands[brands.length - 1]) && brands[i].equals(brands[i + 1])) {
				System.out.println(brands[i]);
			} else if (!brands[i].equals(brands[brands.length - 1]) && !brands[i].equals(brands[i + 1])
					&& !brands[i].equals(brands[i - 1])) {
				System.out.println(brands[i]);
			} else if (brands[i].equals(brands[brands.length - 1]) && !brands[i].equals(brands[i - 1])) {
				System.out.println(brands[i]);
			}

		}
		System.out.println("");

	}

	public void viewByPrice(int min, int max) {

		for (int i = 0, j = 0, n = 1; i < prices.length; i++, j++, n++) {
			if (min <= prices[i] && max >= prices[j]) {
				String car = cars[i];
				String name = car.substring(0, car.indexOf(','));
				String model = car.substring(car.indexOf(" "), car.lastIndexOf(','));
				String carName = name.concat(model);
				System.out.println(n + "-" + carName + " (" + prices[i] + " TL)");
			}
		}
		if (max < 100) {
			System.out.println("No cars found between these prices!");
		}

		System.out.println("");

	}

	public void rent(int index, String dateCollect, String dateReturn) {

		if (index >= 0 && index <= cars.length) {
			int count = counts[index];
			counts[index] = count - 1;
		} else {
			System.out.println("Invalid input.");
		}

	}

	public void retunCar(int index) {

		if (index <= cars.length && index >= 0) {
			int count = counts[index];
			String car = cars[index];
			String name = car.substring(0, car.indexOf(','));
			String model = car.substring(car.indexOf(" "), car.lastIndexOf(','));
			String year = car.substring(car.lastIndexOf(' ') + 1);
			String carName = name.concat(model);
			System.out.println("You have returned " + carName + " (" + year + "). Thank you for choosing our company.");
			counts[index] = count + 1;

		} else {
			System.out.println("Wrong car !!");
		}
		System.out.println("");

	}

	public void printRentedCar(int select) {

		String car = cars[select];
		String name = car.substring(0, car.indexOf(','));
		String model = car.substring(car.indexOf(" "), car.lastIndexOf(','));
		String year = car.substring(car.lastIndexOf(' ') + 1);
		int price = prices[select];
	 
		
		System.out.println("You rented " + name + " " + model + " (" + year + ") " + price + " TL per day.");
		System.out.println("");
	}

	public void totalPrice(int select, String dateCollect, String dateReturn) {
		String collectedDay =  dateCollect.substring(0, 2);
		String collectedMonth =  dateCollect.substring(3, 5);
		String collectedYear =  dateCollect.substring(6);
		
		String returnedDay =  dateReturn.substring(0, 2);
		String returnedMonth =  dateReturn.substring(3, 5);
		String returnedYear =  dateReturn.substring(6);
		
		int numDays = Integer.parseInt(returnedDay) - Integer.parseInt(collectedDay);
		int numMonth = Integer.parseInt(returnedMonth) - Integer.parseInt(collectedMonth);
		int numYear = Integer.parseInt(returnedYear) - Integer.parseInt(collectedYear);
		
		numDays = numDays + numMonth*30 + numYear*365;
		
		int price = prices[select];
		float totalPrice = numDays * price;
		System.out.println("Total Price is: " + totalPrice);
		System.out.println("");
		
	}

}
