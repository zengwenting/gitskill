import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Random;

public class encrypt {
    public static void main(String[] args) {
        boolean temp=false;
        while (temp=true){
            Password password=new Password();
            System.out.println("\n==============================\n" +
                    "欢迎使用密码管理系统\n" +
                    "==============================");
            System.out.println("请选择操作：\n" +
                    "1. 加密\n" +
                    "2. 解密\n" +
                    "3. 判断密码强度（第三周任务添加）\n" +
                    "4. 密码生成（第三周任务添加）\n" +
                    "5. 退出");
            System.out.print("\n请输入选项序号：");
            Scanner reader=new Scanner(System.in);
            int a=reader.nextInt();
            switch (a){
                case 1:
                    System.out.println("\n请输入需要加密的密码：");
                    Scanner reader1=new Scanner(System.in);//输入加密字符串
                    String encrypt=reader1.next();
                    System.out.print("加密后的结果是：");
                    password.encrypt(encrypt);
                    System.out.println("\n按任意键返回");
                    Scanner input=new Scanner(System.in);
                    if(input.hasNext()){
                        temp=false;
                    }
                    break;
                case 2:
                    System.out.println("\n请输入要解密的密码：");
                    Scanner reader2=new Scanner(System.in);//输入解密字符串
                    String decipher=reader2.next();
                    password.decipher(decipher);
                    System.out.println("\n按任意键返回");
                    Scanner input1=new Scanner(System.in);
                    if(input1.hasNext()){
                        temp=false;
                    }
                    break;
                case 3:
                    System.out.println("\n请输入要判断强度的密码：");
                    Scanner reader3=new Scanner(System.in);//输入判断强度字符串
                    String pw=reader3.next();
                    password.isStringPwd(pw);
                    System.out.println("\n按任意键返回");
                    Scanner input2=new Scanner(System.in);
                    if(input2.hasNext()){
                        temp=false;
                    }
                    break;
                case 4:

                    PasswordGenerator newPassword=new PasswordGenerator();
                    System.out.print("\n按任意键返回");
                    Scanner input3=new Scanner(System.in);
                    if(input3.hasNext()){
                        temp=false;
                    }
                    break;
                case 5:
                    System.out.println("正在退出...");
                    temp=true;
                    System.exit(0);
            }
        }
    }
}
class Password{

    public void encrypt(String encrypt){//加密
        if(encrypt.length()<16){//判断字符串长度
            char password[]=new char[encrypt.length()];
            for(int i=0;i<encrypt.length();i++){
                char a=encrypt.charAt(i);
                byte byteAscii=(byte) a;
                byteAscii+=(i+1);
                byteAscii+=3;
                password[i]= (char)byteAscii;
            }
            char b;
            b=password[0];
            password[0]=password[password.length-1];
            password[password.length-1]=b;
            char psw[]=new char[password.length];
            for(int i=0;i< password.length;i++){
                psw[i]=password[password.length-i-1];
                System.out.print(psw[i]);
            }
        }
        else
            System.out.println("输入字符串超出长度限制！");
    }
    public void decipher(String decipher){//解密
        if(decipher.length()<16){//判断字符串长度
            char password[]=new char[decipher.length()];
            for(int i=0;i<decipher.length();i++){
                password[i]=decipher.charAt(password.length-i-1);
            }
            char a;
            a=password[0];
            password[0]=password[password.length-1];
            password[password.length-1]=a;
            for(int i=0;i<password.length;i++){
                byte byteAscii=(byte) password[i];
                byteAscii-=(i+1);
                byteAscii-=3;
                password[i]=(char)byteAscii;
            }
            for(int i=0;i< password.length;i++){
                System.out.print(password[i]);
            }
        }
        else
            System.out.println("输入字符串超出长度限制！");
    }
    public void isStringPwd(String password){
        Map<String,String> map=new HashMap<String,String>();
        for(int i=0;i<password.length();i++){
            int A=password.charAt(i);
            if(A>=48&&A<=57){
                map.put("数字","数字");
            } else if (A>=65&&A<=90) {
                map.put("大写","大写");
            } else if (A>=97&&A<=122) {
                map.put("小写","小写");
            }else{
                map.put("特殊","特殊");
            }
        }
        Set<String> sets=map.keySet();
        int pwdSize= sets.size();
        int pwdLength=password.length();
        if(pwdSize>=4&&pwdLength>=8){
            System.out.println("强密码");
        }else {
            System.out.println("弱密码");
        }
    }
}
class PasswordGenerator{
    private static final String lowercase="abcdefghyjklnmopqrstuvwxyz";
    private static final String uppercase="ABCDEFGHYJKLNMOPQRSTUVWXYZ";
    private static final String number="123456789";
    private static final String special="!@#$%^&*()<>?";
    static Random random=new Random();
    public  PasswordGenerator(){
        int length=random.nextInt(16);
        String password=generatePassword(length);
        System.out.print("生成新密码是："+password.toString());
    }
    public static String generatePassword(int length){
        StringBuilder password=new StringBuilder();
        for(int i=0;i<length;i++){
            int charSetIndex=random.nextInt(4);
            switch (charSetIndex){
                case 0:
                    password.append(lowercase.charAt(random.nextInt(lowercase.length())));
                    break;
                case 1:
                    password.append(uppercase.charAt(random.nextInt(uppercase.length())));
                    break;
                case 2:
                    password.append(number.charAt(random.nextInt(number.length())));
                    break;
                case 3:
                    password.append(special.charAt(random.nextInt(special.length())));
                    break;
            }
        }
        return password.toString();
    }
}
