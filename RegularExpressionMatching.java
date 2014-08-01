public class RegularExpressionMatching { 
    public boolean isMatch(String s, String p) { 
        if (s == null || p == null) { 
            return false; 
        } 
         
        if (p.length() == 0) { 
            return s.length() == 0; 
        } 
        if (s.length() == 0) { 
            if (p.length() % 2 != 0) { 
                return false; 
            } 
            for (int i = 1; i < p.length(); i += 2) { 
                if (p.charAt(i) != '*') { 
                    return false; 
                } 
            } 
            return true; 
        } 
        if (p.length() == 1) { 
            if (s.length() == 1) { 
                return (p.charAt(0) == s.charAt(0)) || (p.charAt(0) == '.'); 
            } 
            return false; 
        } 
         
        // next char is not * 
        if (p.charAt(1) != '*') { 
            return ( ((s.charAt(0) == p.charAt(0)) || (p.charAt(0) == '.' && s.length() != 0 ))  
            && isMatch(s.substring(1), p.substring(1)) ); 
        } 
         
        // next char is * 
        while (s.length() != 0 && (s.charAt(0) == p.charAt(0)) || (p.charAt(0) == '.' && s.length() != 0)) { 
            if (isMatch(s, p.substring(2))) { 
                return true; 
            } 
            s = s.substring(1); 
        } 
         
        return isMatch(s, p.substring(2)); 
    } 
}