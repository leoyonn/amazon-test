package rotate;
import java.util.Scanner;

public class Solution {
	private static int N = 0;
	private static class P {
		int x;
		int y;
		public P(int x, int y) {
			this.x = x;
			this.y = y;
		}
		private P swap() {
			x ^= y; // 01 11 -> 10 11
			y ^= x; // 10 11 -> 10 01
			x ^= y; // 10 01 -> 11 01
			return this;
		}
		@Override
		public String toString() {
			return "(" + x + "," + y + ")";
		}
	}
	
	private static P next(int level, P p) {
		int l = level, r = N - level - 1;
		if (p.x < r && p.y == l) {
			p.x ++;
		} else if (p.x == r && p.y < r) {
			p.y ++;
		} else if (p.y == r && p.x > l) {
			p.x --;
		} else if (p.x == l && p.y > l) {
			p.y --;
		}
		return p;
	}

	private static P prev(int level, P p) {
		next(level, p.swap());
		return p.swap();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    String line = sc.nextLine();
	    N = Integer.parseInt(line);
	    int [][]ori = new int[N][];
	    for (int i = 0; i < N; i ++) {
		    String[] row = sc.nextLine().split(" ");
	    	ori[i] = new int[N];
		    for (int j = 0; j < N; j ++) {
		    	ori[i][j] = Integer.parseInt(row[j]);
		    }
	    }
	    rotate(ori);
	    
	    for (int i = 0; i < N; i ++) {
		    for (int j = 0; j < N; j ++) {
		    	System.out.print(ori[i][j] + (j == N - 1 ? "" : " "));
		    }
		    System.out.println();
	    }
	}

	public static void rotate(int[][]a) {
		for (int level = 0; level < N / 2; level ++) {
			boolean anti = (level & 1) == 1;
			P p = new P(level, level);
			int v = a[p.y][p.x];
			for (int i = 0; i < (N - 2 * level - 1) * 4 - 1; i ++) {
				int x = p.x, y = p.y;
				p = anti ? next(level, p) : prev(level, p);
				a[y][x] = a[p.y][p.x];
			}
			a[p.y][p.x] = v;
		}
	}

	
}
