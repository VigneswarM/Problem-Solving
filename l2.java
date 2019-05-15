import java.util.*;
import java.util.Map.Entry;


public class l2 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		int N = Integer.parseInt(scan.nextLine());
		
		String arr[] = new String[N];
		
		for(int i=0;i<N;i++)
			arr[i]=scan.nextLine();
		
		int V= Integer.parseInt(scan.nextLine());
		String gram=null;
		
		if(V==1)
			gram="Unigram";
		if(V==2)
			gram="Bigram";
		if(V==3)
			gram="Trigram";
		
		process(gram,V,arr);
		
	}

	private static void process(String gram, int v, String[] arr) {
		
		TreeMap<String,Integer> map = new TreeMap<String,Integer>();
		
		for(int i=0;i<arr.length;i++)
		{
			
			String [] input = arr[i].split("\\s+");
			
			for(int k=0;k<input.length;k++)
			{
				String item = input[k];
				int lim = v;
				
				for(int j=0;lim<=item.length();j++)
				{
					String key = item.substring(j, lim);
					lim++;
					
					if(!(key.contains(",")||key.contains(".")||key.contains(" ")||key.contains("\n")))
					{
						
						if(map.containsKey(key))
						 map.put(key,map.get(key)+1);
						else
							map.put(key,1);
					}
					
				}
			}
		}
		
		int max = Collections.max(map.values());
		String key=null;
		for(Entry<String, Integer> itr: map.entrySet())
		{
			key=itr.getKey();
			if(itr.getValue()==max)
			  break;
		}
		System.out.print(gram+" "+key);
	}
}
