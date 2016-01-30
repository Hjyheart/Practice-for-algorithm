//
//  Hdu1003_Max Sum.cpp
//  算法学习
//
//  Created by 洪嘉勇 on 16/1/30.
//  Copyright © 2016年 洪嘉勇. All rights reserved.
//

#include <stdio.h>
#include <iostream>

using namespace std;

int main(){
    int T;
    cin >> T;
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
    return 0;
}