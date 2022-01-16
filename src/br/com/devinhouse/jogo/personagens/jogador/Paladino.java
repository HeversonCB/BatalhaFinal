package br.com.devinhouse.jogo.personagens.jogador;

import br.com.devinhouse.jogo.enums.Arma;

public class Paladino extends Jogador {

    public Paladino() {}

    public Paladino(String nome, char sexo, Arma arma) {
        super(nome, sexo, arma);
        super.setAtaque(13);
        super.setDefesa(18);
    }
}