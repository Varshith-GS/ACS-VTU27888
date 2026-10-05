import java.util.*;

class Solution {
    public int numUniqueEmails(String[] emails) {

        Set<String> uniqueEmails = new HashSet<>();

        for (String email : emails) {

            String[] parts = email.split("@");

            String local = parts[0];
            String domain = parts[1];

            // Ignore everything after '+'
            int plusIndex = local.indexOf('+');

            if (plusIndex != -1) {
                local = local.substring(0, plusIndex);
            }

            // Remove '.'
            local = local.replace(".", "");

            // Create normalized email
            String normalizedEmail = local + "@" + domain;

            uniqueEmails.add(normalizedEmail);
        }

        return uniqueEmails.size();
    }
}
