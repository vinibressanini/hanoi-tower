package HanoiTower;

import Stack.IStack;

public class TowerInterface {
    private int discCount;

    public void buildGame (IStack<Integer> stack) {
        this.discCount = stack.size();
    }
    

    public int[] generateTowerArray(IStack<Integer> stack) {
        int[]array = new int[stack.size()];
        int discs  = stack.size();

        for (int i = 0; i < discs; i++) {
            array[i] = stack.pop();
        }

        return array;
    }
}
