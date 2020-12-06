package com.java.interview;

public class BasicJavaInterview2 {
	
	public static void main(String[] args) {
		int result = 0;

        Boolean b1 = new Boolean("TRUE");
        Boolean b2 = new Boolean("true");
        Boolean b3 = new Boolean("tRuE");
        Boolean b4 = new Boolean("false");

        if (b1 == b2)result = 1;
        if (b1.equals(b2))result = result + 10;
        if (b2 == b4)result = result + 100;
        if (b2.equals(b4))result = result + 1000;
        if (b2.equals(b3))result = result + 10000;
        
        
        System.out.println("Boolean Answer ::"+result);


        //third

    int x = 0x80000000;
    System.out.print(x + " and ");
    x = x >>> 31;
    System.out.println("Seconf "+x);

    //fifth
    int y=20;
    String sup = (y < 15) ? "small" : (y < 22)? "tiny" : "huge";
    System.out.println("Fifth "+sup);

    //tent
    double a = 354.03;
    int  b = 256;
    byte c = (byte) a;
    byte d = (byte) b;
    System.out.println("Out Ten"+c + "\t"  + d);


    //eleven
    String str="FiRstpROgrAm";;
    String s=str;
    int aa=31,bb=aa++;
    if (s=="FiRstproRAm")
        System.out.println(bb--);
    else
        System.out.println(--bb);






    //eight
    int A1[] = {1, 2, 3};
    int A2[] = {1, 2, 3};
    if (A1.equals(A2))
        System.out.println("Same");
    else
        System.out.println("Not same");







    //Forth
    try
    {
        System.out.println("Hello world ");
        //throwit();
        System.out.println("try block ");
    }
    finally
    {
        System.out.println("Finally");
    }





        //second
    String [][] obj = new String[3][];
    System.out.println("Secon "+obj[2][0].toString());
	}

}
