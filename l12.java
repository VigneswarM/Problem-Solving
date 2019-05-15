import java.util.*;
import java.util.Map.Entry;

public class l12 {

	public static HashMap<String, Integer> map = new HashMap<String, Integer>();
	public static int T = 0;
	public static HashMap<String, Integer> Cmap = new HashMap<String, Integer>();
	public static List<String> list = new ArrayList<String>();
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		List<String> Olist = new ArrayList<String>();
		
		T = Integer.parseInt(scan.nextLine());
		int N = Integer.parseInt(scan.nextLine());
		String[] in = scan.nextLine().split("\\s+");

		for (int i = 0; i < N; i++)
			addMap(in[i]);

	//	System.out.println(Cmap);
		String[] out = new String[in.length];
		Process(in, out, 0, -1);
	//	System.out.println(map);
		String key="";
		/*
		for(Entry<String,Integer> m : map.entrySet() )
		{
			String [] fin = m.getKey().split(",");
			
			for(int i=0;i<fin.length;i++)
				list.add(fin[i]);
			
			Collections.sort(list);
			
			Iterator<String> itr= list.iterator();
			
			while(itr.hasNext())
			{
				String t = itr.next();
				
				if (key == "") 
					key = t;
				 else 
					key = key + t;
				
			}
			
			//System.out.println(key);	
			
			
			if(!Olist.contains(key))
			   Olist.add(key);
		}
		
		System.out.println(Olist.size());*/
		System.out.println(map.size());
		
	}

	private static void addMap(String num) {

		if (Cmap.containsKey(num))
			Cmap.put(num, Cmap.get(num) + 1);
		else
			Cmap.put(num, 1);

	}

	private static void Process(String[] in, String[] out, int ab, int be) {

		for (int i = ab; i < in.length; i++) {
			out[be + 1] = in[i];
			save(out, be + 1);

			if (i < in.length)
				Process(in, out, ab + 1, be + 1);
		}

	}

	private static void save(String[] out, int n) {

		String num = "";
		int sum = 0;

		HashMap<String, Integer> Tmap = Cmap;
		// System.out.println(Tmap);

		for (int i = 0; i <= n; i++) {

			if (num == "") {
				num = out[i];
				sum = Integer.parseInt(num);

			} else {
				num = num + "," + out[i];
				sum = sum + Integer.parseInt(out[i]);

			}

			
			
			
			if (sum == T) {
				
				if (Tmap.get(out[i]) > 0) {
					Tmap.put(out[i], Tmap.get(out[i]) - 1);
				
				/*	System.out.println(num+" "+sum);
					System.out.println(Tmap);
					
					String [] fin = num.split(",");
					for(int in=0;in<fin.length;in++)
						list.add(fin[in]);
						
					Collections.sort(list);
				    String key = list.toString();*/
					
					if (map.containsKey(num))
						;
					else {
						
						map.put(num, sum);
						
						}	
				}	
					
				} else if (sum > T)
					break;
			
		}

	}
}
