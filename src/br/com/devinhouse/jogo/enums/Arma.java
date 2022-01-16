package br.com.devinhouse.jogo.enums;

public enum Arma {
    ESPADA(5, "sua espada"), MACHADO(5, "seu machado"), MARTELO(5, "seu martelo"),
    CLAVA(5, "sua clava"), ARCO(5, "seu arco, a flecha atingiu"), BESTA(5, "sua besta, o virote atingiu"),
    CAJADO(5, "seu cajado, lançou uma bola de fogo"), LIVRO_DE_MAGIAS(5, "o livro, absorveu a energia dele com uma mão liberando com a outra"),
    ARMADILHA(2), MACHADO_DUPLO(7);

    private final int ataque;
    private String frase;

    Arma(int ataque, String frase) {
        this.ataque = ataque;
        this.frase = frase;
    }

    Arma(int ataque) {
        this.ataque = ataque;
    }

    public int getAtaque() {
        return this.ataque;
    }

    public String getFrase() {
        return frase;
    }
}
