package src;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

/**
 * Created by I332329 on 11/27/2017.
 * Tag: Stack
 */
public class LeetCode636_ExclusiveTimeOfFunctions {

    public static class command {
        int count;
        int id;
        int startTime;
        int timeStamp;
        boolean run;
        public command(int id) {
            this.count = 0;
            this.run = true;
            this.id = id;
        }
    }

    static class compare implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            command command1 = (command) o1;
            command command2 = (command) o2;

            return command1.id - command2.id;
        }
    }

    public static int[] exclusiveTime(int n, List<String> logs) {
        Stack<command> commands = new Stack<>();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = 0;
        }

        for (String str : logs) {
            int id = 0, time = 0;
            String flag = "";
            int i = 0;
            while (i < str.length()) {
                if (str.charAt(i) == ':') {
                    id = Integer.valueOf(str.substring(0, i));
                    i++;
                    break;
                }
                i++;
            }
            int k = i;
            while (k < str.length()) {
                if (str.charAt(k) == ':') {
                    flag = str.substring(i, k);
                    k++;
                    break;
                }
                k++;
            }
            time = Integer.valueOf(str.substring(k));
            if (commands.empty()) {
                command tmp = new command(id);
                tmp.startTime = time;
                tmp.timeStamp = time;
                commands.push(tmp);
                continue;
            }

            switch (flag){
                case "start":
                    if (commands.peek().run) {
                        commands.peek().count += time - commands.peek().timeStamp;
                        commands.peek().timeStamp = time;
                        commands.peek().run = false;
                    }
                    command tmp0 = new command(id);
                    tmp0.startTime = time;
                    tmp0.timeStamp = time;
                    commands.push(tmp0);
                    break;
                case "end":
                    command tmp = commands.pop();
                    if (tmp.run) {
                        tmp.count += time - tmp.timeStamp + 1;
                    }
                    res[tmp.id] += tmp.count;
                    if (!commands.empty()) {
                        commands.peek().run = true;
                        commands.peek().timeStamp = time + 1;
                    }
                    break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("0:start:0");
        list.add("1:start:2");
        list.add("1:end:5");
        list.add("0:end:6");
//        list.add("0:end:6");
//        list.add("0:end:7");
//                ["0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7"]
        exclusiveTime(2, list);
    }
}
