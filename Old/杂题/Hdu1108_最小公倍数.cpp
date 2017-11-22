//
//  Hdu1108_最小公倍数.cpp
//  算法学习
//
//  Created by 洪嘉勇 on 16/2/19.
//  Copyright © 2016年 洪嘉勇. All rights reserved.
//

#include <stdio.h>
#include <iostream>
using namespace std;

int main(){
    int a, b;
    while (cin >> a >> b) {
        int temp = 1, A = a, B = b;
        while (temp != 0) {
            temp = A % B;
            if (temp == 0) {
                cout << a * b / B << endl;
                break;
            }
            A = B;
            B = temp;
        }
    }
    return 0;
}