package DM2;

public class Selection {
	public static void main(String args[]) {
		int arr[] = {1,2,3,4,5,6,1,2,3,4,5};
		for (int i = 0; i < arr.length ; i++){
			int min = arr[i], temp = arr[i], index = i;
			for (int j = i+1; j < arr.length; j++){
				if (min > arr[j]){
	            min = arr[j];
	            index = j;
				}
			}
			arr[i] = min;
			arr[index] = temp;
		}
		for(int num:arr) {
			System.out.println(num);
		}
	}

}
