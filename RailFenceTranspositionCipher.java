import java.util.Scanner;
public class RailFenceTranspositionCipher {
    Scanner sc=new Scanner(System.in);
    String str_in;
    StringBuilder str_out;
    RailFenceTranspositionCipher(){
        str_in="";
        str_out=new StringBuilder();
    }
    void input(){
        System.out.println("Enter the string");
        str_in=sc.nextLine();
        str_out=new StringBuilder(str_in.length());
    }
    void choose() {
        System.out.println("1. Encrypt\n2. Decrypt");
        switch (sc.nextInt()) {
            case 1->encrypt();
            case 2->decrypt();
            default->System.out.println("Invalid choice");
        }
        sc.close();
    }
    void encrypt() {
        for(int i=0;i<str_in.length();i+=2){
            str_out.append(str_in.charAt(i));
        }
        for(int i=1;i<str_in.length();i+=2){
            str_out.append(str_in.charAt(i));
        }
    }
    void decrypt() {
        int i=0;
        for(int j=(str_in.length()+1)/2;i<(str_in.length()+1)/2 && j<str_in.length();i++,j++) {
            str_out.append(str_in.charAt(i));
            str_out.append(str_in.charAt(j));
        }
        if(i<(str_in.length()+1)/2){
            str_out.append(str_in.charAt(i));
        }
    }
    void display(){
        System.out.println("Output: "+str_out);
    }
    public static void main(String[] args) {
        RailFenceTranspositionCipher obj=new RailFenceTranspositionCipher();
        obj.input();
        obj.choose();
        obj.display();
    }
}
