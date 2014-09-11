import java.util.Scanner;

public class KeybordInput {

    public KeybordInput(PiFaceLogic pi) {

        Scanner scanner = new Scanner(System.in);
        String keybordInputString;
        Command command = Command.HELP;

        while (!command.equals(Command.QUIT)) {

            keybordInputString = scanner.nextLine();
            command = Command.parseCommand(keybordInputString);
            pi.doCommand(command);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        scanner.close();
    }

}
