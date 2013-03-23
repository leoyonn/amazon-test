package p2;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class Solution {
	private static int N = 0, K = 0;
    private static TreeMap<Integer, Integer> boxes = new TreeMap<Integer, Integer>();
    private static TreeSet<String> doneSet = new TreeSet<String>();
    private static void inc(int k) {
		Integer v = boxes.get(k);
		if (v == null || v == 0) {
			boxes.put(k, 1);
		} else {
			boxes.put(k, v + 1);
		}
    }

    private static void dec(int k) {
		Integer v = boxes.get(k); // v should not be less than 1
		if (v == 1) {
			boxes.remove(k);
		} else {
			boxes.put(k, v - 1);
		}
    }

    private static void putItemTo(int k) {
    	dec(k);
    	inc(k + 1);
	}

	private static void takeAwayItemFrom(int k) {
		dec(k + 1);
		inc(k);
	}

	private static void print() {
		StringBuilder sb = new StringBuilder();
    	for (Map.Entry<Integer, Integer> e: boxes.entrySet()) {
    		for (int j = 0; j < e.getValue(); j ++) {
    			sb.append(e.getKey()).append(" ");
    		}
    	}
	    System.out.println(sb.deleteCharAt(sb.length() - 1).toString());
	}

	private static void pack(int idx) {
		String done = boxes.toString();
		if (doneSet.contains(done)) {
			return;
		}
		doneSet.add(done);
		if (idx == N) {
			print();
			return;
		}
		int[] keys = new int[boxes.size()];
		int i = 0;
    	for (Map.Entry<Integer, Integer> e: boxes.entrySet()) {
    		keys[i++] = e.getKey();
    	}
    	for (i = 0; i < keys.length; i ++) {
    		putItemTo(keys[i]);
    		pack(idx + 1);
    		takeAwayItemFrom(keys[i]);
	    }
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    String[] line = sc.nextLine().split(" ");
	    N = Integer.parseInt(line[0]);
	    K = Integer.parseInt(line[1]);
	    if (N < 1 || K < 1) {
	    	System.out.println("error");
	    	return;
	    }
	    // boxes: <n-item-num, n-case-count>
	    boxes.put(0, K);
	    pack(0);
	}
}
