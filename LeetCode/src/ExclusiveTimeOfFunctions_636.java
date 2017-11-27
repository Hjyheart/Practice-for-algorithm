package src;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by I332329 on 11/27/2017.
 */
public class ExclusiveTimeOfFunctions_636 {

    public static class command {
        int count;
        int id;
        int startTime;
        int timeStamp;
        boolean run;
        public command(int id, int startTime) {
            this.count = 1;
            this.timeStamp = startTime;
            this.run = true;
            this.id = id;
            this.startTime = startTime;
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
        Pattern r = Pattern.compile("^([0-9]*):(\\D+):([0-9]*$)");
        Stack<command> commands = new Stack<>();
        List<command> commandList = new ArrayList<>();
        int[] res = new int[n];

        for (String str : logs) {
            Matcher m = r.matcher(str);
            int id = 0, time = 0;
            String flag = "";
            while(m.find()) {
                id = Integer.valueOf(m.group(1));
                flag = m.group(2);
                time = Integer.valueOf(m.group(3));
            }
            if (commands.empty()) {
                commands.push(new command(id, time));
                continue;
            }

            switch (flag){
                case "start":
                    if (commands.peek().run) {
                        commands.peek().count += time - commands.peek().timeStamp - 1;
                        commands.peek().timeStamp = time;
                        commands.peek().run = false;
                    }
                    commands.push(new command(id, time));
                    break;
                case "end":
                    command tmp = commands.pop();
                    if (tmp.run) {
                        tmp.count += time - tmp.timeStamp;
                    }
                    commandList.add(tmp);
                    if (!commands.empty()) {
                        commands.peek().run = true;
                        commands.peek().timeStamp = time;
                    }
                    break;
            }
        }

        commandList.sort(new compare());

        for (int i = 0; i < commandList.size(); i++) {
            res[i] = commandList.get(i).count;
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("0:start:0");
        list.add("1:start:2");
        list.add("1:end:5");
        list.add("0:end:6");
//                ["0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7"]
        exclusiveTime(2, list);
    }
}
