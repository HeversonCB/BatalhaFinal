package br.com.devinhouse.jogo.personagens.jogador;

import br.com.devinhouse.jogo.enums.Arma;

public class Arqueiro extends Jogador{

    public Arqueiro() {}

    public Arqueiro(String nome, char sexo, Arma arma) {
        super(nome, sexo, arma);
        super.setAtaque(18);
        super.setDefesa(13);
    }
}
