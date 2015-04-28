
public class NumberWordCount {
	
	static String unit[] = {"", "One", "Two", "Three", "Four", "Five",
        "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
        "Thirteen", "Fourteen", "Fifteen",  "Sixteen", "Seventeen", 
        "Eighteen", "Nineteen"};

static String tens[] =  {"","Ten","Twenty", "Thirty", "Forty", "Fifty",
        "Sixty", "Seventy", "Eighty","Ninety"};
	
	
	public static void main(String [] args){
		
		int sum=0;
		String a;
		
		for(int i=0;i<=1000;++i){
			
		  a=wordGen(i);	
			
			sum+=a.length();
			
		}
		
		
		System.out.println(""+sum);
	}
	
	public static String wordGen(int num){
		
		String word="";
		
		int digits=count(num);
		
		while(digits>0){
			
			switch(digits){
			
			case 1:
			case 2:
				   if(num<20){
					   word+=unit[num];
					   digits=0;
					   
				   }
				   else
				   {
					   
					   word+=tens[num/10];
					   num=num%10;
					   if(num==0)
						   digits=0;
					   else
						   digits--;
				   
				   }
				   break;
			case 3:
				word+=unit[num/100];
				   num=num%100;
				   if(num%100 == 0)
				    {
				    word+="Hundred";
				     
				    digits = 0;
				    }
				   else
				   {
				    word+="HundredAnd";
				   digits--;
				   }
				    break;
				  case 4:
				    
				   word+=unit[num/1000];
				   num=num%1000;
				   word+="thousand";
				   if(num%1000 ==0)
				   digits = 0;
				   else
				   digits--;
				   break;
			
			
			
			
			
			}//switch
			
			
			
			
		}//while
		return word;
		
	}
	
	public static int count(int num){
		
		int count=0;
		
		while(num>0){
			
			num=num/10;
			count++;
			
			
		}
		return count;
		
		
	}
	

}
