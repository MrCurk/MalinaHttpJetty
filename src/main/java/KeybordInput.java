import java.util.Scanner;

public class KeybordInput implements Runnable {

    private PiFaceLogic pi;

    public KeybordInput(PiFaceLogic pi) {
        this.pi = pi;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        String keybordInputString;
        Command command = Command.HELP;

        while (!command.equals(Command.QUIT)) {

            keybordInputString = scanner.nextLine();
            command = Command.parseCommand(keybordInputString);
            pi.doCommand(command);
        }

        scanner.close();
    }
}
