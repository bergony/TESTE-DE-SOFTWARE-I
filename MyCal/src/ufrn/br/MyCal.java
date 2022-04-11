package ufrn.br;

import java.util.Scanner;

public class MyCal {

	public static void main(String[] args) {

		Operador op = new Operador();

		Scanner myObj = new Scanner(System.in); // Create a Scanner object
		System.out.println("Operacao");

		System.out.println("1 - sum");
		System.out.println("2 - sub");
		System.out.println("3 - div");
		System.out.println("4 - mul");
		System.out.println("5 - inv");
		System.out.println("6 - power");
		System.out.println("7 - sqd");

		int operacao = myObj.nextInt();
		switch (operacao) {
		case 1: {
			System.out.println("sum");
			System.out.println("dois numeros");
			int num1 = myObj.nextInt();
			int num2 = myObj.nextInt();
			System.out.println(op.soma(num1, num2));
			break;
		}
		case 2: {
			System.out.println("sub");
			System.out.println("dois numeros");
			int num1 = myObj.nextInt();
			int num2 = myObj.nextInt();
			System.out.println(op.sub(num1, num2));
			break;
		}
		case 3: {
			System.out.println("div");
			System.out.println("dois numeros");
			int num1 = myObj.nextInt();
			int num2 = myObj.nextInt();
			System.out.println(op.div(num1, num2));
			break;
		}
		case 4: {
			System.out.println("mul");
			System.out.println("dois numeros");
			int num1 = myObj.nextInt();
			int num2 = myObj.nextInt();
			System.out.println(op.mul(num1, num2));
			break;
		}
		case 5: {
			System.out.println("inv");
			System.out.println("um numeros");
			int num1 = myObj.nextInt();
			System.out.println(op.inv(num1));
			break;
		}
		case 6: {
			System.out.println("power");
			System.out.println("um numeros");
			int num1 = myObj.nextInt();
			int num2 = myObj.nextInt();
			System.out.println(op.power(num1, num2));
			break;
		}
		case 7: {
			System.out.println("sqd");
			System.out.println("um numeros");
			int num1 = myObj.nextInt();
			System.out.println(op.sqd(num1));
			break;
		}

		}

	}

}
