package br.com.devinhouse.jogo.personagens.inimigos;

import br.com.devinhouse.jogo.enums.Arma;
import br.com.devinhouse.jogo.main.Atacante;
import br.com.devinhouse.jogo.personagens.Personagem;

public abstract class Inimigo extends Personagem implements Atacante {
    private Arma arma;

    public void setArma(Arma arma) {
        this.arma = arma;
    }

    public Arma getArma() {
        return arma;
    }

}
