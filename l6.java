import java.util.*;

public class l6 {
	
	public static class lg6
	{
		LinkedList<Integer> adj[];
		int V;
		
		lg6(int V)
		{
			this.V=V;
			adj= new LinkedList[V];
			
			for(int i=0;i<V;i++)
				adj[i]=new LinkedList<Integer>();
		}
		
		
		
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int V = Integer.parseInt(scan.nextLine());
		int E = Integer.parseInt(scan.nextLine());
		
		lg6 g = new lg6(V+1);
		
		for(int i=0;i<E;i++)
		{
			String[] in = scan.nextLine().split("\\s+");
			int src = Integer.parseInt(in[0]);
			int des = Integer.parseInt(in[1]);
			Add(src,des,g);
		}
		
		Connectd(g);
		
		
		
	}

	private static void Connectd(lg6 g) {
	
		boolean visited[] = new boolean[g.V];
		visited[0]=true;
		int count=0;
		
		for(int i=0;i<g.V;i++)
		{
			if(!visited[i])
			{
				count++;
				dfs(visited,g,i);
			}
		}
		
		if(count==1)
			System.out.print("1 "+count); 
		else
			System.out.print("0 "+count);
	}

	private static void dfs(boolean[] visited, lg6 g, int i) {
		
		visited[i]=true;
		
		Iterator<Integer> itr = g.adj[i].listIterator();
		
		while(itr.hasNext())
		{
			int temp = itr.next();
			
			if(!visited[temp])
			{
				dfs(visited,g,temp);
			}
			
			
		}
		
		
	}

	private static void Add(int src, int des, lg6 g) {
		g.adj[src].add(des);
		g.adj[des].add(src);
	}

}
