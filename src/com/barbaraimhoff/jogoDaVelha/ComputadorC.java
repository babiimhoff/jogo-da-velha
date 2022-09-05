package com.barbaraimhoff.jogoDaVelha;

public class ComputadorC extends Computador {
    public ComputadorC(Tabuleiro tabuleiro) {
        super(tabuleiro);
    }

    @Override
    public void jogar() {
        pensar();
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                if (verificarAoRedor(x,y)) { // tenta fazer a jogada pr�xima a uma c�lula j� colocada
                    return;
                }
            }
        }
        for(int y = 0; y < 3; y++) { // se n�o encontrar nenhuma c�lula colocada por ele mesmo, coloca na pr�xima dispon�vel
            for(int x = 0; x < 3; x++) {
                if(tabuleiro.celulaVazia(x,y)) {
                    tabuleiro.colocar(x,y,caractere);
                    return;
                }
            }
        }
    }

    private boolean verificarAoRedor(int x, int y) {
        if (tabuleiro.getCelula(x, y) == caractere) {
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if (tabuleiro.coordenadasValidas(x+i, y+j) && tabuleiro.celulaVazia(x+i, y+j)) {
                        tabuleiro.colocar(x+i, y+j, caractere);
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
