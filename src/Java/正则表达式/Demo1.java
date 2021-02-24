package Java.正则表达式;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: hcb
 * @Date: 2021/2/2 11:24
 * @Version 1.0
 */
public class Demo1 {
    public static void main(String[] args) {

       /* String content = "I am noob" + "from runoob.com.";
        String pattern = ".*runoob.*";
        boolean isMatch = Pattern.matches(pattern,content);
        System.out.println(isMatch);
        //捕获组
        String line = "This order was placed for QT3000! OK?";
        String pa = "(\\D*)(\\d+)(.*)";
        Pattern r = Pattern.compile(pa);
        Matcher m = r.matcher(line);
        if (m.find()) {
            System.out.println(m.group(0));
            System.out.println(m.group(1));
            System.out.println(m.group(2));
            System.out.println(m.group(3));
        } else {
            System.out.println("NO MATCH");
        }*/
        String line = "ooooo";
        String regx = "o+";
        Pattern pattern = Pattern.compile(regx);
        boolean isMatch = Pattern.matches(regx,line);
        System.out.println(isMatch);
    }
}
