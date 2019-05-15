import java.util.*;

public class l3 {

	public static ArrayList<String> list = new ArrayList<String>();
	public static ArrayList<String> Olist = new ArrayList<String>();

	public static class lt3 {
		String val;
		lt3 left, right;

		lt3(String val) {
			this.val = val;
			left = null;
			right = null;
		}

	}

	public static void main(String[] args) throws Exception{

		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine().trim();
		String tar = scan.nextLine();
		int dis = Integer.parseInt(scan.nextLine());

		lt3 root = null;
		line = line.substring(1, line.length() - 1);

		root = Build(line);

		int h = height(root);

		for (int i = 1; i <= h; i++)
			level(root, i);

		
		if (list.contains(tar)) {
			PrintDist(root, tar, dis);
			Collections.reverse(Olist);
			//System.out.println(Olist);
			Olist.forEach(x-> System.out.print(x+" "));
		}

	}

	private static int PrintDist(lt3 root, String tar, int dis) {

		if (root == null)
			return -1;

		if (root.val.equals(tar)) {
			Print(root, dis);
			//System.out.println("fooind");
			return 0;
		}

		int dl = PrintDist(root.left, tar, dis);
		
		if (dl != -1) {
			if (dl + 1 == dis)
			{  // System.out.print(root.val+" ");
				Olist.add(root.val);
			}
				else
				Print(root.right, dis - dl - 2);

			return 1 + dl;
		}

		int dr = PrintDist(root.right, tar, dis);
		
		if (dr != -1) {
			
			if (dr + 1 == dis) {
				Olist.add(root.val);
				//System.out.print(root.val+" ");
				}
			else
				Print(root.left, dis - dr - 2);
			return 1 + dr;
		}

		return -1;
	}

	private static void Print(lt3 root, int k) {

		if (root == null || k < 0)
			return;

		if (k == 0) {
			Olist.add(root.val);
			//System.out.print(root.val+" ");
			return;
		}

		Print(root.left, k - 1);
		Print(root.right, k - 1);
	}

	private static void level(lt3 root, int level) {

		if (root == null)
			return;

		if (level == 1)
			System.out.print(root.val +" ");
		else if (level > 1) {
			level(root.left, level - 1);
			level(root.right, level - 1);
		}

	}

	private static int height(lt3 root) {
		if (root == null)
			return 0;

		return 1 + Math.max(height(root.left), height(root.right));
	}

	private static lt3 Build(String line) {

		if (line == null)
			return null;

		String val = null;
		int p = line.indexOf('(');

		if (p == -1)
			val = line;
		else
			val = line.substring(0, p);

		list.add(val);
		lt3 root = new lt3(val);

		if (p == -1)
			return root;

		int start = p, lf = 0;

		for (int i = start; i < line.length(); i++) {

			if (line.charAt(i) == '(')
				lf++;
			else if (line.charAt(i) == ')')
				lf--;

			if (start == p && lf == 0) {
				root.left = Build(line.substring(start + 1, i));
				start = i + 1;
			} else if (lf == 0) {
				root.right = Build(line.substring(start + 1, i));
			}

		}

		return root;
	}

}
