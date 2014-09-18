package mr.curk.piface;

public enum Command {
    OP0_ON, OP0_OFF, OP1_ON, OP1_OFF, OP2_ON, OP2_OFF, OP3_ON, OP3_OFF, OP4_ON, OP4_OFF, OP5_ON, OP5_OFF, OP6_ON, OP6_OFF, OP7_ON, OP7_OFF, HELP, QUIT, STATUS,WAITING;

    public static Command parseCommand(String command) {
        String commandUpper = command.toUpperCase();
        if (commandUpper.equals("OP0 ON")) {
            return OP0_ON;
        }
        else if (commandUpper.equals("OP0 OFF")) {
            return OP0_OFF;
        } else if (commandUpper.equals("OP1 ON")) {
            return OP1_ON;
        } else if (commandUpper.equals("OP1 OFF")) {
            return OP1_OFF;
        } else if (commandUpper.equals("OP2 ON")) {
            return OP2_ON;
        } else if (commandUpper.equals("OP2 OFF")) {
            return OP2_OFF;
        } else if (commandUpper.equals("OP3 ON")) {
            return OP3_ON;
        } else if (commandUpper.equals("OP3 OFF")) {
            return OP3_OFF;
        } else if (commandUpper.equals("OP4 ON")) {
            return OP4_ON;
        } else if (commandUpper.equals("OP4 OFF")) {
            return OP4_OFF;
        } else if (commandUpper.equals("OP5 ON")) {
            return OP5_ON;
        } else if (commandUpper.equals("OP5 OFF")) {
            return OP5_OFF;
        } else if (commandUpper.equals("OP6 ON")) {
            return OP6_ON;
        } else if (commandUpper.equals("OP6 OFF")) {
            return OP6_OFF;
        } else if (commandUpper.equals("OP7 ON")) {
            return OP7_ON;
        } else if (commandUpper.equals("OP7 OFF")) {
            return OP7_OFF;
        } else if (commandUpper.equals("STATUS") || commandUpper.equals("S")) {
            return STATUS;
        } else if (commandUpper.equals("Q") || commandUpper.equals("EXIT")) {
            return QUIT;
        } else {
            return HELP;
        }
    }
}
