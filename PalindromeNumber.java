public class PalindromeNumber { 
    public boolean isPalindrome(int x) { 
        if (x < 0) { 
            return false; 
        } 
         
        int div = 1; 
 
        while ((x / div) >= 10) { 
            div *= 10; 
        } 
         
        while (x > 0) { 
            int least = x % 10; 
            int most  = x / div; 
             
            if (least != most) { 
                return false; 
            } 
             
            x = x % div / 10; 
            div /= 100; 
        } 
         
        return true; 
    } 
}