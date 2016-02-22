//
//  Hdu1085_Holding Bin-Laden Captive.cpp
//  算法学习
//
//  Created by 洪嘉勇 on 16/2/16.
//  Copyright © 2016年 洪嘉勇. All rights reserved.
//

#include <stdio.h>
#include <iostream>
#include <cstdio>
#include <string.h>
#include <algorithm>
using namespace std;

int V, one_amount, two_amount, five_amount;

struct coin{
    int one;
    int two;
    int five;
}coin[8006];



int main(){
    scanf("%d%d%d", &one_amount, &two_amount, &five_amount);
    while (one_amount != 0 || two_amount != 0 || five_amount != 0) {
        V = one_amount + 2 * two_amount + 5 * five_amount;
        coin[0].one = 0;
        coin[0].two = 0;
        coin[0].five = 0;
        
        for (int i = 1; i <= V + 1; i++) {
            if (i - 5 >= 0 && five_amount - coin[i - 5].five> 0) {
                coin[i] = coin[i - 5];
                coin[i].five++;
                continue;
            }
            if (i - 2 >= 0 && two_amount - coin[i - 2].two > 0) {
                coin[i] = coin[i - 2];
                coin[i].two++;
                continue;
            }
            if(i - 1 >= 0 && one_amount - coin[i - 1].one> 0){
                coin[i] = coin[i - 1];
                coin[i].one++;
                continue;
            }
            printf("%d\n", i);
            break;
        }
        
        scanf("%d%d%d", &one_amount, &two_amount, &five_amount);
    }
    return 0;
}
/*
#include<cstdio>

struct node
{
    int a,b,c;
}dp[8005];
int main()
{
    int n1,n2,n5;
    while(scanf("%d%d%d",&n1,&n2,&n5),n1+n2+n5)
    {
        dp[0].a = 0;
        dp[0].b = 0;
        dp[0].c = 0;
        int ans = 0;
        for(int i = 1;i <= n1 + 2*n2+5*n5+1;++i)   //&#188;ó1ê&#199;&#212;ú&#203;ùóDμ&#196;&#182;&#188;&#196;üêμ&#207;&#214;μ&#196;&#199;é&#191;&#246;&#207;&#194;&#191;éò&#212;&#214;±&#189;óμ&#195;μ&#189;±è×üêy′ó1μ&#196;&#189;á1&#251;
        {
            if(i >= 1 && dp[i-1].a+1 <= n1)
                dp[i] = dp[i-1],dp[i].a += 1;
            else if(i >= 2 && dp[i-2].b+1 <= n2)
                dp[i] = dp[i-2],dp[i].b += 1;
            else if(i >=5 && dp[i-5].c+1 <= n5)
                dp[i] = dp[i-5],dp[i].c += 1;
            else
            {
                ans = i;
                break;
            }
        }
        printf("%d\n",ans);
    }
    return 0;
}
 */

