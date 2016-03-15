
public class Numberof1Bits {
	public static void main(String[] args) {
		hammingWeight(2147483647);
		
	}
	
	public static int hammingWeight(int n) {
        int num = 0;
        while(n / 2 > 0) {
            if (n % 2 == 1) {
                num++;
             }
            n = n / 2;
            System.out.println(n);
        }
        if (n == 1) { num++; }
        return num;
    }
}
