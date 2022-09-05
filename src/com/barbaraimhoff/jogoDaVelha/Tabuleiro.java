package com.barbaraimhoff.jogoDaVelha;

public class Tabuleiro {
    private final char[][] celulas;
    private char caractereVencedor = ' ';

    public Tabuleiro() {
        celulas = new char[3][3];
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                colocar(x, y, ' ');
            }
        }
    }

    public void colocar(int x, int y, char caractere) {
        celulas[y][x] = caractere;
    }

    public void imprimir() {
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                System.out.print(celulas[y][x]);
                if (x != 2) System.out.print('|');
            }
            if (y != 2) System.out.println("\n-----");
        }
        System.out.println("\n");
    }

    public char getCelula(int x, int y) {
        return celulas[y][x];
    }

    public boolean celulaVazia(int x, int y) {
        return celulas[y][x] == ' ';
    }

    public boolean cheio() {
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                if(celulas[x][y] == ' ') return false;
            }
        }
        return true;
    }

    public boolean coordenadasValidas(int x, int y) {
        return !(x < 0 || x >= 3 || y < 0 || y >= 3);
    }

    public boolean temVencedor() {
        if (algumaDiagonalCompleta()) return true;
        for (int i = 0; i < 3; i++) {
            if (linhaCompleta(i) || colunaCompleta(i)) {
                return true;
            }
        }
        return false;
    }

    public boolean linhaCompleta(int y) {
        char primCaractere = celulas[y][0];
        if (primCaractere == ' ') return false;
        for (int x = 1; x < 3; x++) {
            if (celulas[y][x] != primCaractere) return false;
        }
        caractereVencedor = primCaractere;
        return true;
    }

    public boolean colunaCompleta(int x) {
        char primCaractere = celulas[0][x];
        if (primCaractere == ' ') return false;
        for (int y = 1; y < 3; y++) {
            if (celulas[y][x] != primCaractere) return false;
        }
        caractereVencedor = primCaractere;
        return true;
    }

    public boolean algumaDiagonalCompleta() {
    	if(celulas[1][1] != ' ' && (
                (celulas[0][0] == celulas[1][1] && celulas[1][1] == celulas[2][2]) ||
                (celulas[0][2] == celulas[1][1] && celulas[1][1] == celulas[2][0])
)) {
    		caractereVencedor = celulas[1][1];
    		return true;
    	}
        return false;
    }

    public char getCaractereVencedor() {
        return caractereVencedor;
    }
}
