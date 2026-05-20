import java.util.Scanner;
public class VigenereCipher {
    Scanner sc = new Scanner(System.in);
    String str_in,key;
    StringBuilder str_out;
    VigenereCipher() {
        str_in = "";
        key = "0";
    }
    public void input() {
        System.out.println("Enter a string:");
        str_in = sc.nextLine();
        System.out.println("Enter a key:");
        key = sc.nextLine();
        str_out = new StringBuilder(str_in.length());
    }
    public void validity() {
        if(key.isEmpty()) {
            System.out.println("Key cannot be empty");
            System.exit(0);
        }
        key = key.repeat((str_in.length()/key.length())+1).substring(0,str_in.length());    
    }
    public void choose() {
        System.out.println("----MENU----");
        System.out.println("1. Encrypt\n2. Decrypt");
        switch (sc.nextInt()) {
            case 1 -> Encrypt();
            case 2 -> Decrypt();
            default -> {
                System.out.println("Invalid choice");
                System.exit(0);
            }
        }
        sc.close();
    }
    public void display() {
        System.out.println("Output: " + str_out.toString());
    }
    public void Encrypt() {
        for(int i = 0; i < str_in.length(); i++) 
            str_out.append((char)((str_in.charAt(i)+key.charAt(i)-64)%95+32));    
       
    }
    public void Decrypt() {
        for(int i = 0; i < str_in.length(); i++)
            str_out.append((char)((str_in.charAt(i)-key.charAt(i)+95)%95+32));    
    }
    public static void main(String[] args) {
        VigenereCipher obj = new VigenereCipher();
        obj.input();
        obj.validity();
        obj.choose();
        obj.display();
    }
}
