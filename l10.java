import java.util.*;

public class l10 {

	public static String out=null;
	
	public static class lg10{
		
		int V;
		LinkedList<Integer>adj[];
		
		lg10(int V)
		{
			this.V=V;
			adj= new LinkedList[V];
			
			for(int i=0;i<V;i++)
				adj[i]= new LinkedList<Integer>();
		}
		
	}
	
	public static void main(String[] args) {
    
		Scanner scan = new Scanner(System.in);
		int V= Integer.parseInt(scan.nextLine());
		int E= Integer.parseInt(scan.nextLine());
		
		lg10 g = new lg10(V);
	
		for(int i=0;i<E;i++)
		{
			String [] arr = scan.nextLine().split("\\s+");
			int src = Integer.parseInt(arr[0]);
			int des = Integer.parseInt(arr[1]);
			add(src,des,g);
		}
		
		int N = Integer.parseInt(scan.nextLine());
		String arr[] = new String[N];
		
		for(int i=0;i<N;i++)
		{
			arr[i]=scan.nextLine();
		}
		
		for(int i=0;i<N;i++)
		{
			
			String in[] = arr[i].split("\\s+");
			int src = Integer.parseInt(in[0]);
			int des = Integer.parseInt(in[1]);
			out="NO";
			Find(src,des,g);
			
			if(i==N-1)
				System.out.print(out);
			else
				System.out.print(out+" ");
		}
		
		
		
		
		
	}

	private static void Find(int src, int des, lg10 g) {
		
		
		boolean [] visited = new boolean[g.V];
		
		for(int i=0;i<g.V;i++)
		{
			
			if(!visited[src])
			{
				dfs(visited,src,des,g);
			}
			
		}
		
		
	}

	private static void dfs(boolean[] visited, int src, int des, lg10 g) {
		
		visited[src]=true;
		
		if(src==des)
			out="YES";
		else 
		{
			Iterator<Integer> itr = g.adj[src].listIterator();
			while(itr.hasNext())
			{
				
				int t = itr.next();
				if(!visited[t])
				{
					dfs(visited,t,des,g);
				}
				
			}
			
			
			
		}
		
		
	}

	private static void add(int src, int des, lg10 g) {
		
		g.adj[src].add(des);
		
	}

}
