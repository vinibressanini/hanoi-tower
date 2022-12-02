package Game;

import HanoiTower.TowerController;

import java.util.Arrays;
import java.util.Scanner;

public class GameStarter {

    public static void startGame(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        TowerController controller = new TowerController();

        if (args.length == 0) {
            System.out.println("Informe o tipo de implementação (dinamica ou contigua)");
            return;
        } else if (args.length > 1 && Integer.parseInt(args[1]) <= 0) {
            System.out.println("Informe um número de discos válido");
            return;
        } else if (!args[0].equals("dinamica") && !args[0].equals("contigua")) {
            System.out.println("Argumento " + args[0] + " inválido (ex: dinamica ou contigua)");
            return;
        } else if  (args.length > 1 && Integer.parseInt(args[1]) > 0) {
            controller.startGame(args[0], Integer.parseInt(args[1]));
            controller.populateTower();
        } else {
            controller.startGame(args[0]);
            controller.populateTower();
        }

        do {
            int origin = 0;
            int destiny = 0;
            System.out.println(controller.getTowers());
            System.out.println("\nDe qual torre você deseja retirar um disco?\n");
            origin = scanner.nextInt();
            System.out.println("\nPara qual torre você deseja mover o disco?\n");
            destiny = scanner.nextInt();
            controller.moveDisc(origin,destiny);

        } while (!controller.endGame());

        System.out.println(controller.getTowers());
        System.out.println(controller.getPlayerTotalMoves());
    }
}
