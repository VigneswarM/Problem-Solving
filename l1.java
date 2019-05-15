import java.util.*;


public class l1 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		char arr[] = scan.nextLine().toCharArray();
		
		int check=0,sum=0,counter=0;
		
		for(int i=arr.length-1;i>=0;i--)
		{
			int num = Integer.parseInt(Character.toString(arr[i]));
			
			if(i==arr.length-1)
				check=num;
			
			if(counter%2==0)
			{
				sum = sum+num;
			}
			else
			{
				num=num*2;
				int rem=0;
				
				if(num>=10)
				{
					rem=num%10;
					num=num/10;
				}
				
				sum=sum+num+rem;
			}
			
			counter++;
		}
	
	int rem = sum%10;
	
	if(rem==0)
	System.out.print("VALID");
	else if(check>=rem)
		System.out.print("INVALID "+(check-rem));
	else if(check<rem)
		System.out.print("INVALID " +(check-rem+10));
	}

}
