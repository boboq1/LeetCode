package LeetCode.日期之间隔几天;

/**
 * @author Admin
 * @version 1.0
 * @date 2020/2/23 10:34
 */
public class Solution {
    public int daysBetweenDates(String date1, String date2) {

        int days = 0;
        String[] dateTime1 = date1.split("-");
        String[] dateTime2 = date2.split("-");
        if (date1.equals(date2))return 0;
        if (dateTime1[0].equals(dateTime2[0])&&dateTime1[1].equals(dateTime2[1])){
            return Math.abs(Integer.parseInt(dateTime1[2])-Integer.parseInt(dateTime2[2]));
        }
        if (dateTime1[0].equals(dateTime2[0])){
           if (Integer.parseInt(dateTime1[1])>Integer.parseInt(dateTime2[1])){
               for (int i=Integer.parseInt(dateTime2[1]);i<Integer.parseInt(dateTime1[1]);i++){
                   days += switchMonth(Integer.parseInt(dateTime1[0]),i);
               }
               return days - Integer.parseInt(dateTime2[2])+Integer.parseInt(dateTime1[2]);
           }else {
               for (int i=Integer.parseInt(dateTime1[1]);i<Integer.parseInt(dateTime2[1]);i++){
                   days += switchMonth(Integer.parseInt(dateTime2[0]),i);
               }
               return days - Integer.parseInt(dateTime1[2])+Integer.parseInt(dateTime2[2]);
           }

        }
        if (!dateTime1[0].equals(dateTime2[0])){
            days = 0;
            if (Integer.parseInt(dateTime1[0])>Integer.parseInt(dateTime2[0])){
                int yearDays = 0;
                for (int a=Integer.parseInt(dateTime2[0])+1;a<Integer.parseInt(dateTime1[0]);a++){
                    yearDays += ((a%4==0&&a%100!=0)||a%400==0)?366:365;
                }
                for (int i=Integer.parseInt(dateTime2[1]);i<=12;i++){
                    days += switchMonth(Integer.parseInt(dateTime2[0]),i);
                }
                days = days - Integer.parseInt(dateTime2[2]);
                for (int i=1;i<Integer.parseInt(dateTime1[1]);i++){
                    days += switchMonth(Integer.parseInt(dateTime1[0]),i);
                }
                return days + Integer.parseInt(dateTime1[2])+yearDays;
            }else {
                int yeDays = 0;
                for (int a=Integer.parseInt(dateTime1[0])+1;a<Integer.parseInt(dateTime2[0]);a++){
                    yeDays += ((a%4==0&&a%100!=0)||a%400==0)?366:365;
                }
                for (int i=Integer.parseInt(dateTime1[1]);i<=12;i++){
                    days += switchMonth(Integer.parseInt(dateTime1[0]),i);
                }
                days = days - Integer.parseInt(dateTime1[2]);
                for (int i=1;i<Integer.parseInt(dateTime2[1]);i++){
                    days += switchMonth(Integer.parseInt(dateTime2[0]),i);
                }
                return days + Integer.parseInt(dateTime2[2])+yeDays;
            }
        }
        return 0;
    }
    public int switchMonth(int year,int month){
        switch (month){
            case 1:
                return 31;
            case 2:
                return ((year%4==0&&year%100!=0)||year%400==0)?29:28;
            case 3:
                return 31;
            case 4:
                return 30;
            case 5:
                return 31;
            case 6:
                return 30;
            case 7:
                return 31;
            case 8:
                return 31;
            case 9:
                return 30;
            case 10:
                return 31;
            case 11:
                return 30;
            case 12:
                return 31;
        }
        return 0;
    }
    public static void main(String[] args){
      int sum = new Solution().daysBetweenDates("2019-06-29","2019-06-30");
        System.out.println(sum);
    }
}
