package src;

import java.util.Stack;

/**
 * Created by I332329 on 11/27/2017.
 * Tag: Stack
 */
public class LeetCode735_AsteroidCollision {
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> asteroidStack = new Stack<>();
        for (int a : asteroids) {
            if (asteroidStack.empty()) {
                asteroidStack.push(a);
                continue;
            }
            while (!asteroidStack.empty()) {
                int tmp = asteroidStack.peek();
                if (tmp < 0) {
                    asteroidStack.push(a);
                    break;
                } else {
                    if (a > 0) {
                        asteroidStack.push(a);
                        break;
                    } else {
                        if (tmp + a < 0) {
                            asteroidStack.pop();
                            if (asteroidStack.empty()) {
                                asteroidStack.push(a);
                                break;
                            }
                            continue;
                        } else if (tmp + a > 0) {
                            break;
                        } else if (tmp + a == 0) {
                            asteroidStack.pop();
                            break;
                        }
                    }
                }
            }
        }
        int[] res = new int[asteroidStack.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = asteroidStack.pop();
        }
        return res;
    }

    public static void main (String[] args) {
        asteroidCollision(new int[]{-2, -1, 1, 2});
    }
}
