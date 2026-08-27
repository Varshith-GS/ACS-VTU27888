class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<>();

        for (int i = prices.length - 1; i >= 0; i--) {
            int originalPrice = prices[i];

            while (!stack.isEmpty() && stack.peek() > originalPrice) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                prices[i] = originalPrice - stack.peek();
            }

            stack.push(originalPrice);
        }

        return prices;
    }
}
