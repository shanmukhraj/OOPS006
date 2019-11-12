package DM3.As2;
class Solution{
	String[] arr;
	public static String[] mergeSort(String[] arr){
		Solution sol = new Solution();
        sol.arr = arr;
        sol.sort(0, sol.arr.length - 1);
        return sol.arr;
    }
    void sort (int low, int high){
        if (low < high){
            int mid = (low+high)/2;
            sort(low, mid);
            sort(mid+1, high);
            merge(low, mid, high);
        }
    }

    void merge(int low, int mid, int high){
        int l = low, m = mid + 1, k = 0;
        String tempArr[] = new String[high-low+1];
        while (l <= mid && m <= high){
            if (arr[l].compareTo(arr[m]) < 0)
                tempArr[k++] = arr[l++];
            else if (arr[m].compareTo(arr[l]) < 0)
                tempArr[k++] = arr[m++];
            else{
                tempArr[k++] = arr[l++];
                tempArr[k++] = arr[m++];
            }
        }
        for (;l <= mid; l++)
            tempArr[k++] = arr[l];
        for(;m <= high; m++)
            tempArr[k++] = arr[m];
        k= 0;
        for(int index = low; index <= high; index++)
            arr[index] = tempArr[k++];
    }
}


		
	