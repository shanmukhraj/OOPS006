package DM3;

public class Merge {
	static int arr[]= {9,3,4,2,1,5,0,6,8,10};
	public static void main(String args[]) {
		mergesort(0,arr.length-1);
		for (int num:arr)
			System.out.println(num);
	}
	static void mergesort(int low,int high) {
		if (low<high) {
			int mid=(low+high)/2;
			mergesort(low,mid);
			mergesort(mid+1,high);
			merge(low,mid,high);
		}
	}
	static void merge(int low,int mid ,int high) {
		int l=low, m=mid+1, temparr[]=new int[high-low+1], s=0;
		while (l<=mid && m<=high) {
			if (arr[l]<arr[m]) { 
				temparr[s]=arr[l];
			s++;
			l++;
			}
			else if(arr[m]<arr[l]) {
				temparr[s]=arr[m];
			s++;
			m++;
			}
			else {
				temparr[s]=arr[l];
				s++;
				l++;
				temparr[s]=arr[m];
				s++;
				m++;
			}
		}
		for(;l<=mid;l++) {
			temparr[s]=arr[l];
			s++;
		}
		for(;m<=high;m++) {
			temparr[s]=arr[m];
			s++;
		}
		s=0;
		for(int i=low;i<=high;i++) {
			arr[i]=temparr[s];
			s++;
		}
			
		}
					
}
	
			


