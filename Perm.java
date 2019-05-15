import java.util.*;

public class Perm {

	public static void main(String[] args) {
		
		String input = "ABC";
		int r = input.length()-1;
		
		Permute(input,0,r);
		

	}

	private static void Permute(String input, int l, int r) {
	
		if(l==r)
			System.out.println(input);
		else
		{
			for(int i=l;i<=r;i++)
			{
				input = swap(input,l,i);
				Permute(input,l+1,r);
				input = swap(input,l,i);
				
			}
			
			
			
			
		}
		
	}

	private static String swap(String input, int l, int i) {
		
		char [] arr = input.toCharArray();
		char temp = arr[l];
		arr[l]=arr[i];
		arr[i]=temp;
		
		return String.valueOf(arr);
	}

}
