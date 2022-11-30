package HanoiTower;

import Stack.ContiguosStack;
import Stack.DynamicStack;
import Stack.IStack;

import java.util.LinkedList;

public class TowerController {
    private IStack<Integer> firstTower;
    private IStack<Integer> secondTower;
    private IStack<Integer> thirdTower;
    private int discCount = 3;
    private TowerInterface towerInterface = new TowerInterface();

    public void startGame(String stackType) {

        switch (stackType) {
            case "contigua" :
                this.firstTower = new ContiguosStack<>();
                this.secondTower = new ContiguosStack<>();
                this.thirdTower = new ContiguosStack<>();
                break;
            case "dinamica" :
                this.firstTower = new DynamicStack<>();
                this.secondTower = new DynamicStack<>();
                this.thirdTower = new DynamicStack<>();
                break;
        }

        for (int i = this.discCount; i > 0; i--) {
            this.firstTower.push(i);
        }
        towerInterface.buildGame(this.firstTower);
    }
    public void startGame(String stackType,int discCount) {
        switch (stackType) {
            case "contigua" :
                this.firstTower = new ContiguosStack<>();
                this.secondTower = new ContiguosStack<>();
                this.thirdTower = new ContiguosStack<>();
                break;
            case "dinamica" :
                this.firstTower = new DynamicStack<>();
                this.secondTower = new DynamicStack<>();
                this.thirdTower = new DynamicStack<>();
                break;
        }

        for (int i = discCount; i > 0; i--) {
            this.firstTower.push(i);
        }
        towerInterface.buildGame(this.firstTower);
    }

    public StringBuilder getTowers() {
        StringBuilder towers = new StringBuilder();
        for(int i = 1; i < 4; i++) {
            switch (i) {
                case 1 :
                    towers.append(towerInterface.generateTowers(firstTower,i));
                    break;
                case 2:
                    towers.append(towerInterface.generateTowers(secondTower,i));
                    break;
                case 3:
                    towers.append(towerInterface.generateTowers(thirdTower,i));
            }
        }
        return towers;
    }
}
