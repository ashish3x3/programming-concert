
public class LIS {

	public static void main(String[] args) {
		int [] ar={ 10, 22, 9, 33, 21, 50, 41, 60 };
		LISS(ar);
		

	}
	
	public static void LISS(int [] ar){
		
		int LS[]=new int[ar.length];
		
		for(int i=0;i<ar.length;++i){
			
			LS[i]=1;
		}
		
		
		for(int i=1;i<ar.length;++i){
			
			for(int j=0;j<i;++j){
				
				if(ar[i]>ar[j] && LS[i]<LS[j]+1)
					LS[i]=LS[j]+1;
			}
		}
		
		int max=0;
		
		for(int i=0;i<ar.length;++i){
			
			max=max>LS[i]?max:LS[i];
		}
		
		System.out.println("max LIS ="+max);
		
		
		
	}

}
