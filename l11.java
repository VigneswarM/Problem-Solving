import java.util.*;

public class l11 {

	public static class lt11{
		
		int val;
		lt11 left,right;
		
		lt11(int val)
		{
			this.val=val;
			left=null;
			right=null;
		}
		
	}
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		int N = Integer.parseInt(scan.nextLine());
		String [] arr = scan.nextLine().split("\\s+");	
		
		lt11 root  = null; 
		
		for(int i=0;i<N;i++)
		root = B(root,Integer.parseInt(arr[i]));
			
			if(check(root,N))
				System.out.print("YES"); 
			else
				System.out.print("NO");
	}

	private static boolean check(lt11 root, int n) {
		
		if(root==null)
			return true;
		
		int l = lh(root);
		int r = rh(root);
		
		if(l==r && n== Math.pow(2, l)-1)
		return true;
		
		return false;
	}

	private static int lh(lt11 root) {
		if(root==null)
		return 0;
		
		return 1+ lh(root.left);
	}

	private static int rh(lt11 root) {
		if(root==null)
		return 0;
		
		return 1+ rh(root.right);
	}

	private static lt11 B(lt11 root, int val) {
		
		if(root==null)
			root = new lt11(val);
		else if(root.val>val)
			root.left= B(root.left,val);
		else if(root.val<val)
			root.right=B(root.right,val);
		
		return root;
	}

}
