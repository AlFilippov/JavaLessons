package com.filippov.lambdas;

import java.util.Arrays;

public class LambdasMain {
    public static void main(String[] args) {
      String[] colors = {"green","black","blue"};
      Player player1= new Player("Akex",100);
      Player player2= new Player("Akex",80);
      Player player3= new Player("Akex",90);
      Player player4= new Player("Akex",91);
      Player player5= new Player("Akex",81);
      Player[] players = {player1,player2,player3,player4};

    }
    private static class Player {
        private String name ;
        private int score ;

        public Player(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }
}
