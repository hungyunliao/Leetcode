import java.util.LinkedList;
import java.util.ListIterator;

public class SubListCheck {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(2);
		list.add(3);
		list.add(5);
		list.add(10);
		
		LinkedList<Integer> sub = new LinkedList<Integer>();
		sub.add(2);
		sub.add(3);
		sub.add(5);
		sub.add(10);
		
		System.out.print(isSubset(list, sub));
		
	}
	
	public static boolean isSubset(LinkedList<Integer> list, LinkedList<Integer> sub) {
		if (sub.size() == 0) {return true;}
		if (list.size() == 0) {return false;}
		
		ListIterator<Integer> iter1 = list.listIterator();
		ListIterator<Integer> iter2 = sub.listIterator();
		int subEle = iter2.next();
		
		while (iter1.hasNext()) {
			
			if (iter1.next() == subEle) {
				if (!iter2.hasNext()) { return true;}
				subEle = iter2.next();
			}
		}
		
		return false;
	}
	
}
