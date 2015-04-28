public class FirstFollow
{
   public static void main(String arg[])
     {
      String left[]={"E","A","T","B","F"};
      String right[]={"TA","+TA/e","FB/e","*FB/e","(E)/i"};

      String right1[][]=new String[10][3];
      System.out.print("\t"+right1.length+"  "+right1[0].length);

      for(int i  = 0; i < right.length ;i++)
        {
    	//It will split +TB/e in form of +TA(position 0) e(position 1)
          right1[i]=right[i].split("/");              
        }

      for(int i  = 0; i < right.length ;i++)
          {
            for(int j = 0; j < right1[i].length ;j++)
               {
                 System.out.print("\t"+right1[i][j]);
               }
            System.out.print("\n ");
          }
     String first[][]= new String[right.length][2];
     
     //System.out.print("\t"+right1.length+"  "+right1[0].length+" "+right1[0].toString());

     for(int i  = 0; i < right.length ;i++)
        {
         int k = i;

         for( int j  = 0; j < right1[k].length ;j++)
            {
              if(right1[k][j].charAt(0)< 'A' || right1[k][j].charAt(0) >'Z')
                  {
                   first[i][j]=""+right1[k][j].charAt(0);
                  }
              else
                 {
                  for(int h = 0; h < left.length ; h++ )
                    {
                     if(left[h].charAt(0)==(right1[k][j].charAt(0)))
                       {
                        k = h;
                        j =-1;    //j=-1 not j=j-1 ..so that after incrementing ++j it should start from j=0
                        break;
                      }
                    }//break this loop
                  }
              }
           }

         System.out.print("\nFirst");
         for(int i  = 0; i < first.length ;i++)
          {
           System.out.print("\n");
           for(int j = 0; j < first[i].length ;j++)
               {
                System.out.print("  "+first[i][j]);
               }

          }

         String follow[][]= new String[10][20];

         int fcount[]= new int[10];
         follow[0][0]="$";              //initial is always $ i.e for starting element
         fcount[0]=1;
         for(int i  = 0; i < left.length ;i++)   {    
        	 //Traverse for all LHS
            if(i>0)
               {
                fcount[i]=0;
               }
             System.out.print("\n");
             
             //for all LHS find from top row to last row of RHS thats why two loop for each LHS
             for( int j  = 0; j < right.length ;j++)
                {
                 for( int h  = 0; h < right1[j].length ;h++)
                    {
                     if(right1[j][h].contains(left[i]))
                       {
                         int B =   right1[j][h].indexOf(left[i]);
                         String a =right1[j][h].substring(0, B);
                         String b =right1[j][h].substring(B+1,right1[j][h].length());
                         System.out.println(""+b);

                if(b.isEmpty())     //in case of FOLLOW(A) in  E->TA/e 
                           {
                            for(int k = 0; k < fcount[j] && j!= i ;k++) {                                                     
    //j!=i for case where we found again the same LHS for which we are finding follow
                                    follow[i][fcount[i]++]= follow[j][k];  
                            }				
                          }        
				 else  	     //if(b.isEmpty())==FALSE		
				 {   boolean isE = false;
					 //case follow of (A) in AB type
				if((int)b.charAt(0)>='A'&& (int)b.charAt(0)<='Z')
                             {
                              for(int k = 0; k < left.length ;k++)
                                 {
                           //assuming LHS of one char only 	  
                                  if(left[k].equalsIgnoreCase(b))
                                    {
                                     for(int m = 0; m < first[k].length ;m++)
                                        {
                              // it find Follow(A) in AB type i.e store all first(B)
                                    	 //except e in follow of A
                                         if(first[k][m].equalsIgnoreCase("e"))
                                           {
                                        	 	 isE=true;
                                           }
                                         else   //follow of A in  AB is first of B
                                           {
                                            follow[i][fcount[i]++]=first[k][m];
                                           }
                                        }
                                      break;   //case:A->TB..follow(T)=first(B)..and B->a/e..
                                      //so putting B=e in A->TB..follow(T)=follow(A)
                                     }

                                  }
                              for(int k = 0; k < fcount[j] && j!= i && isE==true;k++)   //&&isE=true
                                 {
                           //for cases where follow of B in  T->FB and 
                            	  //there is no other B.so follow of B==follow of parent(T) 
                            	  //and store it in follow of that row(i) element..
                                   follow[i][fcount[i]++]= follow[j][k];
                                 }

                            }
                         else     //if terminal
                            {
                              follow[i][fcount[i]++]=b;
                            }
                        }
                     }    //if(right1[j][h].contains(left[i]))
                   }
                }
            }

          System.out.print("\nFOLLOW");
          for(int i  = 0; i < left.length ;i++)
          {
           System.out.print("\n");
           for(int j = 0; j < fcount[i] ;j++)
               {
                System.out.print("  "+follow[i][j]);
               }
           }
      }

}