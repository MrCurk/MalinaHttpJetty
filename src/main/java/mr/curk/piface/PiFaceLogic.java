package mr.curk.piface;

import com.pi4j.component.switches.SwitchListener;
import com.pi4j.component.switches.SwitchState;
import com.pi4j.component.switches.SwitchStateChangeEvent;
import com.pi4j.device.piface.PiFace;
import com.pi4j.device.piface.PiFaceSwitch;
import com.pi4j.device.piface.impl.PiFaceDevice;
import com.pi4j.wiringpi.Spi;

import java.io.IOException;

public class PiFaceLogic implements Runnable {

    final private PiFace piface;
    private boolean runningCondition;
    private Command command;

    public PiFaceLogic() throws IOException {

        System.out.println("PiFace started!");
        piface = new PiFaceDevice(PiFace.DEFAULT_ADDRESS, Spi.CHANNEL_0);

        setOutputAllOff();
        runningCondition = true;
        command = Command.HELP;

        // S1 listener
        piface.getSwitch(PiFaceSwitch.S1).addListener(new SwitchListener() {
            @Override
            public void onStateChange(SwitchStateChangeEvent event) {
                if (event.getNewState() == SwitchState.ON) {
                    System.out.println("S1: ON!");

                }
                if (event.getNewState() == SwitchState.OFF) {
                    System.out.println("S1: OFF!");
                }
            }
        });

        // S2 listener
        piface.getSwitch(PiFaceSwitch.S2).addListener(new SwitchListener() {
            @Override
            public void onStateChange(SwitchStateChangeEvent event) {
                if (event.getNewState() == SwitchState.ON) {
                    System.out.println("S2: ON!");
                }
                if (event.getNewState() == SwitchState.OFF) {
                    System.out.println("S2: OFF!");
                }
            }
        });

        // S3 listener
        piface.getSwitch(PiFaceSwitch.S3).addListener(new SwitchListener() {
            @Override
            public void onStateChange(SwitchStateChangeEvent event) {
                if (event.getNewState() == SwitchState.ON) {
                    System.out.println("S3: ON!");
                }
                if (event.getNewState() == SwitchState.OFF) {
                    System.out.println("S3: OFF!");
                }
            }
        });

        // S4 listener
        piface.getSwitch(PiFaceSwitch.S4).addListener(new SwitchListener() {
            @Override
            public void onStateChange(SwitchStateChangeEvent event) {
                if (event.getNewState() == SwitchState.ON) {
                    System.out.println("S4: ON!");
                }
                if (event.getNewState() == SwitchState.OFF) {
                    System.out.println("S4: OFF!");
                }
            }
        });

    }

    @Override
    public void run() {

        while (runningCondition) {

            if (!command.equals(Command.WAITING)) {

                switch (command) {
                    case OP0_ON:
                        setOutputOn(0);
                        break;
                    case OP1_ON:
                        setOutputOn(1);
                        break;
                    case OP2_ON:
                        setOutputOn(2);
                        break;
                    case OP3_ON:
                        setOutputOn(3);
                        break;
                    case OP4_ON:
                        setOutputOn(4);
                        break;
                    case OP5_ON:
                        setOutputOn(5);
                        break;
                    case OP6_ON:
                        setOutputOn(6);
                        break;
                    case OP7_ON:
                        setOutputOn(7);
                        break;
                    case OP0_OFF:
                        setOutputOff(0);
                        break;
                    case OP1_OFF:
                        setOutputOff(1);
                        break;
                    case OP2_OFF:
                        setOutputOff(2);
                        break;
                    case OP3_OFF:
                        setOutputOff(3);
                        break;
                    case OP4_OFF:
                        setOutputOff(4);
                        break;
                    case OP5_OFF:
                        setOutputOff(5);
                        break;
                    case OP6_OFF:
                        setOutputOff(6);
                        break;
                    case OP7_OFF:
                        setOutputOff(7);
                        break;
                    case STATUS:
                        displayStatusAll();
                        break;
                    case QUIT:
                        shutdownPiFace();
                        break;
                    case HELP:
                    default:
                        printHelp();
                        break;
                }

                command = Command.WAITING;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("PiFace shutdown!");
        System.exit(1);
    }
//public
    public String getStatusInputOutput(int i) {
        return  "input " + i + " : " + getStatusInput(i) + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;output " + i + " : " + getStatusOutput(i);
    }

    public void doCommand(Command command) {
        this.command = command;
    }

// public end
    private void displayStatusAll() {

        for (int i = 0; i < 8; i++) {
            System.out.println("input " + i + " : " + getStatusInput(i)
                    + "\t output " + i + " : " + getStatusOutput(i));
        }

    }

    private String getStatusOutput(int i) {
        if (piface.getOutputPin(i).isHigh()) {
            return "On";
        } else {
            return "Off";
        }
    }

    private String getStatusInput(int i) {
        if (piface.getInputPin(i).isLow()) {
            return "On";
        } else {
            return "Off";
        }
    }

    private void setOutputOn(int i) {
        piface.getOutputPin(i).high();
    }

    private void setOutputOff(int i) {
        piface.getOutputPin(i).low();
    }

    private void setOutputAllOff() {
        for (int i = 0; i < 8; i++) {
            setOutputOff(i);
        }

    }

    private void printHelp() {
        System.out.println("op[0-7] on - turn output n on.");
        System.out.println("op[0-7] off - turn output n off.");
        System.out.println("status -  display status of inputs and outputs ");
        System.out.println("s -  display status of inputs and outputs ");
        System.out.println("q - exit");
        System.out.println("exit - exit");

    }

    private void shutdownPiFace() {
        runningCondition = false;
        setOutputAllOff();
    }

}
