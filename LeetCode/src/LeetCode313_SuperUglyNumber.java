package src;

/**
 * Created by I332329 on 11/29/2017.
 * Tag: DP Heap
 * Solution:
 * 这道题实在是太狗血了 用最小堆进行加速但是反而会慢 应该是用的数据结构复杂了的原因
 * 解题方法跟264是一模一样的
 */
public class LeetCode313_SuperUglyNumber {

    public static void swap(Integer[] nums, int i, int k) {
        int tmp = nums[i];
        nums[i] = nums[k];
        nums[k] = tmp;
    }

    public static void heapUp(Integer[] nums, int index) {
        if (index > 1) {
            int parent = index / 2;
            int parentValue = nums[parent];
            int indexValue =  nums[index];
            if (parentValue > indexValue) {
                swap(nums, parent, index);
                heapUp(nums, parent);
            }
        }
    }

    public static void heapDown(Integer[] nums, int index, int size) {
        int n = size - 2;

        int child = -1;

        if (2 * index > n) {
            return;
        }
        else if (2 * index < n) {

            child = 2 * index;
            if (nums[child] > nums[child + 1]) {
                child++;
            }

        }
        else if (2 * index == n) {
            child = 2 * index;
        }

        if (nums[child] < nums[index]) {
            swap(nums, child, index);
            heapDown(nums, child, size);
        }
    }

    public static void insert(Integer[] nums, int newNum, int size) {
        if (size == 0) {
            nums[0] = null;
        }
        nums[size] = newNum;
        heapUp(nums, size);
    }

    public static void delete(Integer[] nums, int index, int size) {
        nums[index] = nums[size - 1];
        heapDown(nums, index, size);
        nums[size - 1] = null;
    }

    public static Integer pop(Integer[] nums, int size) {
        if (size > 1) {
            int val = nums[1];
            delete(nums, 1, size);
            return val;
        } else {
            return null;
        }
    }

    public static Integer peek(Integer[] nums, int size) {
        if (size > 1) {
            int val = nums[1];
            return val;
        } else {
            return null;
        }
    }

    static class Prime{
        int val;
        int valCur;
        int valIndex;
        public Prime(int val) {
            this.val = val;
            this.valCur = val;
            this.valIndex = 0;
        }
    }

    public static int nthSuperUglyNumber(int n, int[] primes) {
        int[] uglys = new int[1000001];
        uglys[0] = 1;
        Prime[] primeArrayList = new Prime[primes.length];
        Integer[] minQueue = new Integer[1000002];
        int size = 1;

        minQueue[0] = null;

        for (int i = 0; i < primes.length; i++) {
            Prime tmp = new Prime(primes[i]);
            primeArrayList[i] = tmp;
            insert(minQueue, primes[i], size);
            size++;
        }

        int val = 1;

        for (int i = 1; i < n; i++) {
            int tmp = pop(minQueue, size);
            size--;
            while (tmp <= val) {
                tmp = pop(minQueue, size);
                size--;
            }
            val = tmp;

            for (int k = 0; k < primeArrayList.length; k++) {
                if (val == primeArrayList[k].valCur) {
                    uglys[i] = primeArrayList[k].valCur;
                    primeArrayList[k].valIndex++;
                    primeArrayList[k].valCur = uglys[primeArrayList[k].valIndex] * primeArrayList[k].val;
                    if (primeArrayList[k].valCur > 0) {
                        insert(minQueue, primeArrayList[k].valCur, size);
                        size++;
                    }
                }
            }
        }
        return uglys[n - 1];
    }

    public static void main(String[] args) {
//                [2,7,13,19]
        System.out.println(nthSuperUglyNumber(12, new int[]{2,7,13,19}));
    }
}
