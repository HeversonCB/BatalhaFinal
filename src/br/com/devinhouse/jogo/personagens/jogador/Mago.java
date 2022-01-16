package br.com.devinhouse.jogo.personagens.jogador;

import br.com.devinhouse.jogo.enums.Arma;

public class Mago extends Jogador {

    public Mago () {}

    public Mago(String nome, char sexo, Arma arma) {
        super(nome, sexo, arma);
        super.setAtaque(19);
        super.setDefesa(11);
    }
}