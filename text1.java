import java.util.Scanner;
public class text1 {
    public static void main(String[] args) {
        Password password=new Password();
        System.out.println("请输入需要加密的字符串：");
        Scanner reader=new Scanner(System.in);
        String encrypt=reader.next();
        if(encrypt.length()<16){
            password.encrypt(encrypt);
        }
        else
            System.out.println("输入字符串超出长度限制！");
        System.out.println("请输入需要解密的字符串：");
        Scanner reader1=new Scanner(System.in);
        String decipher=reader1.next();
        if(decipher.length()<16){
            password.decipher(decipher);
        }
        else
            System.out.println("输入字符串超出长度限制！");
    }
}
class Password{

    public void encrypt(String encrypt){
        char password[]=new char[encrypt.length()];
        for(int i=0;i<encrypt.length();i++){
            char a=encrypt.charAt(i);
            byte byteAscii=(byte) a;
            byteAscii+=i;
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
    public void decipher(String decipher){
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
            byteAscii-=i;
            byteAscii-=3;
            password[i]=(char)byteAscii;
        }
        for(int i=0;i< password.length;i++){
            System.out.print(password[i]);
        }
    }
}