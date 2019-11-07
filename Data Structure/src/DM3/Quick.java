package DM3;

public class Quick {
    static int arr[] = {99,54,23,56,67,98,100,26,20};
    public static void main(String args[]){
        
        quickSort(0, arr.length-1);
        for (int num:arr)
            System.out.println(num);
    }
    static void quickSort(int low, int high){
        if (low < high){
            int pivot_index = partition(low, high);
            quickSort(low, pivot_index);
            quickSort(pivot_index+1, high);
        }
    }
    static int partition(int low, int high){
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