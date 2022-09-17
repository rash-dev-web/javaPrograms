package misc;

public class CheckPrimeTest {

	public static void main(String[] args) {
		System.out.println(isPrime(1));
		System.out.println(isPrime(10));

	}

	private static boolean isPrime(int number) {
		boolean flag = true;
		if (number == 0 || number == 1)
			flag = false;
		else if (number == 2)
			flag = true;
		for (int i = 2; i <= number / 2; i++) {
			if (number % 2 == 0)
				flag = false;
		}
		return flag;
	}
	
}
