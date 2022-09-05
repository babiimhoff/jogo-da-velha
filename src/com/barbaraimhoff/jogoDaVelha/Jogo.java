package com.barbaraimhoff.jogoDaVelha;

import java.util.Scanner;

public class Jogo {
    private final Tabuleiro tabuleiro;
    private Dificuldade dificuldade;

    public Jogo() {
        this.tabuleiro = new Tabuleiro();
    }

    public void jogar() {
        Participante jogadorAtual;
        Jogador jogadorHumano = new Jogador(tabuleiro);
        Computador computador = escolherComputador(); // define computador correspondente ao nivel de dificuldade
        jogadorAtual = jogadorHumano;
        while (true) {
            jogadorAtual.jogar();
            tabuleiro.imprimir();
            if(tabuleiro.cheio() || tabuleiro.temVencedor()) {
                encerrarJogo();
                break;
            }
            jogadorAtual = jogadorAtual == jogadorHumano ? computador : jogadorHumano; // troca jogador atual
        }
    }

    public void escolherDificuldade() {
        Scanner input = new Scanner(System.in);
        String dif;
        do {
            System.out.println("Dificuldade do jogo: (facil/medio/dificil)");
            dif = input.nextLine().toLowerCase(); // limpa entrada para aceitar FACIL/Facil/facil...
        } while (!dif.equals("facil") && !dif.equals("medio") && !dif.equals("dificil")); // repete enquanto não for entrada válida
        switch (dif) {
            case "facil" -> dificuldade = Dificuldade.FACIL;
            case "medio" -> dificuldade = Dificuldade.MEDIO;
            case "dificil" -> dificuldade = Dificuldade.DIFICIL;
        }
    }

    private void encerrarJogo() {
        switch (tabuleiro.getCaractereVencedor()) {
            case ' ' -> System.out.println("Empate. Todos perdem.");
            case 'x' -> System.out.println("Parabéns! Você ganhou.");
            case 'o' -> System.out.println("Você perdeu.");
        }
    }

    private Computador escolherComputador() {
        switch (dificuldade) {
            case FACIL -> {
                return new ComputadorA(tabuleiro);
            }
            case MEDIO -> {
                return new ComputadorB(tabuleiro);
            }
            case DIFICIL -> {
                return new ComputadorC(tabuleiro);
            }
        }
        return null;
    }
}
