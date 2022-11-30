package HanoiTower;

import Stack.ContiguosStack;
import Stack.DynamicStack;

public class test {
    public static void main(String[] args) {
        ContiguosStack<Integer> stack = new ContiguosStack<>();
        TowerInterface tower = new TowerInterface();

        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);

        tower.buildGame(stack);
        String test = tower.generateTowers(stack);

        System.out.println(test);

    }
}
