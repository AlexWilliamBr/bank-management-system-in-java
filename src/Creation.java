import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;


public class Creation {


    void createAccFun() throws IOException {// aqui é uma notificação que o cadrasto deu certo
        int accNo = accNoCreation();
        User accLineInfo = getUserInfoFromUser();
        credWrite(accNo, accLineInfo.senha);
        balWrite(accNo);
        userWrite(accNo, accLineInfo);
        System.out.println("\nAccount created successfully!\n");
        System.out.println("Your account number is: " + accNo);
        System.out.println("Your password is: " + accLineInfo.senha+"\n");
        Main.menu(accNo);

    }

      User getUserInfoFromUser() throws IOException {
        Scanner scanner = new Scanner(System.in);
        User user = new User();

        System.out.println("Enter your Name: ");
        String fullName = scanner.nextLine();
        String[] fullNameArr = fullName.split(" ");
        if (fullNameArr.length == 2) {
            user.nome = fullNameArr[0];
            user.sobrenome = fullNameArr[1];
        } else {
            System.out.println("Please provide both first name and last name.");
            return getUserInfoFromUser();
        }


        System.out.println("Enter your Date of Birth (YYYY-MM-DD): ");
        user.dataNascimento = scanner.nextLine();

        System.out.println("Enter your Gender: ");
        user.genero = scanner.nextLine();

        System.out.println("Enter your Address: ");
        user.endereco = scanner.nextLine();

        System.out.println("Enter your Phone Number: ");
        user.telefone = scanner.nextLine();

        System.out.println("Enter your Email: ");
        user.email = scanner.nextLine();

        System.out.println("Enter your Citizenship Number: ");
        user.documento = scanner.nextLine();

        System.out.println("Create a Password for your Account: ");
        user.senha  = scanner.nextLine();
        return user;
        }

    int accNoCreation() throws IOException {
        String lastLine = "";
        int accNo;
        File file = new File("db/credentials.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            lastLine = scanner.nextLine();
        }
        if (Objects.equals(lastLine, "")) {
            accNo = 1;
        } else {
            String[] subLine = lastLine.split(" ");
            accNo = Integer.parseInt(subLine[0]);
            accNo++;
        }
        return accNo;
    }

    void credWrite(int accNo, String senha) throws IOException {
        FileWriter writer = new FileWriter("db/credentials.txt", true);
        writer.write("\n" + accNo + " " + senha);
        writer.close();
    }

    void balWrite(int accNo) throws IOException {
        int initialBal = 69;
        FileWriter writer = new FileWriter("db/balanceDB.txt", true);
        writer.write("\n" + accNo + " " + initialBal);
        writer.close();
    }

    void userWrite(int accNo,  User accLineInfo) throws IOException {
        FileWriter writer = new FileWriter("db/userDB.txt", true);
        writer.write("\n" + accNo + " ");
        writer.write(accLineInfo.nome + " ");
        writer.write(accLineInfo.sobrenome + " ");
        writer.write(accLineInfo.dataNascimento + " ");
        writer.write(accLineInfo.genero + " ");
        writer.write(accLineInfo.endereco + " ");
        writer.write(accLineInfo.telefone + " ");
        writer.write(accLineInfo.email + " ");
        writer.write(accLineInfo.documento + " ");
    }


}

