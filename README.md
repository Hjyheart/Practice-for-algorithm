# Practice
Practice for algorithm

## Trie Tree
一种用于字典搜索的树，代码中用数组实现
对应题目为[字典树](http://hihocoder.com/problemset/problem/1014)

## 快速幂
一种二分思想
````c++
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
````
## 高精度加法
利用字符串来进行加减，不受位数的限制
````c++
void solve(){
    int lenNum1 = strlen(num1), lenNum2 = strlen(num2), min = 0, c = 0, count = 0;
    if (lenNum1 >= lenNum2) {
        min = lenNum2;
    }else{
        min = lenNum1;
    }
    
    while (min) {
        int temp;
        temp = num1[lenNum1 - 1] + num2[lenNum2 - 1] - 96;
        min--;
        lenNum1--;
        lenNum2--;
        sum[count] = (temp % 10 + c) % 10 + 48;
        count++;
        if(temp % 10 + c >= 10){
            c = 1;
        }
        else{
            c = 0;
        }
        if (temp >= 10) {
            c++;
        }
    }
    
    while (lenNum1) {
        sum[count] = (num1[lenNum1 - 1] - 48 + c) % 10 + 48;
        count++;
        if(num1[lenNum1 - 1] - 48 + c >= 10){
            c = 1;
        }else{
            c = 0;
        }
        lenNum1--;
    }
    
    while (lenNum2) {
        sum[count] = (num2[lenNum2 - 1] - 48 + c) % 10 + 48;
        count++;
        if(num2[lenNum2 - 1] - 48 + c >= 10){
            c = 1;
        }else{
            c = 0;
        }
        lenNum2--;
    }
    
    if (c) {
        sum[count] = '1';
        count++;
    }
    
    count--;
    
    for (int i = 0; i <= count; i++) {
        if(sum[i] != '0')
            break;
        if(i == count){
            cout << '0' << endl;
            return;
        }
    }
    
    while (count >= 0) {
        cout << sum[count];
        count--;
    }
    cout << endl;
}

````
来自[Hdu 1002](http://acm.hdu.edu.cn/showproblem.php?pid=1002)

## 最大子串和
Given a sequence a[1],a[2],a[3]......a[n], your job is to calculate the max sum of a sub-sequence. For example, given (6,-1,5,4,-7), the max sum in this sequence is 6 + (-1) + 5 + 4 = 14.
````c++
for (int i = 0; i < T; i++) {
        int count, start = 1, end = 1, max = -1<<31, dp = 0, temp = 1;
        cin >> count;
       
        for (int k = 0; k < count; k++) {
            int num;
            cin >> num;
            dp += num;
            if(dp > max) {
                max = dp;
                start = temp;
                end = k + 1;
            }
            if(dp < 0){
                dp = 0;
                temp = k + 2;
            }
        }
        cout << "Case " << i + 1 << ":" << endl;
        cout << max << " " << start << " " << end << endl;
        if (i != T - 1) {
            cout << endl;
        }
    }
````
来自[Hdu 1003](http://acm.hdu.edu.cn/showproblem.php?pid=1003)

##动态规划之数塔
数塔是一种典型的动态规划问题。可以想象成是从杨辉三角这样的结构上的顶点开始向下走，可左可右。到底时要求达到最大值。利用动态规划，自底向上计算，就可以得到一个最优解。
````c++
int H1176_Solve(){
    for (int i = maxTime - 1; i >= 0; i--) {
        for (int k = 0; k < 11; k++) {
            int maxValue = arr[k][i + 1];
            if (k - 1 >= 0) {
                if (arr[k - 1][i + 1] > maxValue) {
                    maxValue = arr[k - 1][i + 1];
                }
            }
            if(k + 1 <= 10){
                if (arr[k + 1][i + 1] > maxValue) {
                    maxValue = arr[k + 1][i + 1];
                }
            }
            arr[k][i] = arr[k][i] + maxValue;
        }
    }
    int max = arr[4][1];
    for (int i = 4; i < 7; i++) {
        if(arr[i][1] > max){
            max = arr[i][1];
        }
    }
    return max;
}
````
来自[Hdu 1176](http://acm.hdu.edu.cn/showproblem.php?pid=1176)
