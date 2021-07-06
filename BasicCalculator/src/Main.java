import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		char op;
		double z, x, y;
		do {

			System.out.println("Choose an operation : \n1) + \n2) - \n3) / \n4) * \n5) \"E\" for exit");
			op = input.next().charAt(0);

			if (op != 'E') {
				System.out.println("Enter first number : ");
				x = input.nextDouble();

				System.out.println("Enter second number : ");
				y = input.nextDouble();
				System.out.println("");

				switch (op) {
				case '+':
					z = x + y;
					System.out.println(x + " + " + y + " = " + z);
					System.out.println("");
					break;
				case '-':
					z = x - y;
					System.out.println(x + " - " + y + " = " + z);
					System.out.println("");
					break;
				case '/':
					z = x / y;
					System.out.println(x + " / " + y + " = " + z);
					System.out.println("");
					break;
				case '*':
					z = x * y;
					System.out.println(x + " * " + y + " = " + z);
					System.out.println("");
					break;
				default:
					System.out.println("Invalid operator!");
					System.out.println("");
					break;
				}

			} else {
				System.out.println("See you...");
			}

		} while (op != 'E');

	}

}
