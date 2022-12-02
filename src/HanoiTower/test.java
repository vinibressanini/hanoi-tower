package HanoiTower;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {

        Scanner scanner  = new Scanner(System.in);

        TowerController controller = new TowerController();

        if (args.length == 0) {
            System.out.println("Informe o tipo de implementação (dinamica ou contigua)");
            return;
        }

        controller.startGame(args[0], Integer.parseInt(args[1]));
        controller.populateTower();

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
