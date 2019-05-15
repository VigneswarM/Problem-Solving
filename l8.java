import java.util.*;

public class l8 {

	public static class lg8{
		
		int V;
		LinkedList<Integer>adj[];
		
		lg8(int V)
		{
			this.V=V;
			adj = new LinkedList[V];
	
			for(int i=0;i<V;i++)
				adj[i]= new LinkedList<Integer>();
		}
		
	}
	
	public static void main(String[] args) {
   
		Scanner scan = new Scanner(System.in);
		int V = Integer.parseInt(scan.nextLine());
		int E = Integer.parseInt(scan.nextLine());
		
		lg8 g = new lg8(V);
		lg8 r = new lg8(V);
		
		for(int i=0;i<E;i++)
		{
			String arr[] = scan.nextLine().split("\\s+");
			
			int src = Integer.parseInt(arr[0]);
			int des = Integer.parseInt(arr[1]);
			Add(src,des,g,r);
		}
		Connected(g,r);
	}

	private static void Connected(lg8 g, lg8 r) {
	
		boolean [] visited = new boolean[g.V];
		boolean [] visited1= new boolean[r.V];
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i=0;i<g.V;i++)
		{
		  if(!visited[i])
		  {
			  fill(visited,i,stack,g);
		  }
		}
		
		while(!stack.isEmpty())
		{
			int temp = stack.pop();
			
			if(!visited1[temp])
			{
				ArrayList<Integer>list = new ArrayList<Integer>();
				dfs(visited1,list,temp,r);
			    Collections.sort(list);	
				System.out.println(list);
				
				
			}
			
			
		}
		
		
	}

	private static void dfs(boolean[] visited1, ArrayList<Integer> list, int temp, lg8 r) {
		
		visited1[temp]=true;
		list.add(temp);
		
		Iterator<Integer> itr = r.adj[temp].listIterator();
		while(itr.hasNext())
		{
			int t = itr.next();
			
			if(!visited1[t])
			{
				dfs(visited1,list,t,r);
			}
     	}
	}

	private static void fill(boolean[] visited, int i, Stack<Integer> stack, lg8 g) {
	
		visited[i]=true;
		
		Iterator<Integer> itr = g.adj[i].listIterator();
		while(itr.hasNext())
		{
			int temp = itr.next();
			if(!visited[temp])
			{
				fill(visited,temp,stack,g);
			}
			
		}
		
		stack.push(i);
	}

	private static void Add(int src, int des, lg8 g, lg8 r) {
		
		g.adj[src].add(des);
		r.adj[des].add(src);
	}

}
