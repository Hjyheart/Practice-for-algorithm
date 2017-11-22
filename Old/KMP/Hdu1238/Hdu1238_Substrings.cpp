//
//  Hdu1238_Substrings.cpp
//  算法学习
//
//  Created by 洪嘉勇 on 16/2/26.
//  Copyright © 2016年 洪嘉勇. All rights reserved.
//

#include <stdio.h>
#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int T, N;
string str[101];

int cmp(const string& a, const string& b){
    return a.length()<b.length();
}

int main(){
    scanf("%d", &T);
    while (T--) {
        scanf("%d", &N);
        for (int i = 0; i < N; i++) {
            cin >> str[i];
        }
        sort(str, str + N, cmp);
        int max = 0, temp = 0, flag = 0;
        for (int l = 0; l < str[0].length(); l++) {
            for (int i = 1; i + l <= str[0].length(); i++) {
                string now = str[0].substr(l, i);
                string rev = now;
                reverse(rev.begin(), rev.end());
                for (int k = 1; k < N; k++) {
                    for (int j = 0; j + i <= str[k].length(); j++) {
                        string s = str[k].substr(j, i);
                        if (s == now || s == rev) {
                            flag = 1;
                            break;
                        }
                    }
                    if (!flag) {
                        break;
                    }
                    if (k != N - 1) {
                        flag = 0;
                    }
                }
                if (flag) {
                    if (temp < i) {
                        temp = i;
                    }
                    flag = 0;
                }
            }
        }
        if (temp > max) {
            max = temp;
        }
        printf("%d\n", max);
    }
    return 0;
}