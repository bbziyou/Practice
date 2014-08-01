public class IntToRoman { 
    public String intToRoman(int num) { 
        if (num <= 0) { 
            return ""; 
        } 
         
        int NUM[]    = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1}; 
        String SYM[] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"}; 
         
        StringBuilder result = new StringBuilder(); 
         
        for (int i = 0; num > 0; i++) { 
            int repeats = num / NUM[i]; 
             
            for (int j = 0; j < repeats; j++) { 
                result.append(SYM[i]); 
            } 
             
            num = num - repeats * NUM[i]; 
        } 
         
        return result.toString(); 
    } 
}