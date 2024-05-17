package demo.pack;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FiboClass {

	public static void main(String[] args) throws IOException {

//		int first = 0;
//		int second = 1;
//
//		System.out.println(first);
//		System.out.println(second);
//		
//		for(int i=0;i<8;i++) {
//			
//			int temp = first + second;
//			first = second;
//			second = temp;
//			
//			System.out.println(temp);
//			
//		}

		int[] numArr = { 7, 3, 2, 8, 4, 5, 1, 2, 10 };

		int max = numArr[0];
		int max2 = numArr[1];

		for (int i = 0; i < numArr.length; i++) {
			if (max < numArr[i]) {

				max = numArr[i];
				if (max2 < numArr[i])
					max2 = numArr[i];
			}
		}

		System.out.println(max);
		System.out.println(max2);

//		File file = new File("pom.xml");
		File file = new File("LoanCalculator.java");

		System.out.println("Exist: " + file.exists());

		System.out.println("getAbsolutePath: " + file.getAbsolutePath());

		byte[] bytes = new byte[(int) file.length()];

		FileInputStream fis = new FileInputStream(file);

		fis.read(bytes);
		
		fis.close();
		
		String byteString = java.util.Base64.getEncoder().encodeToString(bytes);
		
		System.out.println("bytes: "+byteString.length()+"\n");
		System.out.println("byteString: \n"+byteString);

	}

}
