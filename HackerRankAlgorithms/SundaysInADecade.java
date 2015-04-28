/*
 * How Many Sundays Fell on the 1st?

Given the following information, calculate how many Sundays fell on the first of the month during the twentieth century: 

        1 January 1900 was a Monday 
        A leap year occurs any year that is divisible by 4, but not on a century unless divisible by 400
        "Thirty days has September,
        April, June and November.
        All the rest have thirty-one,
        Saving February alone,
        Which has twenty-eight, rain or shine.
        And on leap years, twenty-nine."
        
        o/p:
        
        173
 */

import java.util.Date;
import java.util.GregorianCalendar;

public class SundaysInADecade {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		int num_of_days=0;
		int days_passed=1;
		int count=0;
		
		for(int i=1900;i<2001;++i){
			
			for(int j=1;j<=12;++j){
				
				if(j==4|| j==6 || j==9 || j==11)
					num_of_days=30;
				else if(j==2){
					
					if(i%400==0 ||(i%4==0 && i%100!=0))
						num_of_days=29;
					else
						num_of_days=28;
					
					
				}
				else
					num_of_days=31;
				
				if(days_passed%7==0)
					count++;
				days_passed+=num_of_days;  
				/*it will add 31/30 to day 1 sunday and then check whether it is 
				 * divisible by 7 if it is then it lie on first day of month
				 * 1%7 then 1+31%7 then 1+31+30%7 ...
				 */
				
			}
			
			
			
		}
		
		System.out.println(""+count);
		
		
		/* -----------------------------------------------------------------------*/
		
		int counter = 0;
        for (int year = 1900, last_year = 2000; year <= last_year ; year++) {
            for (int month = 1, last_month = 12; month <= last_month ; month++) {
                Date d = new GregorianCalendar(year,month-1,1).getTime(); 
                // GregorianCalendar use 0 for January
                if (d.getDay() == 0) { // sunday is day number 0
                    counter++;
                    System.out.println(String.valueOf(counter) + " " + d);
                }
            }
        }
        System.out.println("Total sunday in XX century: "+counter);
    
		

	}

}
