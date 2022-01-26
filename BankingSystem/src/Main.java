import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		ArrayList<BankAccountManager> bankAccounts = new ArrayList<BankAccountManager>();
		int operation;
		System.out.println("** TRUST US BANK **");

		do {
			System.out.println("Please select an operation: ");
			System.out.println("1- Create Account " + "\n2- Deposit" + "\n3- Withdraw" + "\n4- Check Balance"
					+ "\n5- Check Previous Activities" + "\n6- Exit ");
			operation = input.nextInt();

			switch (operation) {
			case 1:
				System.out.println("Please enter your name, your ID and your job respectively. ");
				BankAccountManager bankAccount = new BankAccountManager();
				bankAccount.addCustomer();
				bankAccounts.add(bankAccount);
				break;

			case 2:
				System.out.println("Please enter your ID: ");
				String id = input.next();
				for (int i = 0; i < bankAccounts.size(); i++) {

					if (bankAccounts.get(i).isUserValid(id)) {

						try {
							bankAccounts.get(i).deposite();
						} catch (InvalidCurrencyException e) {
							System.out.println(e.getMessage());
						}
						break;
					}

				}
				break;
			case 3:
				System.out.println("Please enter your ID: ");
				id = input.next();
				for (int i = 0; i < bankAccounts.size(); i++) {

					if (bankAccounts.get(i).isUserValid(id)) {

						try {
							bankAccounts.get(i).withdraw();
						} catch (InvalidCurrencyException e) {
							System.out.println(e.getMessage());
						} catch (BalanceInsufficentException e) {
							System.out.println(e.getMessage());
						}
						break;
					}
				}
				break;
			case 4:
				System.out.println("Please enter your ID: ");
				id = input.next();
				for (int i = 0; i < bankAccounts.size(); i++) {
					if (bankAccounts.get(i).isUserValid(id)) {

						System.out.println(bankAccounts.get(i).printBalanceInformation());
						break;
					} else {
						System.out.println("Unvalid ID. User cannot found.");
					}
				}
				break;
			case 5:
				System.out.println("Please enter your ID: ");
				id = input.next();
				for (int i = 0; i < bankAccounts.size(); i++) {
					if (bankAccounts.get(i).isUserValid(id)) {
						bankAccounts.get(i).printActivities();
						break;
					}
				}
				break;
			case 6:
				System.out.println("Have a nice day...");
			}

		} while (operation != 6);
		input.close();

	}

}
