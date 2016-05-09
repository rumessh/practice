package net.droidit.string;

public class BaseConversion {

    public static String convertBase(String s, int b1, int b2) {
        boolean isNegative = s.startsWith("-");
        int x = 0;
        //Convert from b1 to deceimal
        for(int i = isNegative? 1 : 0; i< s.length(); ++i) {
            x *= b1;
            x += Character.isDigit(s.charAt(i)) ? s.charAt(i) - '0' : s.charAt(i) - 'A' + 10;
        }
        StringBuilder result = new StringBuilder();
        
        do {
            int reminder = x % b2;
            result.append((char)(reminder >= 10 ? 'A' + reminder - 10 : '0' + reminder));
            x /= b2;
        }while(x != 0);
        
        if(isNegative) {
            result.append('-');
        }
        
        result.reverse();
        
        return result.toString();
    }
}