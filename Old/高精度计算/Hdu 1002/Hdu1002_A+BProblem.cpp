//
//  Hdu1002_A+BProblem.cpp
//  算法学习
//
//  Created by 洪嘉勇 on 16/1/30.
//  Copyright © 2016年 洪嘉勇. All rights reserved.
//

#include <stdio.h>
#include <iostream>
#include <string.h>

using namespace std;

char num1[1000] = {'\0'}, num2[1000] = {'\0'}, sum[1002] = {'\0'};

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
/*
int main(){
    int T = 0;
    
    cin >> T;
    for (int i = 0; i < T; i++) {
        cin >> num1 >> num2;
        cout << "Case " << i + 1 << ":" << endl
            << num1 << " + " << num2 << " = ";
        solve();
        if (i != T - 1) {
            cout << endl;
        }
        num1[0] = '\0';
        num2[0] = '\0';
        sum[0] = '\0';
    }
    
    return 0;
}
 */

/*
#include<stdio.h>
#include<string.h>
int main()
{
    char a[1000],b[1000],c[1001];
    int i,j=1,p=0,n,n1,n2;
    scanf("%d",&n);
    while(n)
    {
        scanf("%s %s",a,b);
        printf("Case %d:\n",j);
        printf("%s + %s = ",a,b);
        n1=strlen(a)-1;
        n2=strlen(b)-1;
        for(i=0;n1>=0||n2>=0;i++,n1--,n2--)
        {
            if(n1>=0&&n2>=0){c[i]=a[n1]+b[n2]-'0'+p;}
            if(n1>=0&&n2<0){c[i]=a[n1]+p;}
            if(n1<0&&n2>=0){c[i]=b[n2]+p;}
            p=0;
            if(c[i]>'9'){c[i]=c[i]-10;p=1;}
        }
        if(p==1){printf("%d",p);}
        while(i--)
        {printf("%c",c[i]);}
        j++;
        if(n!=1){printf("\n\n");}
        else {printf("\n");}
        n--;
    }
}
 */
