package y.a;

public class MatrixChainMultiplier {
	
	
	public static void main(String[] argv) {
		
//		int[] p = new int[] {2,3,4,1,5};
		int[] p = new int[] {30,35,15,5,10,20,25};
		MatrixChainMultiplier mcm = new MatrixChainMultiplier(p);
		mcm.martixChainOrder();
		System.out.println(mcm.printOptimalOrder(0, 5));
		System.out.println(mcm.m[0][5]);
	}
	
	final int[] p;
	final int n;
	final int[][] m;
	final int[][] s;
	
	public MatrixChainMultiplier(final int[] p) {
		n = p.length - 1;
		this.p = p;
		m = new int[n][n];
		s = new int[n][n];
	}
	
	public void martixChainOrder() {
		
		for (int l = 2; l <= n; l++) {
			for (int i = 0; i < n - l + 1; i++) {
				int j = i + l - 1;
				m[i][j] = Integer.MAX_VALUE;
				for (int k = i; k < j; k++) {
					int q = m[i][k] + m[k+1][j] + (p[i] * p[k+1] * p[j+1]);
					if (q < m[i][j]) {
						m[i][j] = q;
						s[i][j] = k;
					}
				}
			}
		}
	}
	
	public String printOptimalOrder(final int i, final int j) {
		if (j > i) {
			String x = printOptimalOrder(i, s[i][j]);
			String y = printOptimalOrder(s[i][j] + 1, j);
			return "(" + x + "*" + y + ")"; 
		} else {
			return "A"+i;
		}
	}


}
