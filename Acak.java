package inter;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Acak {
	public static void main(String[] args) throws IOException {
		System.out.println("Selamat datang di Acak Kata!");
		System.out.println("Masukkan 1 jika ingin langsung main.");
		System.out.println("Masukkan 2 jika ingin meng-input data sendiri.");
		
		System.out.print("Silakan masukkan nomor: ");
		Scanner s = new Scanner(System.in);
		int no = s.nextInt();
		String file = null;
		
		if(no == 1) {
			// menggunakan data default
			file = "tes.txt";
		} else if(no == 2) {
			// menggunakan data inputan
			file = s.next();
		} else {
			System.out.println("Harap masukan angka yang sesuai");
		}
		
		// input file kumpulan kata, jika ingin diganti ganti sesuai nama dan path file baru
		BufferedReader in = new BufferedReader(new FileReader(new File(file)));
        String x = in.readLine();
     
        // untuk menampung kata-kata dari file
        ArrayList<String> line = new ArrayList<String>();
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
	    	Scanner sc = new Scanner(System.in);
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
