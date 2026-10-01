import java.util.*; 
 
public class ServerRequestValidator { 
 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
 
        // Read request sequence 
        String s = sc.nextLine(); 
 
        Stack<Character> stack = new Stack<>(); 
 
        boolean valid = true; 
 
        // Process each symbol 
 
 
        for (char ch : s.toCharArray()) { 
 
            // Opening symbols 
            if (ch == '(' || ch == '[' || ch == '{' || ch == '<') { 
                stack.push(ch); 
            } 
 
            // Closing symbols 
            else if (ch == ')' || ch == ']' || ch == '}' || ch == '>') { 
 
                if (stack.isEmpty()) { 
                    valid = false; 
                    break; 
                } 
 
                char top = stack.pop(); 
 
                if ((ch == ')' && top != '(') || 
                    (ch == ']' && top != '[') || 
                    (ch == '}' && top != '{') || 
                    (ch == '>' && top != '<')) { 
 
                    valid = false; 
                    break; 
                } 
            } 
        } 
 
        // If unmatched opening symbols remain 
        if (!stack.isEmpty()) { 
            valid = false; 
        } 
 
 
 
        if (valid) { 
            System.out.println("VALID"); 
        } else { 
            System.out.println("INVALID"); 
        } 
 
        sc.close(); 
    } 
} 
