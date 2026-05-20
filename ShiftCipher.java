import java.util.Scanner;
public class ShiftCipher {
    Scanner sc = new Scanner(System.in);
    String str_in;
    StringBuilder str_out;
    int key;
    ShiftCipher() {
        str_in = "";
        str_out = new StringBuilder();
        key = 0;
    }
    public void input() {
        System.out.println("Enter a string:");
        str_in = sc.nextLine();
        System.out.println("Enter a key:");
        int raw_key = sc.nextInt();
        key = (raw_key % 95 + 95) % 95;
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
        for (char c : str_in.toCharArray())
            if (c >= 32 && c <= 126) 
                str_out.append((char) ((c - 32 + key) % 95 + 32));
            else
                str_out.append(c);
    }
    public void Decrypt() {
        for (char c : str_in.toCharArray())
            if (c >= 32 && c <= 126)
                str_out.append((char) ((c - 32 - key + 95) % 95 + 32));
            else
                str_out.append(c);
    }
    public static void main(String[] args) {
        ShiftCipher obj = new ShiftCipher();
        obj.input();
        obj.choose();
        obj.display();
    }
}