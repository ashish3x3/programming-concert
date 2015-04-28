import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class AntCollision {
	static int i(String s) { return Integer.parseInt(s); }
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String S = in.readLine();
			if(S==null) return;
			String[] arr = S.split(" ");
			int L = i(arr[0]);
			int n = i(arr[1]);
			int[] X = new int[n];
			boolean[] D = new boolean[n];

			TreeSet<Integer> Ls = new TreeSet<Integer>();
			TreeSet<Integer> Rs = new TreeSet<Integer>();
			for(int i=0; i<n; i++) {
				arr = in.readLine().split(" ");
				X[i] = i(arr[0]);
				D[i] = arr[1].equals("L");
				if(D[i])
					Ls.add(X[i]);
				else Rs.add(X[i]);
			}

			int max = 0;
			for(int i=0; i<n; i++) {
				int score = D[i] ? X[i] : L-X[i];
				max = Math.max(score, max);
			}

			List<Integer> winners = new ArrayList<Integer>();
			for(int i=0; i<n; i++) {
				int score = D[i] ? X[i] : L-X[i];
				if(score == max) {
					TreeSet<Integer> R2 = new TreeSet<Integer>(Rs);
					TreeSet<Integer> L2 = new TreeSet<Integer>(Ls);
					int pos = X[i];
					boolean dir = D[i];
					while(true) {
						if(dir) 
							L2.remove(pos);
						else 
							R2.remove(pos);
						Integer next = dir ? R2.pollFirst() : L2.pollLast();
						//System.out.println(next);
						if(next == null || (dir&&next>pos) || (!dir&&next<pos)) {
							winners.add(pos);
							break;
						}
						else {
							pos = next;
							dir = !dir;
						}
					}
				}
			}
			if(winners.size()==1) 
				System.out.printf("The last ant will fall down in %d seconds - started at %d.\n", max, winners.get(0));
			else
				System.out.printf("The last ant will fall down in %d seconds - started at %d and %d.\n", max,
					Math.min(winners.get(0), winners.get(1)), Math.max(winners.get(0), winners.get(1)));
		}
	}
}
