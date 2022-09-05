package com.barbaraimhoff.jogoDaVelha;

import java.util.Random;

public abstract class Computador extends Participante {
    protected Random random;

    public Computador(Tabuleiro tabuleiro) {
        super(tabuleiro);
        caractere = 'o';
    }

    // Adiciona a mensagem "Pensando....." quando for a jogada do computador
    protected void pensar() {
        random = new Random();
        System.out.print("Pensando");
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(random.nextInt(150, 300)); // O tempo entre cada '.' pode variar de 150ms a 300ms
            } catch (InterruptedException ignored) {
            }
            System.out.print('.');
        }
        System.out.println();
    }
}
