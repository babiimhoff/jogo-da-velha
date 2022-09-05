package com.barbaraimhoff.jogoDaVelha;

public class ComputadorA extends Computador {
    public ComputadorA(Tabuleiro tabuleiro) {
        super(tabuleiro);
    }

    @Override
    public void jogar() { // itera pelo tabuleiro procurando a primeira célula vazia
        pensar();
        for(int y = 0; y < 3; y++) {
            for(int x = 0; x < 3; x++) {
                if(tabuleiro.celulaVazia(x,y)) {
                    tabuleiro.colocar(x,y,caractere);
                    return;
                }
            }
        }
    }
}
