package com.algorithms.hackerrank;

import java.util.Scanner;

public class OnceInATram {

	private static String onceInATram(String number) {
        String x = number.substring(0, 3);
        String y = number.substring(3);
        
        char[] adigits = x.toCharArray();
        char[] bdigits = y.toCharArray();
        int a = adigits[0] - '0' + adigits[1] - '0' + adigits[2] - '0';
        int b = bdigits[0] - '0' + bdigits[1] - '0' + bdigits[2] - '0';
        int diff = a - b;
        
        do {
    		y = String.format("%03d", Integer.parseInt(y) + 1);
    		bdigits = y.toCharArray();
    		b = bdigits[0] - '0' + bdigits[1] - '0' + bdigits[2] - '0';
    		diff = a - b;
    		if (diff != 0 && y.equals("999")) {
    			adigits = String.valueOf(Integer.parseInt(x) + 1).toCharArray();
        		a = adigits[0] - '0' + adigits[1] - '0' + adigits[2] - '0';
        		b = 0;
    			bdigits[0] = '0';
    			bdigits[1] = '0';
    			bdigits[2] = '0';
    			y = "0";
    			diff = a - b;
    		}
    	} while (diff != 0);
        
        return new StringBuilder()
        		.append(adigits)
        		.append(bdigits)
        		.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String number = in.nextLine();
        System.out.println(onceInATram(number));
        in.close();
    }
}
