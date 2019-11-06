package DM2.As3;
class Solution{
	public int[] sortInsertion(int[] arr){
		if(arr!=null && arr.length>0) {
			for (int i = 0;i < arr.length; i++){
			    int temp = arr[i], index = i;
			    for (int j = i - 1; j > -1 ;j--) {
			        if (arr[j] > temp){
			            arr[index--] = arr[j];
			           
			        }
			        else{
			            break;
			        }
			    }
			    arr[index] = temp;
		}
		}
		return arr;
	}
	public int[] sortSelection(int[] arr){
		if(arr!=null && arr.length>0) {
			for(int k=0;k<arr.length;k++) {
				int min=arr[k],temp=arr[k],index=k;
				for(int m=k+1;m<arr.length;m++) {
					if (min>arr[m]) {
						min=arr[m];
						index=m;
						
					}
				}
				arr[k] = min;
				arr[index] = temp;
			}
		}
		
		return arr;
	}
}