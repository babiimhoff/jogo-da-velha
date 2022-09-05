package com.barbaraimhoff.jogoDaVelha;

public abstract class Participante {
    protected Tabuleiro tabuleiro;
    protected char caractere;
    public Participante(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }
    public abstract void jogar();
}
