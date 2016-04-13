package inter;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Acak {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(new File("C:/Users/idea/veritrans/inter/tes.txt")));
	
        String x = in.readLine();
        
        ArrayList<String> line = new ArrayList<String>();
        // untuk menampung kata-kata dari file
        while( x != null ) {
            line.add(x);
            x = in.readLine();
        }

        // random kata dari arraylist
        Random r = new Random();
        String rString = line.get(r.nextInt(line.size()));
        in.close();
        
        //System.out.println(rString);
                 
	    // convert string menjadi char
	    char c[] = rString.toCharArray();
	    // acak char yang ada di string dengan random 
	    for( int j=0 ; j<c.length-1 ; j++ )
	    {
	        int k = r.nextInt(c.length-1);
	            
	        char temp = c[j]; 
	        c[j] = c[k];  
	        c[k] = temp;
	    }
	    
	    System.out.print("Tebak kata: ");
	    System.out.println(c);
	    
	    // user tebak kata
	    boolean bool = true;
	    while(bool) {
	    	System.out.print("Jawab: ");
	    	Scanner sc = new Scanner(System.in);;
	    	String ans = sc.next();
	    	if(ans.equals(rString)) {
	    		System.out.println("BENAR!!!");
	    		bool = false;
	    	} else {
	    		System.out.println("Silakan coba lagi");
	    	}
	    }
	}
}
