package fileHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadText {

	public static void main(String[] args) {

		File file = new File("Testing.txt");
		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while (sc.hasNextLine()) {
			System.out.println(sc.nextLine());
		}
	}

//		File file = new File("Testing.txt");
//		Scanner sc = null;
//		String str = "3";
//		boolean flag = false;
//		try {
//			sc = new Scanner(file);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		while (sc.hasNextLine()) {
//			if (sc.nextLine().contains(str)) {
//				flag = true;
//			}
//		}
//		System.out.println(flag);

//	}

}
