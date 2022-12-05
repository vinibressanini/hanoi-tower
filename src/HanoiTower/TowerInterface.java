package HanoiTower;

import Stack.IStack;
public class TowerInterface {
    private int discCount;

    public void buildGame (IStack<Integer> stack) {
        this.discCount = stack.size();
    }

    public String generateTowers(IStack<Integer> stack, int towerNumber) {
        String towers = "\nTower " + towerNumber + "\n";
        int towerSize = this.discCount - stack.size();


        for (int i = 0; i < towerSize; i++) {
            towers += this.getEmptySpaces(this.discCount) + "| \n";
        }

        towers += this.generateTowerDiscs(stack);
        return towers;
    }

    private String generateTowerDiscs(IStack<Integer> stack) {
        int numOfDiscs = stack.size();
        int[] towerArray = generateTowerArray(stack);
        StringBuilder discs = new StringBuilder();

        for (int i = 0; i < numOfDiscs; i++) {
            discs.append(getEmptySpaces(numOfDiscs - i)).append("<");
            for (int j = 0; j < towerArray[i]; j++) {
                discs.append("-");
            }
            discs.append("|");
            for (int j = 0; j < towerArray[i]; j++) {
                discs.append("-");
            }
            discs.append(">").append(getEmptySpaces(numOfDiscs - i)).append("\n");
        }
        return discs.toString();
    }

    private int[] generateTowerArray(IStack<Integer> stack) {
        int numOfDisc = stack.size();
        int[] towerArray;
        if (!stack.isEmpty()) {
            towerArray = new int[stack.size()];
            for (int i = 0; i < numOfDisc; i++) {
                towerArray[i] = stack.pop();
            }
            for (int i = numOfDisc - 1; i >= 0; i--) {
                stack.push(towerArray[i]);
            }
        } else {
            towerArray = null;
        }
        return towerArray;
    }

    private String getEmptySpaces(int discCount) {
        String result = "";

        for (int i = 0; i <= discCount; i++) {
            result += " ";
        }

        return result;
    }
}
