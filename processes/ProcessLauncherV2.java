package processes;

import java.io.IOError;
import java.io.IOException;

public class ProcessLauncherV2 {
    public static void main(String[] args) {
        if(args.length != 1) {
            System.out.print("Uso: java ProcessLauncherV2 [executavel]");
            System.exit(1);
        }
        ProcessBuilder processBuilder = new ProcessBuilder(args[0]);
        try {
            Process process = processBuilder.start();
            process.waitFor();
        } catch(IOException e) {
            e.printStackTrace();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Process Launcher finalizado");
    }
}
