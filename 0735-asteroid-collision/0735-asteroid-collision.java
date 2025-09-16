class Solution {
    public int[] asteroidCollision(int[] asteroids) {
         List<Integer> stack = new ArrayList<>(); // like a pile of surviving asteroids

        for (int a : asteroids) {
            boolean alive = true;
            while (!stack.isEmpty() && a < 0 && stack.get(stack.size() - 1) > 0) {
                int top = stack.get(stack.size() - 1);

                if (top < -a) { 
                    stack.remove(stack.size() - 1);
                    continue;
                } else if (top == -a) { 
                    stack.remove(stack.size() - 1);
                }
                alive = false;
                break;
            }

            if (alive) {
                stack.add(a); 
            }
        }
        int[] result = new int[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            result[i] = stack.get(i);
        }
        return result;
    }
        
    }
