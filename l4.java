import java.util.*;

public class l4 {

	public static class t4{
		
		int val;
		t4 left,right;
		
		t4(int val)
		{
			this.val=val;
			left=null;right=null;
		}
		
		
	}
	
	public static int s=0,e=0;
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String arr[] = scan.nextLine().split("\\s+");
		
		t4 root=null;
		for(int i=0;i<arr.length-1;i++)
			 root = BST(root,arr[i]);	
	    
		e=arr.length-1;
		
		if(check(root))
		    pre(root) ;
		else
			System.out.print("NOT");
	
		
		
	}


	private static void pre(t4 root) {
		
		if(root==null)
			return;
		
		s++;
		
		if(s==e)
			System.out.print(root.val);
		else
			System.out.print(root.val+" ");
		
		pre(root.left);
		pre(root.right);
	}


	private static boolean check(t4 root) {
		
		if(root==null)
			return true;
		
		int l=height(root.left);
		int r=height(root.right);
		
		if(Math.abs(l-r)<=1 && check(root.left) && check(root.right))
			return true;
		
		return false;
	}


	private static int height(t4 root) {
		if(root==null)
		return 0;
		
		return Math.max(height(root.left), height(root.right))+1;
	}


	private static t4 BST(t4 root, String string) {
		
		int val = Integer.parseInt(string);
		
		if(root==null)
			root= new t4(val);
		else if(root.val>val)
			root.left= BST(root.left,string);
		else if(root.val<val)
			root.right=BST(root.right,string);
		
		return root;
	}

}
