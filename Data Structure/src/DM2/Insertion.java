package DM2;

public class Insertion {
	public static void main(String args[]) {
		int arr[]= {13,10,11,9,8,15,17,18};
		for (int i = 1;i < arr.length; i++){
		    int temp = arr[i], index = i;
		    for (int j = i - 1; j > -1 ;j--) {
		        if (arr[j] > temp){
		            arr[index] = arr[j];
		            index--;
		        }
		        else{
		            break;
		        }
		    }
		    arr[index] = temp;
		}
		for(int num:arr) {
			System.out.println(num);
		}
	}
}
