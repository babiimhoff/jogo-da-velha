package com.barbaraimhoff.jogoDaVelha;

public class ComputadorB extends Computador {
    public ComputadorB(Tabuleiro tabuleiro) {
        super(tabuleiro);
    }

    @Override
    public void jogar() {
        pensar();
        int x,y;
        do { // escolhe uma c�lula aleatoriamente
            x = random.nextInt(0,3);
            y = random.nextInt(0,3);
        } while (!tabuleiro.celulaVazia(x,y)); // repete o la�o enquanto n�o for uma c�lula vazia
        tabuleiro.colocar(x,y,caractere);
    }
}
