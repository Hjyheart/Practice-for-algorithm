//
//  Hud1004_Let the Balloon Rise.cpp
//  算法学习
//
//  Created by 洪嘉勇 on 16/2/17.
//  Copyright © 2016年 洪嘉勇. All rights reserved.
//

#include <stdio.h>
#include <iostream>
#include <cstdio>
#include <string.h>
#include <string>

using namespace std;

struct ball{
    string color;
    int num = 0;
}Ball[1001];

int N, flag = 0, Max = 0;
string temp;

int main(){
    cin >> N;
    while (N != 0) {
        int maxNum = 0;
        for (int i = 0; i < N; i++) {
            cin >> temp;
            if (!flag) {
                flag++;
                Ball[0].color = temp;
                Ball[0].num = 1;
                Max = 0;
                maxNum = Ball[0].num;
                continue;
            }
            for (int k = 0; k < flag; k++) {
                if (Ball[k].color == temp) {
                    Ball[k].num++;
                    if (maxNum < Ball[k].num) {
                        Max = k;
                        maxNum = Ball[k].num;
                    }
                    break;
                }
                if (k == flag - 1) {
                    Ball[flag].color = temp;
                    Ball[flag].num = 1;
                    flag++;
                    break;
                }
            }
        }
        cout << Ball[Max].color << endl;
        Max = 0;
        flag = 0;
        cin >> N;
    }
    return 0;
}