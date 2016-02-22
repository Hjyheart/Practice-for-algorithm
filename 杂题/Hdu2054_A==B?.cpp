//
//  Hdu2054_A==B?.cpp
//  算法学习
//
//  Created by 洪嘉勇 on 16/2/21.
//  Copyright © 2016年 洪嘉勇. All rights reserved.
//

#include <stdio.h>
#include <iostream>
#include <string>
#include <cstdio>
using namespace std;

int flagA = 0, flagB = 0, pointFlag = 0;
string A, B;

bool judge(const string str, int pos){
    if (pos == str.length()) {
        return true;
    }
    if (pointFlag) {
        if (str[pos] == '.') {
            pos++;
        }
        for (int i = pos; i < str.length(); i++) {
            if (str[i] != '0') {
                return false;
            }
        }
    }
    else{
        if (str[pos] != '.') {
            return false;
        }
        else
            pos++;
        for (int i = pos; i < str.length(); i++) {
            if (str[i] != '0') {
                return false;
            }
        }
    }
    return true;
}

int main(){
    while (cin >> A >> B) {
        int sA = 0, sB = 0;
        for (int i = 0; i < A.length(); i++) {
            if (A[i] != '0') {
                break;
            }
            if (i != A.length() - 1) {
                sA++;
            }
        }
        for (int i = 0; i < B.length(); i++) {
            if (B[i] != '0') {
                break;
            }
            if (i != B.length() - 1) {
                sB++;
            }
        }
        
        char chA = ' ', chB = ' ';
        while (1) {
            if (sA < A.length()) {
                chA = A[sA];
                if (chA == '.') {
                    pointFlag = 1;
                }
            }
            else
                flagA = 1;
            if (sB < B.length()) {
                chB = B[sB];
                if (chB == '.') {
                    pointFlag = 1;
                }
            }
            else
                flagB = 1;
            if (!flagA && !flagB) {
                if (chA != chB) {
                    printf("NO\n");
                    break;
                }
            }
            if (flagA) {
                if(judge(B, sB)){
                    printf("YES\n");
                    break;
                }
                else{
                    printf("NO\n");
                    break;
                }
            }
            if (flagB) {
                if(judge(A, sA)){
                    printf("YES\n");
                    break;
                }
                else{
                    printf("NO\n");
                    break;
                }
            }
            sA++;
            sB++;
        }
        flagA = 0;
        flagB = 0;
        pointFlag = 0;
    }
    return 0;
}
