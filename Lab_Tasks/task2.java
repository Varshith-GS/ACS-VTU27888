import java.util.*;
public class WarehouseProductFrequencyManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] products = new int[N];
        for (int i = 0; i < N; i++) {
            products[i] = sc.nextInt();
        }
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int id : products) {
            freqMap.put(id, freqMap.getOrDefault(id, 0) + 1);
        }
        int maxProduct = -1;
        int maxFreq = -1;
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int productID = entry.getKey();
            int frequency = entry.getValue();
            if (frequency > maxFreq || (frequency == maxFreq && productID < maxProduct)) {
                maxFreq = frequency;
                maxProduct = productID;
            }
        }
        System.out.println(maxProduct + " " + maxFreq);
        sc.close();
    }
}
