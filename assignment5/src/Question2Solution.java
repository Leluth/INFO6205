import java.util.HashMap;
import java.util.Map;

/**
 * @author Shaoshuai Xu
 * @version 1.0
 * @description: Question2Solution
 * @date 2021/10/12 18:46
 */
public class Question2Solution {
    public static void main(String[] args) {
        Question2Solution solution = new Question2Solution();
        System.out.println(solution.reformatDate("20th Oct 2052"));
        System.out.println(solution.reformatDate("8th Jun 1933"));
        System.out.println(solution.reformatDate("26th May 1960"));
    }

    // n is the length of date
    // Time: O(n)
    // Space: O(1)
    public String reformatDate(String date) {
        StringBuilder sb = new StringBuilder();
        Map<String, String> map = new HashMap<>();
        map.put("Jan", "01");
        map.put("Feb", "02");
        map.put("Mar", "03");
        map.put("Apr", "04");
        map.put("May", "05");
        map.put("Jun", "06");
        map.put("Jul", "07");
        map.put("Aug", "08");
        map.put("Sep", "09");
        map.put("Oct", "10");
        map.put("Nov", "11");
        map.put("Dec", "12");
        sb.append(date.substring(date.length() - 4));
        sb.append('-');
        sb.append(map.get(date.substring(date.length() - 8, date.length() - 5)));
        sb.append('-');
        if(Character.isDigit(date.charAt(1))) {
            sb.append(date, 0, 2);
        } else {
            sb.append('0');
            sb.append(date.charAt(0));
        }

        return sb.toString();
    }
}
