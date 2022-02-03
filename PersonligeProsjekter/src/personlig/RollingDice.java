package personlig;

import java.util.Random;

public class RollingDice {

	public static void main(String[] args) {
		
		Random number = new Random();
		int a = number.nextInt(6) + 1;
		
		System.out.println("You rolled a: " + a);

	}

}
