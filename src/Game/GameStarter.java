package Game;

import HanoiTower.TowerController;

import java.util.Scanner;

public class GameStarter {

    public static void startGame(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        TowerController controller = new TowerController();
        short origin, destiny;

        if (args.length == 0) {
            System.out.println("Informe o tipo de implementação (dinamica ou contigua)");
            return;
        } else if(args.length == 1 && args[0].equals("sobre")) {
            System.out.println("Vinícius Marcus Bressanini e Victor Bachmann Lueders");
            return;
        }
        else if (args.length == 1) {
            try {
                controller.startGame(args[0]);
                controller.populateTower();
            } catch (NullPointerException ex) {
                System.out.println("Argumento Inválido! Opções válidas dinamica ou contigua");
                return;
            }
        }else {
            try {
                controller.startGame(args[0], Short.parseShort(args[1]));
                controller.populateTower();
            } catch (NumberFormatException ex) {
                System.out.println("Argumento Inválido! Informe um número de discos válido");
                return;
            } catch (NullPointerException ex) {
                System.out.println("Argumento Inválido! Opções válidas dinamica ou contigua");
                return;
            }
        }

        do {
            System.out.println(controller.getTowers());
            System.out.println("\nDe qual torre você deseja retirar um disco?\n");
            origin = scanner.nextShort();
            System.out.println("\nPara qual torre você deseja mover o disco?\n");
            destiny = scanner.nextShort();
            controller.moveDisc(origin,destiny);

        } while (!controller.endGame());

        System.out.println(controller.getTowers());
        System.out.println(controller.getPlayerTotalMoves());
    }
}
