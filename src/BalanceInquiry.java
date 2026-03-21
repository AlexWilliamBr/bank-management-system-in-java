import java.io.File;
import java.io.IOException;
import java.util.Scanner;


        }
        if (accBalance == -1) {
            System.out.println("We're having some issues, Try Again!");
            System.exit(0);
        } else {
            System.out.println("┌───────────────────────────────┐");
            System.out.println("  Your current balance is $"+ accBalance +"   ");
            System.out.println("└───────────────────────────────┘");
            System.out.println("Press Enter key to continue...");
            Scanner scanner1 = new Scanner(System.in);
            scanner1.nextLine();
            Main.menu(accNo);
        }
    }
}
