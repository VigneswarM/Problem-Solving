import java.util.*;


public class Tree {

	public static int index=0;
	
	public static class T{
		
		int val;
		T left,right;
		
		T(int val)
		{
			this.val=val;
			left=null;
			right=null;
		}
		
		
	}
	
	
	public static void main(String[] args) {
	
	Scanner scan = new Scanner(System.in);
	
	String [] arr = scan.nextLine().split("\\s+");
	
	int [] inp = new int[arr.length];
	
	for(int i=0;i<arr.length;i++)
		inp[i]= Integer.parseInt(arr[i]);
	
	T root = null;
	//root = PostOr(inp);	
    
	root = PreOrd(inp);
	
	Inor(root);

	
	

	}


	private static T PreOrd(int[] inp) {
		
		index=0;
		
		return Pre(inp,inp[index],Integer.MIN_VALUE,Integer.MAX_VALUE,inp.length);
	}


	private static T Pre(int[] inp, int key, int minValue, int maxValue, int length) {
		
		if(index>=length)
		return null;
		
		T root =null;
		
		if(key<maxValue && minValue<key)
		{
			
			root = new T(key);
			index++;
			
			if(index<length)
			{
				root.left= Pre(inp,inp[index],minValue,key,length);
				root.right= Pre(inp,inp[index],key,maxValue,length);
			}
			
			
		}
		
		
		return root;
	}


	private static void Inor(T root) {

		if(root==null)
		return;
		
		Inor(root.left);
		System.out.print(root.val+" ");
		
		Inor(root.right);
		
	}


	private static T PostOr(int[] inp) {
		
		index=inp.length-1;
		
		return PostF(inp,inp[index],index,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}


	private static T PostF(int[] inp, int key, int index2, int minValue , int maxValue) {
		
		T root = null;
		
		if(index<0)
		return null;
			
			if(key<maxValue && minValue <key)
			{
			 root = new T(key);
			 index--;
			 
			 if(index>0)
			 {
				 root.right=PostF(inp,inp[index],index,key,maxValue);
				 root.left=PostF(inp,inp[index],index,minValue,key);
			 }
				
			}
		return root;
	}



}


/*

Post
1 7 5 50 40 10

Pre
10 5 1 7 40 50


*/