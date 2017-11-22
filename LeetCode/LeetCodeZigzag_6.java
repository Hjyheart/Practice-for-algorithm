package LeetCode;

/**
 * Created by hongjiayong on 2017/4/13.
 */
public class LeetCodeZigzag_6 {
    public static String convert(String s, int numRows) {
        if (numRows < 2 || s.length() <= numRows){
            return s;
        }

        int numCols = 0;

        if ((s.length() - numRows) % (2 * numRows - 2) > numRows - 2){
            numCols += numRows - 1;
        }else{
            numCols += (s.length() - numRows) % (2 * numRows - 2);
        }

        numCols += (s.length() - numRows) / (2 * numRows - 2) * (numRows - 1) + 1;

        char [][] zigs = new char[numRows][numCols];

        int x = 0, y = 0;
        for (int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            if (x == 0){
                zigs[x][y] = cur;
                x++;
                continue;
            }
            if (x == numRows - 1){
                zigs[x][y] = cur;
                x--;
                y++;
                continue;
            }
            if (zigs[x - 1][y] != 0){
                zigs[x][y] = cur;
                x++;
                continue;
            }

            zigs[x][y] = cur;
            x--;
            y++;
        }

        String res = "";

        for (int i = 0; i < numRows; i++){
            for (int k = 0; k < numCols; k++){
                if (zigs[i][k] != 0){
                    res += zigs[i][k];
                }
            }
        }

        return res;
        
    }

    public static void main(String [] args){
        System.out.println(convert("PAYPALISHIRING", 3));
    }
}
