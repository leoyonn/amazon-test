package p3;
import java.util.Scanner;

public class Solution {

	static int getFinalAmount(int ori, String bets) {
		if (ori < 1) {
			return ori;
		}
		char[] arr = bets.toCharArray();
		int bet = 1;
		for (int i = 0; i < arr.length; i ++) {
			if (arr[i] == 'W') {
				ori += bet;
				bet = 1;
			} else {
				ori -= bet;
				bet <<= 1;
				if (ori < bet) {
					return ori;
				}
			}
		}
		return ori;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    String ori = sc.nextLine(), bets = sc.nextLine();
	    System.out.println(getFinalAmount(Integer.valueOf(ori), bets));
	}
}
