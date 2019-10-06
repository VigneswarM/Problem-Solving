package workings;

import java.util.*;

public class my_grph {

	public static class mygrphs{
		
		int V;
		LinkedList<Integer>adj [];
		ArrayList<Integer> mylist = new ArrayList<Integer>();
		
		mygrphs(int V)
		{
			this.V = V;
			adj = new LinkedList[V];
			for(int i=0;i<V;i++)
			{
				adj[i]= new LinkedList<Integer>();
			}
		}
	}
	
	
	static void add_Edge(int src, int des, mygrphs g)
	{
		g.adj[src].add(des);
		g.adj[des].add(src);
	}
	
	
	private static void myBFS(int i, mygrphs g) {
		
		boolean visited[]= new boolean[g.V];
		visited[i]=true;
		
		LinkedList<Integer>queue = new LinkedList<Integer>();
		queue.add(i);
		int current =0;
		
		while(!queue.isEmpty())
		{
		  current = queue.poll();
		  System.out.print(" "+current+" -> ");
		  Iterator<Integer> itr = g.adj[current].listIterator();
		  while(itr.hasNext())
		  {
			  int e = itr.next();
			  if(!visited[e])
			  {
				  queue.add(e);
				  visited[e]=true;
			  }
		  }
		}
	}
	
	
	
	public static void main(String ...strings)
	{
    
	Scanner scan = new Scanner(System.in);
	String line = null;
	int V = Integer.parseInt(scan.nextLine());
	
	mygrphs g = new mygrphs(V);
	
	int N = Integer.parseInt(scan.nextLine());
	
	
	for(int i =0;i<N;i++)
	{
		line = scan.nextLine();
		String [] input = line.split("\\s+");
		
		int src = Integer.parseInt(input[0]);
		int des = Integer.parseInt(input[1]);
		add_Edge(src,des,g);
	}
		
	
	//myBFS(2,g);
	DFS(g);
		
		
	}


	private static void DFS(mygrphs g) {
	
	boolean visited[] = new boolean[g.V];	
		
	/* for(int i=0;i<g.V;i++)
	 {
		if(!visited[i]) 
		DFS_util(i,g,visited); 
		 
	 }*/
	 
	 DFS_util(2,g,visited); 
		
	}


	private static void DFS_util(int i, mygrphs g, boolean[] visited) {
		
		visited[i]= true;
		System.out.print(" "+i+" ->");
		g.mylist.add(i);
		
		Iterator itr = g.adj[i].listIterator();
		
		while(itr.hasNext())
		{
			
			int n =  (int) itr.next();
			
			if(!visited[n])
			{
				DFS_util(n,g,visited);
			}
			
			
		}
		
		
		
		
		
	}
	
}

	
	/*

BFS 
4
6
0 1
0 2
1 2
2 0
2 3
3 3


 DFS
 
4
6
0 1
0 2
1 2
2 0
2 3
3 3



	*/

