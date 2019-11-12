package DM3.As1;
class Solution{
	public static int[] quickSort(int[] arr){
        arr = sort(arr,0, arr.length - 1);
        return arr;
    }
    static int[] sort(int[] arr, int low, int high){
        if (low < high){
            int pivot_index = partition(arr,low, high);
            arr = sort(arr, low, pivot_index);
            arr = sort(arr, pivot_index+1, high);
        }
        return arr;
    }

    static int partition(int[] arr, int low, int high){
        int pivot = arr[low], l=low, h=high;
        while (l < h){
            do{
                ++l;
            }while(l < high && arr[l] < pivot);
            do{
                if (arr[h] < pivot){
                    break;
                }
                --h;
            }while(h > low && arr[h] > pivot);
            if (l < h) {
                //swap
                int temp = arr[l];
                arr[l] = arr[h];
                arr[h] = temp;
            }
        }
        arr[low] = arr[h];
        arr[h] = pivot;
        return h;
    }
}


	