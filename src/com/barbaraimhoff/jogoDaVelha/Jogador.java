package com.barbaraimhoff.jogoDaVelha;

import java.util.Scanner;

public class Jogador extends Participante{
    private Scanner input;
    public Jogador(Tabuleiro tabuleiro) {
        super(tabuleiro);
        caractere = 'x';
        input = new Scanner(System.in);
    }

    @Override
    public void jogar() {
        int x = 0,y = 0;
        boolean jogadaValida = false;
        while(!jogadaValida) {
            System.out.println("Sua jogada: (x,y) [ex: 0,0]");
            String[] coords = input.nextLine().split(","); // lê as coordenas do tabuleiro
            try{
                x = Integer.parseInt(coords[0]);
                y = Integer.parseInt(coords[1]);
            } catch (Exception e) {
                System.out.println("Jogada Inválida. Tente novamente.");
                continue;
            }
            if(!tabuleiro.coordenadasValidas(x,y) || !tabuleiro.celulaVazia(x,y)) {
                System.out.println("Jogada Inválida. Tente novamente");
                continue;
            }
            jogadaValida = true;
        }
        tabuleiro.colocar(x,y,caractere);
    }
}
