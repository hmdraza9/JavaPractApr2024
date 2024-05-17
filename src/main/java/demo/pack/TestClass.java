package demo.pack;

import java.util.HashMap;
import java.util.Map;

public class TestClass {

	static String str = "birlasoft limited banglore india";// Exact - [9,7,8,5]

	static String strArr[] = str.split(" ");

	public static void main(String[] args) {

//		wordLenRegister();
//		capitalizeMidChar();
		hmOfObjects();
		System.out.println(hmOfObjects().get("One").equals(true));

	}

	public static Map<String, Object> hmOfObjects() {

		Map<String, Object> hm = new HashMap<String, Object>();
		hm.put("One", true);
		hm.put("Two", 2);
		hm.put("Three", "Three");
		String[] numArr = "1,2,3,4".split(",");
		hm.put("Four", numArr);

		System.out.println(hm);
		return hm;
	}

	public static void wordLenRegister() {

		int[] wordLenStat = new int[strArr.length];

		for (int i = 0; i < strArr.length; i++) {

			wordLenStat[i] = strArr[i].length();

		}

		System.out.println("Array stat: ");

		for (int j : wordLenStat) {

			System.out.print(j + ",\t");

		}
	}

	public static void capitalizeMidChar() {

		String capString = "";

		for (String strr : strArr) {

			String tempStr = "";

			if (strr.length() % 2 == 1) {// odd 5 driver.get(driver.GetUrl()); .sendKeys(Keys.F5)
				int mid = strr.length() / 2; // birlAsoft limIted banGLore inDia
				System.out.println("mid: " + mid);
				tempStr = strr.substring(0, mid) + strr.substring(mid, mid + 1).toUpperCase() + strr.substring(mid + 1);
				System.out.println("1. " + strr.substring(0, mid));
				System.out.println("2. " + strr.substring(mid, mid + 1).toUpperCase());
				System.out.println("3. " + strr.substring(mid + 1));
//				System.out.println("tempStr: "+tempStr);
				capString = capString + " " + tempStr;
			} else {// even 8
				int mid = (strr.length() / 2);
				System.out.println("mid: " + mid);
				tempStr = strr.substring(0, mid - 1) + strr.substring(mid - 1, mid + 1).toUpperCase()
						+ strr.substring(mid + 1);
				System.out.println("1. " + strr.substring(0, mid - 1));
				System.out.println("2. " + strr.substring(mid - 1, mid + 1).toUpperCase());
				System.out.println("3. " + strr.substring(mid + 1));
//				System.out.println("tempStr: "+tempStr);
				capString = capString + " " + tempStr;
			}
		}

		System.out.println("capString: " + capString);
	}

}
