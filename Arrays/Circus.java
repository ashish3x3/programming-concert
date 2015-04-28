import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Circus {
	
	class Dimension implements Comparable<Dimension> {
		int height;
		int weight;
		
		Dimension(int height, int weight) {
			this.height = height;
			this.weight = weight;
		}

		@Override
		public int compareTo(Dimension d) {
			return(this.height < d.height) ? 1 : this.height == d.height ? 0 : -1;
		}
	}
	
	private void getMaxPeople(Dimension [] dimension, int n) {
		int[] h = new int[n];
		Arrays.fill(h, 1);
		for(int i=0;i<n;i++) {
			for(int j=i;j<n;j++){
				if(dimension[j].weight < dimension[i].weight && h[j] < (h[i] + 1))  {
					h[j] = h[i] + 1;
				}
			}
		}
		for(int i=0;i<n;i++) {
			System.out.print(h[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number of inputs");
		int n = Integer.parseInt(br.readLine());
		Dimension [] dimension = new Dimension[n];
		System.out.println("Enter the coordinates");
		Circus circus = new Circus();
		for(int i=0;i<n;i++) {
			dimension[i] = circus.new Dimension(Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()));
		}
		Arrays.sort(dimension);
		circus.getMaxPeople(dimension, n);
	}
}