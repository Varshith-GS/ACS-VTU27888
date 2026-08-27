class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {

            if (asteroid > 0) {
                stack.push(asteroid);
                continue;
            }

            boolean destroyed = false;

            while (!stack.isEmpty() && stack.peek() > 0) {

                if (stack.peek() < -asteroid) {

                    stack.pop();
                }
                else if (stack.peek() == -asteroid) {

                    stack.pop();
                    destroyed = true;
                    break;
                }
                else {
          
                    destroyed = true;
                    break;
                }
            }

            if (!destroyed) {
                stack.push(asteroid);
            }
        }

        int[] result = new int[stack.size()];

        for (int i = 0; i < result.length; i++) {
            result[i] = stack.get(i);
        }

        return result;
    }
}
