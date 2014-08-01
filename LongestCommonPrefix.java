public class LongestCommonPrefix {
    
    public String longestCommonPrefix(String[] strs) { 
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        String prefix = strs[0];
        
        for (int i = 1; i < strs.length; i++) {
            String str = strs[i];
            
            int j = 0;
            for (; j < str.length(); j++) {
                if (j >= prefix.length() || str.charAt(j) != prefix.charAt(j)) {
                    break;
                }
            }
            
            if (j == 0) {
                return "";
            }
            
            prefix = prefix.substring(0, j);
        }
        
        return prefix;
    } 
    
}