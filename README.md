# Practice
Practice for algorithm

## Trie Tree
一种用于字典搜索的树，代码中用数组实现
对应题目为http://hihocoder.com/problemset/problem/1014

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


