import java.util.Arrays;

public class ContainsDuplicate {
	public static void main(String[] args){
		int[] nums = {6,3,4,5,1,5};
		if(containsDuplicate(nums)) {System.out.println("yes, the array has duplicate element(s).");}
		else System.out.println("no, the array has no duplicate elements");
	}
	
	public static boolean containsDuplicate(int[] nums) {
		int index = 0;
		for (int i=0; i< nums.length; i++) System.out.print(nums[i] + " ");
		System.out.println();
		Arrays.sort(nums);
		for (int i=0; i< nums.length; i++) System.out.print(nums[i] + " ");
		System.out.println();
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == nums[i+1]) { index++; }
		}
		if (index == 0) return false;
		else return true;
}
	}
