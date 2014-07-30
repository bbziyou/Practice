public class NoRepeatingLongestString { 
    public int lengthOfLongestSubstring(String s) { 
        if (s.length() == 0 || s.length() == 1) { 
            return s.length(); 
        } 
         
        int head = 0; 
        int max_length = 0; 
         
        HashSet<Character> saver = new HashSet<Character>(); 
     
        // Go through the string only once.  
        // If met the repeating character, remove all the chars between head -- i from set 
        for (int i = 0; i < s.length(); i++) { 
            char c = s.charAt(i); 
             
            if (saver.contains(c)) { 
                while (c != s.charAt(head)) { 
                    saver.remove(s.charAt(head)); 
                    head += 1; 
                } 
                head += 1; 
            } else { 
                saver.add(c); 
                max_length = Math.max(max_length, i - head + 1); 
            } 
        } 
         
        return max_length; 
    } 
}