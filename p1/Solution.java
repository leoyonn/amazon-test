package p1;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		// get input and process bad case
		Scanner sc = new Scanner(System.in);
	    String line = sc.nextLine();
	    if (line == null || line.length() < 3) {
	    	System.out.println("{0}");
	    	return;
	    }
	    // parse into array, count full-sum and zeros
	    String[] vals = line.substring(1, line.length() - 1).split(",");
	    int N = vals.length;
	    int []ori = new int[N];
	    int zeroNum = 0;
	    long full = 1;
	    for (int i = 0; i < N; i ++) {
	    	int v = Integer.valueOf(vals[i]);;
	    	ori[i] = v;
	    	if (v == 0) {
	    		zeroNum ++;
	    	} else {
		    	full *= ori[i];
	    	}
	    }
	    // print, if more than 1 zeros:
	    System.out.print("{");
	    if (zeroNum > 1) {
		    for (int i = 0; i < N - 1; i ++) {
			    System.out.print("0,");
		    }
		    System.out.print("0}");
		    return;
	    }
	    // if 1 zero:
	    if (zeroNum == 1) {
		    for (int i = 0; i < N - 1; i ++) {
			    System.out.print((ori[i] == 0 ? full : "0") + ",");
		    }
		    System.out.print((ori[N - 1] == 0 ? full : "0") + "}");
		    return;
	    }
	    for (int i = 0; i < N - 1; i ++) {
		    System.out.print((full / ori[i]) + ",");
	    }
	    System.out.print((full / ori[N - 1]) + "}");
	}	
}
