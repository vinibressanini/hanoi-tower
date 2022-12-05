package HanoiTower;

import Stack.ContiguosStack;
import Stack.DynamicStack;
import Stack.IStack;

public class TowerController {
    private IStack<Integer> firstTower;
    private IStack<Integer> secondTower;
    private IStack<Integer> thirdTower;
    private short discCount = 5;

    private short totalMoves = 0;

    private final TowerInterface towerInterface = new TowerInterface();

    public void startGame(String type) {
        switch (type) {
            case "dinamica" -> {
                this.firstTower = new DynamicStack<>();
                this.secondTower = new DynamicStack<>();
                this.thirdTower = new DynamicStack<>();
            }
            case "contigua" -> {
                this.firstTower = new ContiguosStack<>(this.discCount);
                this.secondTower = new ContiguosStack<>(this.discCount);
                this.thirdTower = new ContiguosStack<>(this.discCount);
            }
        }

    }
    public void startGame(String type, short totalDiscs) {
        this.discCount = totalDiscs;
        switch (type) {
            case "dinamica" -> {
                this.firstTower = new DynamicStack<>();
                this.secondTower = new DynamicStack<>();
                this.thirdTower = new DynamicStack<>();
            }
            case "contigua" -> {
                this.firstTower = new ContiguosStack<>(this.discCount);
                this.secondTower = new ContiguosStack<>(this.discCount);
                this.thirdTower = new ContiguosStack<>(this.discCount);
            }
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
        for(short i = 1; i < 4; i++) {
            switch (i) {
                case 1 -> towers.append(towerInterface.generateTowers(firstTower, i));
                case 2 -> towers.append(towerInterface.generateTowers(secondTower, i));
                case 3 -> towers.append(towerInterface.generateTowers(thirdTower, i));
            }
        }
        return towers;
    }

    public void moveDisc (short originTower, short destinyTower) {
        if(!validTowers(originTower,destinyTower)) {
            System.out.println("Esta torre não existe! Somente 1,2 ou 3");
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
            if (originTower.isEmpty()) {
                System.out.println("A torre de origem está vazia! Escolha uma torre que possua discos");
            } else if (destinyTower.isEmpty()) {
                destinyTower.push(originTower.pop());
                totalMoves++;
            } else if (destinyTower.top() > originTower.top()) {
                destinyTower.push(originTower.pop());
                totalMoves++;
            } else {
                System.out.println("Movimento Inválido! O Disco De Origem Deve Ser Menor Que o Disco De Destino");
            }
        }
    }

    private boolean validTowers(short origin, short destiny) {
        return origin > 0 && origin < 4 && destiny > 0 && destiny < 4;
    }

    public boolean endGame() {
        return thirdTower.size() == discCount;
    }

    public String getPlayerTotalMoves() {
        return "Parabéns! Você finalizou o jogo com " + totalMoves + " jogadas!";
    }

}
