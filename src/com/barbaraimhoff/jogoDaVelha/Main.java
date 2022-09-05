package com.barbaraimhoff.jogoDaVelha;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String jogarNovamente;
        do {
            Jogo jogo = new Jogo();
            jogo.escolherDificuldade();
            jogo.jogar();
            System.out.println("Gostaria de jogar novamente? (s/n)");
            jogarNovamente = input.nextLine().toLowerCase(); // limpa entrada para aceitar S/s/N/n
        } while(jogarNovamente.equals("s")); // repete jogo caso jogador responder 's'
    }
}
