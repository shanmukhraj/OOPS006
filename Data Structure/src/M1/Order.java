package M1;

import java.util.Arrays;

public class Order {
	public static void main(String[]args) {
	int[] array1 = {1,2,3,4,};
	int[] array2= {2,3,4,5};
	Arrays.sort(array1);
	Arrays.sort(array2);
	{

		for(int i=0;i<array1.length;i++) {
			for(int j=0;j<array2.length;j++) {
				if(array1[i]==array2[j]) {
					System.out.println(array2[j]);
				}
			}
			
		}
		
	}

}
}
