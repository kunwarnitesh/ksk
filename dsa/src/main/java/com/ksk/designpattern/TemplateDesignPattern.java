package com.ksk.designpattern;

public class TemplateDesignPattern extends Game{
    public static void main(String[] args) {
        TemplateDesignPattern templateDesignPattern = new TemplateDesignPattern();
        templateDesignPattern.play();
    }

    @Override
    public void initializeGame() {
        System.out.println("Game Initialized");
    }

    @Override
    public void startGame() {
        System.out.println("Game Started");
    }

    @Override
    public void endGame() {
        System.out.println("Game Ended");
    }
}

abstract class Game{

    public abstract void initializeGame();
    public abstract void startGame();
    public abstract void endGame();
    public final void play(){
        initializeGame();
        startGame();
        endGame();
    }
}
