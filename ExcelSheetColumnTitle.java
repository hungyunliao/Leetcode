import java.util.ArrayList;

public class ExcelSheetColumnTitle {
	public static void main(String[] args) {
		int num = 1, j=0, finallength = 0;
		ArrayList<Integer> b = recursive(num);
		int[] x = new int[b.size()];
		for (int i = 0; i < b.size(); i++) {
			x[i] = b.get(i);
			System.out.print(b.get(i) + "-");
		}
		
		for (int i = 0; i < x.length-1; i++) {
			if (x[i] == 0 ){
				x[i] = 26;
				x[i+1] -= 1;
			}
		}
		char[] output = new char[x.length];
		for (int i = x.length-1; i >= 0; i--) {	
			output[j] = (char)(x[i]+64);
			j++;
		}
		System.out.println();
		for (int i = 0; i < output.length; i++) {
			System.out.print(output[i] + " ");
		}
		if (output[0] == '@') {
			finallength = 1;
		}
		else finallength = 0;
		
		char[] output2 = new char[output.length - finallength];
		
		j = 0;
		
		for (int i = finallength; i < output.length; i++) {
			output2[j] = output[i];
			j++;
		}
		
		String finaloutput = new String(output2);
		System.out.println();
		System.out.print(finaloutput);
	}
	
	private static ArrayList<Integer> recursive(int num) {
		int a;
		ArrayList<Integer> b = new ArrayList<Integer>();
		do {
		a = num/26;
		b.add(num%26);
		num = a;
		} while (num >= 26);
		b.add(a);
		return b;
	}
	
}
