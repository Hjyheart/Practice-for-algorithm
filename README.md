# Practice
Practice for algorithm

## Trie Tree
一种用于字典搜索的树，代码中用数组实现
对应题目为http://hihocoder.com/problemset/problem/1014

## 快速幂
一种二分思想
''''c++
int quickMPow(int a, int b){
    if (b == 0) {
        return 1;
    }
    int reslut = 1;
    while (b) {
        if (b & 1) {
            reslut *= a;
        }
        a *= a;
        b >>= 1;
    }
    return reslut;
}
''''

