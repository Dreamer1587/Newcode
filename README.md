import java.util.regex.*;

public class MyClass {
    public static void main(String args[]) {
        
        String s= "string1234more567string890";
        Pattern p=Pattern.compile("\\d+");
        Matcher m = p.matcher(s);
        
        while(m.find()) {
            System.out.println(m.group());
        
        }
      
    }
    }
