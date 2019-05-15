import java.util.*;

public class BinarySearch {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		String [] in = scan.nextLine().split("\\s+");
		
		int l = in.length-1;
		int X = Integer.parseInt(scan.nextLine());
		
		int index = BS(in,0,l,X);
		
		if(index!=-1)
			System.out.println("Present at: "+index);
		else
			System.out.println("Not Present");
	}

	private static int BS(String[] in, int f, int l, int x) {
		
		if(l>=f)
		{
			int mid = f+ (l-f)/2;
			
			if(Integer.parseInt(in[mid])==x)
			 return mid;
			
			else if(Integer.parseInt(in[mid])>x)
				return BS(in,0,mid-1,x);
			else if(Integer.parseInt(in[mid])<x)
				return BS(in,mid+1,l,x);
			
		}
		
		return -1;
	}

}
