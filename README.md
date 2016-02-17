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

##BFS
广度优先搜索因为可以一层一层地搜索图，所以可以作为一种求最短路径的方式，当然啦，是那种权值都相等的图。一般会有一个数组去标记是否访问来防止反复访问，但是有的题目会有重复走的情况，则视情况而定。基本上是有一个统一的模板的。需要用到队列，有的时候题目会有用到优先队列的需求。
````c++
void solve(){
    queue<Node> s;
    memset(flag, 0, sizeof(flag));
    now.x = inx;
    now.y = iny;
    now.time = 6;
    now.output = 0;
    flag[inx][iny] = 6;
    s.push(now);
    
    while (!s.empty()) {
        now = s.front();
        s.pop();
        for (int i = 0; i < 4; i++) {
            nex = now;
            nex.x = now.x + fx[i];
            nex.y = now.y + fy[i];
            if(nex.x >= 0 && nex.x < N && nex.y >= 0 && nex.y < M && flag[nex.x][nex.y] < now.time - 1){
                if (mp[nex.x][nex.y] == 0) {
                }
                if(mp[nex.x][nex.y] == 3){
                }
                if (mp[nex.x][nex.y] == 1) {
                }
                if (mp[nex.x][nex.y] == 4) {
                }
            }
        }
    }
    printf("-1\n");
}
````
来自[Hdu 1072](http://acm.hdu.edu.cn/showproblem.php?pid=1072)

##背包问题
###01背包
01背包是最基础的一类背包：有N件物品和一个容量为V的背包。第i件物品的费用是c[i]，价值是w[i]。求解将哪些物品装入背包可使价值总和最大。
状态方程为：f[i][v]=max{f[i-1][v],f[i-1][v-c[i]]+w[i]}

基本的解法为对于背包容量的逆推：
for i=1..N
    for v=V..cost
        f[v]=max{f[v],f[v-c[i]]+w[i]};

题目可参考[Hdu1203](http://acm.hdu.edu.cn/showproblem.php?pid=1203)&&[Hdu2602](http://acm.hdu.edu.cn/showproblem.php?pid=2602)
###完全背包
完全背包是每件物品可以放置无数次的一类背包，因为可以无数次放置，所以在递推的时候我们将不再需要逆推，所以它的解法是：
for i=1..N
    for v=cost..V
        f[v]=max{f[v],f[v-c[i]]+w[i]};
就只是和01背包有那么一丢丢的差
###多重背包
多重背包相对复杂，怎么说呢，就是物品有了数量的限制。当数量足够多时，我们采用的还是完全背包的方法，当数量不够多的时候我们将数量拆分，再简化为01背包去求解。
方法是：将第i种物品分成若干件物品，其中每件物品有一个系数，这件物品的费用和价值均是原来的费用和价值乘以这个系数。使这些系数分别为1,2,4,...,2^(k-1),n[i]-2^k+1，且k是满足n[i]-2^k+1>0的最大整数。例如，如果n[i]为13，就将这种物品分成系数分别为1,2,4,6的四件物品。
解法为：
procedure MultiplePack(cost,weight,amount)

    if cost*amount>=V
        CompletePack(cost,weight)
        return
    integer k=1
    while k<amount
        ZeroOnePack(k*cost,k*weight)
        amount=amount-k
        k=k*2
    ZeroOnePack(amount*cost,amount*weight)

完全背包和多重背包的题目参考[Hdu 2159](http://acm.hdu.edu.cn/showproblem.php?pid=2159) 
                            [Hdu 2191](http://acm.hdu.edu.cn/showproblem.php?pid=2191)
                            [Hdu 1171](http://acm.hdu.edu.cn/showproblem.php?pid=1171)

