package HanoiTower;

import Stack.IStack;

import java.lang.reflect.Parameter;

public class TowerInterface {
    private int discCount;

    public void buildGame (IStack<Integer> stack) {
        this.discCount = stack.size();
    }

    public String generateTowers(IStack<Integer> stack) {
        String towers = "";
        int towerSize = this.discCount - stack.size();

        for (int i = 0; i < towerSize; i++) {
            towers += this.getEmptySpaces(this.discCount + 2) + "| \n";
        }
        towers += this.generateTowerDiscs(stack);
        return towers;
    }

    public String generateTowerDiscs(IStack<Integer> stack) {
        int numOfDiscs = stack.size();
        int[] towerArray = generateTowerArray(stack);
        StringBuilder discs = new StringBuilder();

        for (int i = 0; i < numOfDiscs; i++) {
            discs.append(new StringBuilder(getEmptySpaces(numOfDiscs - i) + "<"));
            for (int j = 0; j < towerArray[i]; j++) {
                discs.append("-");
            }
            discs.append("|");
            for (int j = 0; j < towerArray[i]; j++) {
                discs.append("-");
            }
            discs.append(">" + new StringBuilder(getEmptySpaces(numOfDiscs - i) ) + "\n");
        }
        return discs.toString();
    }

    public int[] generateTowerArray(IStack<Integer> stack) {
        int[]array = new int[stack.size()];
        int discs  = stack.size();

        for (int i = 0; i < discs; i++) {
            array[i] = stack.pop();
        }

        return array;
    }

    public String getEmptySpaces(int discCount) {
        String result = "";

        for (int i = 0; i <= discCount; i++) {
            result += " ";
        }

        return result;
    }
}
