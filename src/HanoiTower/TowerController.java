package HanoiTower;

import Stack.ContiguosStack;
import Stack.DynamicStack;
import Stack.IStack;

import java.util.LinkedList;

public class TowerController {
    private IStack<Integer> firstTower;
    private IStack<Integer> secondTower;
    private IStack<Integer> thirdTower;
    private int discCount = 5;

    private TowerInterface towerInterface = new TowerInterface();

    public void startGame(String type) {
        switch (type) {
            case "dinamica" :
                this.firstTower = new DynamicStack<>();
                this.secondTower = new DynamicStack<>();
                this.thirdTower = new DynamicStack<>();
                break;
            case "contigua" :
                this.firstTower = new ContiguosStack<>(this.discCount);
                this.secondTower = new ContiguosStack<>(this.discCount);
                this.thirdTower = new ContiguosStack<>(this.discCount);
                break;
        }

    }
    public void startGame(String type, int totalDiscs) {
        this.discCount = totalDiscs;
        switch (type) {
            case "dinamica" :
                this.firstTower = new DynamicStack<>();
                this.secondTower = new DynamicStack<>();
                this.thirdTower = new DynamicStack<>();
            case "contigua" :
                this.firstTower = new ContiguosStack<>(this.discCount);
                this.secondTower = new ContiguosStack<>(this.discCount);
                this.thirdTower = new ContiguosStack<>(this.discCount);
        }
    }

    public void populateTower() {
        for (int i = this.discCount; i > 0; i--) {
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

    public void moveDisc (int originTower, int destinyTower) {
        if(!validTowers(originTower,destinyTower)) {
            System.out.println("Você só pode informar 1, 2 ou 3");
        }

        if (originTower == 1 && destinyTower == 2) {
            this.verifyDiscMovement(this.firstTower, this.secondTower);
        } else if (originTower == 1 && destinyTower == 3) {
            this.verifyDiscMovement(this.firstTower, this.thirdTower);
        } else if (originTower == 2 && destinyTower == 1) {
            this.verifyDiscMovement(this.secondTower, this.firstTower);
        } else if (originTower == 2 && destinyTower == 3) {
            this.verifyDiscMovement(this.secondTower, this.thirdTower);
        } else if (originTower == 3 && destinyTower == 1) {
            this.verifyDiscMovement(this.thirdTower, this.firstTower);
        } else if (originTower == 3 && destinyTower == 2) {
            this.verifyDiscMovement(this.thirdTower, this.secondTower);
        }
    }

    private void verifyDiscMovement(IStack<Integer> originTower, IStack<Integer> destinyTower) {
        if (!this.endGame()) {
            if (destinyTower.isEmpty()) {
                Integer value = originTower.pop();
                destinyTower.push(value);
            } else if (destinyTower.top() > originTower.top()) {
                Integer value = originTower.pop();
                destinyTower.push(value);
            }
        }
    }

    private boolean validTowers(int origin, int destiny) {
        if (origin > 0 && origin < 4 && destiny > 0 && destiny < 4) {
            return true;
        } else {
            return false;
        }
    }

    public boolean endGame() {
        return thirdTower.size() == discCount;
    }


}
