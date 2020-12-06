package com.java.interview;

public class InterviewCoding {
	public static void main(String[] args) {
	printPrimeNumbers(100);
			
		}
		
	
	   private static void printPrimeNumbers(int size){
		   
		   for (int i = 2; i < size; i++) {
			  if (!primeNumbet(i)){
				  System.out.println(i);
			  }
		
		}
	   }
	    
		public static boolean primeNumbet(int num){
			boolean flag = false;
				
			for (int j = 2; j < num/2; j++) {
				
				if(num%j==0 ){
					
					flag = true;
				}
				
			}
			return flag;
			
		
	}

}
