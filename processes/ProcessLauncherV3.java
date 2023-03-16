package processes;

import java.io.IOException;

public class ProcessLauncherV3 {
    public static void main(String[] args) {
        if(args.length != 1) {
            System.out.println("uso: java ProcessLauncherV3 [executavel]");
            System.exit(1);
        }
        ProcessBuilder processBuilder = new ProcessBuilder(args[0]);
        try{
            Process process = processBuilder.start();
            Thread.sleep(3000);
            process.destroy();
            if(process.isAlive()) {
                System.out.println("Forçando a finalização do processo!");
                process.destroyForcibly();
            }
        } catch(IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Launcher finalizado!");
    }
}
