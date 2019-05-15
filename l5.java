import java.util.*;

public class l5 {

	public static void main(String[] args) {
     
	Scanner scan = new Scanner(System.in);
    
	String str = scan.nextLine().trim();
	String ltr = scan.nextLine().trim();
	
	TreeMap<Character,Integer> str_map = new TreeMap<Character,Integer>();
	TreeMap<Character,Integer> ltr_map = new TreeMap<Character,Integer>();
	
	int min = str.length()+1;
	String output=null;
	int index=0,sum=0;
	
	for(int i=0;i<ltr.length();i++)
	{
		char key = ltr.charAt(i);
		
		if(ltr_map.containsKey(key))
			ltr_map.put(key, ltr_map.get(key)+1);
		else
			ltr_map.put(key, 1);
	}
	 
	
	for(int i=0;i<str.length();i++)
	{
		char key = str.charAt(i);
		
		if(ltr_map.containsKey(key))
		{
			
			if(str_map.containsKey(key))
			{
				if(ltr_map.get(key)>str_map.get(key))
					sum++;
				
				str_map.put(key,str_map.get(key)+1);
			}
			else
			{
				str_map.put(key, 1);
				sum++;
			}
		}
		
		if(sum==ltr.length())
		{
			
			char val = str.charAt(index);
			
			while(!str_map.containsKey(val)||str_map.get(val)>ltr_map.get(val))
			{
				if(str_map.containsKey(val) && str_map.get(val)>ltr_map.get(val))
				   str_map.put(val, str_map.get(val)-1);
		
				index++;
				val = str.charAt(index);
			}
			
			if(i-index+1<min)
			{
				output = str.substring(index,i+1);
				min = i-index+1;
			}
			
			
		}
	}
	
	
	System.out.print(output);
	
	
		
     
	}

}
