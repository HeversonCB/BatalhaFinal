package br.com.devinhouse.jogo.main;

import br.com.devinhouse.jogo.personagens.inimigos.Inimigo;
import br.com.devinhouse.jogo.personagens.jogador.Jogador;

public interface Atacante {


    default void atacar(Jogador jogador) {

    }

    void atacar(Inimigo inimigo, Jogador jogador);
}
