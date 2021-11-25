import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Login {
   static Scanner sc = new Scanner(System.in);

   public static void main(String[] args) throws IOException {
       String username, password;
       String fuserName, fpassword;
       int choice;
       File f = new File("F:\\records.txt");
       FileWriter fw = null;

       while (true) {

           System.out.println("\n1.Register");
           System.out.println("2.Login");
           System.out.println("3.Exit");
           System.out.print("Enter Choice: ");
           choice = sc.nextInt();
           switch (choice) {
           case 1: {

               System.out.print("Enter Username :");
               username = getValue();

               System.out.print("Enter Password :");
               password = sc.next();

               fw = new FileWriter(f, true);
               fw.write(username + " " + password + "\n");
               fw.close();

               System.out.println("You have registered successfully!");
               continue;

           }
              case 2: {
    
                System.out.print("Enter Username :");
                username = getValue();
    
                System.out.print("Enter Password :");
                password = sc.next();
    
                Scanner sc = new Scanner(f);
                while (sc.hasNext()) {
                     fuserName = sc.next();
                     fpassword = sc.next();
                     if (username.equals(fuserName) && password.equals(fpassword)) {
                          System.out.println("Successfully logged in!");
                          System.out.println("Thank you for using our service!");
                          return;
                     }
                }
                System.out.println("Incorrect username or password!");
                continue;
    
              }
                case 3: {
                    System.out.println("Thank you for using our service!");
                    System.exit(0);
                }
                default: {
                    System.out.println("Invalid choice!");
                    continue;
                }
           }
        }
    }
    static String getValue() throws IOException {
        String value = "";
        char ch;
        do {
            ch = (char) System.in.read();
            if (Character.isLetterOrDigit(ch)) {
                value += ch;
            }
        } while (ch != '\n');
        return value;
    }
}
