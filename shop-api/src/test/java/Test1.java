import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author
 * @date 2017/8/15
 */
public class Test1 {

    private static String[] aa = { "S","L","M" };
    private static String[] bb = { "红","绿","黑" };
    private static String[] cc = { "15", "16", "17"};
    private static List<String> arr = Arrays.asList(aa);
    private static List<String> arr1 = Arrays.asList(bb);
    private static List<String> arr2 = Arrays.asList(cc);
    private static List<List<String>> result = new ArrayList<>();
    private static int counterIndex ;
    private static int[] counter;
    static {
        result.add(arr);
        result.add(arr1);
        result.add(arr2);
        counterIndex = result.size() - 1;
        counter = new int[result.size()];
    }

    /**
     * 循环实现dimValue中的笛卡尔积
     * @param dimValue 原始数据
     */
    private static List<List<String>>  circulate (List<List<String>> dimValue) {
        int total = 1;
        for (List<String> list : dimValue) {
            total *= list.size();
        }
        String[] myResult = new String[total];

        int itemLoopNum = 1;
        int loopPerItem = 1;
        int now = 1;
        for (List<String> list : dimValue) {
            now *= list.size();

            int index = 0;
            int currentSize = list.size();

            itemLoopNum = total / now;
            loopPerItem = total / (itemLoopNum * currentSize);
            int myIndex = 0;

            for (String string : list) {
                for (int i = 0; i < loopPerItem; i++) {
                    if (myIndex == list.size()) {
                        myIndex = 0;
                    }

                    for (int j = 0; j < itemLoopNum; j++) {
                        myResult[index] = (myResult[index] == null? "" : myResult[index] + ",") + list.get(myIndex);
                        index++;
                    }
                    myIndex++;
                }
            }
        }
        List<List<String>> result = new ArrayList<>();
        List<String> stringResult = Arrays.asList(myResult);
        for (String string : stringResult) {
            String[] stringArray = string.split(",");
            result.add(Arrays.asList(stringArray));
        }
        return result;
    }




    public static void main(String[] args) throws Exception {
        List<List<String>> ret = circulate(result);

        for (List<String> list : ret) {
            StringBuilder sb = new StringBuilder();
            for (String s : list) {
                sb.append(s).append("/");
            }
            System.out.println(sb.deleteCharAt(sb.length() - 1));
        }
        System.out.println(ret.size());
    }


}
