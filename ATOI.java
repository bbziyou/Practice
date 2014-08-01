public class ATOI { 
    public int atoi(String str) { 
        if (str == null || str.length() == 0) { 
            return 0; 
        } 
         
        char[] str_num = str.toCharArray(); 
         
        int len    = str_num.length; 
        int curser = 0; 
        int sign   = 1; 
        int num    = 0; 
         
        while (str_num[curser] == ' ' && curser < len) { 
            curser ++; 
        } 
         
        if (str_num[curser] == '-') { 
            sign = -1; 
            curser += 1; 
        } else if (str_num[curser] == '+') { 
            curser += 1; 
        } 
         
        while (curser < len && str_num[curser] <= '9' && str_num[curser] >= '0') { 
            long tmp = (long) num * 10 + str_num[curser] - '0'; 
             
            if (tmp >= Integer.MAX_VALUE) { 
                if (tmp == Integer.MAX_VALUE && sign == -1) { 
                    return sign * Integer.MAX_VALUE; 
                } 
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE; 
            } else { 
                num = (int) tmp; 
            } 
            curser += 1; 
        } 
         
        return sign * num; 
    } 
}