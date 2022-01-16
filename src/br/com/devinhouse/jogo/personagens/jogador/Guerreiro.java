package br.com.devinhouse.jogo.personagens.jogador;

import br.com.devinhouse.jogo.enums.Arma;

public class Guerreiro extends Jogador{

    public Guerreiro(String nome, char sexo, Arma arma) {
        super(nome, sexo, arma);
        super.setAtaque(15);
        super.setDefesa(15);
    }
}
