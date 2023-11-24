import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
//<<<<<<< HEAD:encrypt/src/Main.java
import java.util.Set;
import java.util.Random;

public class Main {
    //=======
    public class text1 {
        //修改合作同学的代码
//>>>>>>> 0c391502cff2a016ac8c0f5c092844dbce0589a3:text1.java
        public void main(String[] args) {
            PasswordGenerator1 newPassword = new PasswordGenerator1();
            Password1 password = new Password1();
            System.out.println("请输入需要加密的字符串：");
            Scanner reader = new Scanner(System.in);//输入加密字符串
            String encrypt = reader.next();
            if (encrypt.length() < 16) {//判断字符串长度
                password.encrypt(encrypt);
                password.isStringPwd(encrypt);
            } else
                System.out.println("输入字符串超出长度限制！");
            System.out.println("请输入需要解密的字符串：");
            Scanner reader1 = new Scanner(System.in);//输入解密字符串
            String decipher = reader1.next();
            if (decipher.length() < 16) {//判断字符串长度
                password.decipher(decipher);
                password.isStringPwd(decipher);
            } else
                System.out.println("输入字符串超出长度限制！");
        }
    }

    class Password1 {

        public void encrypt(String encrypt) {//加密
            char password[] = new char[encrypt.length()];
            for (int i = 0; i < encrypt.length(); i++) {
                char a = encrypt.charAt(i);
                byte byteAscii = (byte) a;
                byteAscii += (i + 1);
                byteAscii += 3;
                password[i] = (char) byteAscii;
            }
            char b;
            b = password[0];
            password[0] = password[password.length - 1];
            password[password.length - 1] = b;
            char psw[] = new char[password.length];
            for (int i = 0; i < password.length; i++) {
                psw[i] = password[password.length - i - 1];
                System.out.print(psw[i]);
            }
        }

        public void decipher(String decipher) {//解密
            char password[] = new char[decipher.length()];
            for (int i = 0; i < decipher.length(); i++) {
                password[i] = decipher.charAt(password.length - i - 1);
            }
            char a;
            a = password[0];
            password[0] = password[password.length - 1];
            password[password.length - 1] = a;
            for (int i = 0; i < password.length; i++) {
                byte byteAscii = (byte) password[i];
                byteAscii -= (i + 1);
                byteAscii -= 3;
                password[i] = (char) byteAscii;
            }
            for (int i = 0; i < password.length; i++) {
                System.out.print(password[i]);
            }
        }

        public void isStringPwd(String password) {
            Map<String, String> map = new HashMap<String, String>();
            for (int i = 0; i < password.length(); i++) {
                int A = password.charAt(i);
                if (A >= 48 && A <= 57) {
                    map.put("数字", "数字");
                } else if (A >= 65 && A <= 90) {
                    map.put("大写", "大写");
                } else if (A >= 97 && A <= 122) {
                    map.put("小写", "小写");
                } else {
                    map.put("特殊", "特殊");
                }
            }
            Set<String> sets = map.keySet();
            int pwdSize = sets.size();
            int pwdLength = password.length();
            if (pwdSize >= 4 && pwdLength >= 8) {
                System.out.println("强密码");
            } else {
                System.out.println("弱密码");
            }
        }
    }

    public class PasswordGenerator1 {
        private static final String lowercase = "abcdefghyjklnmopqrstuvwxyz";
        private static final String uppercase = "ABCDEFGHYJKLNMOPQRSTUVWXYZ";
        private static final String number = "123456789";
        private static final String special = "!@#$%^&*()<>?";
        static Random random = new Random();

        public PasswordGenerator1() {
            int length = random.nextInt(16);
            String password = generatePassword(length);
            System.out.println("生成新密码是：" + password);
        }

        public static String generatePassword(int length) {
            StringBuilder password = new StringBuilder();
            for (int i = 0; i < length; i++) {
                int charSetIndex = random.nextInt(4);
                switch (charSetIndex) {
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
            System.out.println(password.toString());
            return password.toString();
        }
    }
}
