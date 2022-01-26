import java.util.Scanner;

public class BankAccountManager {
	private Customer customer;
	private String name;
	private String surname;
	private String id;
	private String job;
	private String currency;
	private double amount;
	// Account informations
	private double balanceTRY;
	private double balanceEUR;
	private double balanceUSD;
	private double previusActivityTRY;
	private double previusActivityEUR;
	private double previusActivityUSD;

	Scanner scanner = new Scanner(System.in);

	public BankAccountManager() {
		balanceTRY = 0;
		balanceEUR = 0;
		balanceUSD = 0;
		previusActivityTRY = 0;
		previusActivityEUR = 0;
		previusActivityUSD = 0;

	}

	public double getBalanceTRY() {
		return balanceTRY;
	}

	public double getBalanceEUR() {
		return balanceEUR;
	}

	public double getBalanceUSD() {
		return balanceUSD;
	}

	public double getPreviusActivityTRY() {
		return previusActivityTRY;
	}

	public double getPreviusActivityEUR() {
		return previusActivityEUR;
	}

	public double getPreviusActivityUSD() {
		return previusActivityUSD;
	}

	public void addCustomer() {

		name = scanner.next();
		surname = scanner.next();
		id = scanner.next();
		job = scanner.next();
		customer = new Customer(name + " " + surname, id, job);
	}

	public boolean isUserValid(String id) {
		if (!customer.getCustomerID().equalsIgnoreCase(id)) {
			return false;
		} else {
			return true;
		}
	}

	public void deposite() throws InvalidCurrencyException {
		System.out.println("Welcome " + customer.toString());
		System.out.println("Please enter the amount you wish to deposit and currency type (TRY/EUR/USD) respectively. ");
		amount = scanner.nextDouble();
		currency = scanner.next();

		if (currency.equalsIgnoreCase("TRY")) {
			balanceTRY += amount;
			previusActivityTRY = amount;
			System.out.println("Deposited: " + amount + " TRY");
		} else if (currency.equalsIgnoreCase("EUR")) {
			balanceEUR += amount;
			previusActivityEUR = amount;
			System.out.println("Deposited: " + amount + " EUR");
		} else if (currency.equalsIgnoreCase("USD")) {
			balanceUSD += amount;
			previusActivityUSD = amount;
			System.out.println("Deposited: " + amount + " USD");
		} else {
			throw new InvalidCurrencyException(currency);
		}

	}

	public void withdraw() throws BalanceInsufficentException, InvalidCurrencyException {
		System.out.println("Welcome " + customer.toString());
		System.out.println("Please enter the amount you wish to withdraw and currency type (TRY/EUR/USD) respectively. ");
		amount = scanner.nextDouble();
		currency = scanner.next();

		if (currency.equalsIgnoreCase("TRY")) {

			if (balanceTRY >= amount) {
				balanceTRY -= amount;
				previusActivityTRY = -amount;
				System.out.println("Withdrawed: " + amount + " TRY");
			} else {
				throw new BalanceInsufficentException("TRY");
			}

		} else if (currency.equalsIgnoreCase("EUR")) {

			if (balanceEUR >= amount) {
				balanceEUR -= amount;
				previusActivityEUR = -amount;
				System.out.println("Withdrawed: " + amount + " EUR");
			} else {
				throw new BalanceInsufficentException("EUR");
			}

		} else if (currency.equalsIgnoreCase("USD")) {

			if (balanceUSD >= amount) {
				balanceUSD -= amount;
				previusActivityUSD = -amount;
				System.out.println("Withdrawed: " + amount + " USD");
			} else {
				throw new BalanceInsufficentException("USD");
			}

		} else {
			throw new InvalidCurrencyException(currency);
		}

	}

	public void printActivities() {
		System.out.println("Welcome " + customer.toString());
		System.out.println("Last TRY activity on your account: " + getPreviusActivityTRY());
		System.out.println("Last EUR activity on your account: " + getPreviusActivityEUR());
		System.out.println("Last USD activity on your account: " + getPreviusActivityUSD());
	}


	public String printBalanceInformation() {
		System.out.println("Welcome " + customer.toString());
		String info = "You have " + balanceTRY + " TRY. \nYou have " + balanceEUR + " EUR. \nYou have " + balanceUSD
				+ " USD. ";
		return info;

	}

}
