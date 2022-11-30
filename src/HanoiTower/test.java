package HanoiTower;

public class test {
    public static void main(String[] args) {

        TowerController controller = new TowerController();

        controller.startGame("dinamica",5);

        String test = controller.getTowers().toString();

        System.out.println(test);

    }
}
