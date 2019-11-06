package M1;



public class Threesum {
	public static void main(String[] args) {
		int n;
		int count=0;
		
		int[] arr=new int[] {-8,-7,-5,2};
		
		for(int i=0;i<arr.length-2;i++) 
		{
			for(int j=i+1;j<arr.length-1;j++) 
			{
				for(int k=j+1;k<arr.length;k++)
				{
					if(arr[i]+arr[j]+arr[k]==0) {
						count++;
					}
				}
			}
		}
		System.out.println(count);
	}
}

			
		