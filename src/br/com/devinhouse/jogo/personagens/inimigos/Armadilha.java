package br.com.devinhouse.jogo.personagens.inimigos;

import br.com.devinhouse.jogo.enums.Arma;
import br.com.devinhouse.jogo.main.Atacante;
import br.com.devinhouse.jogo.personagens.jogador.Jogador;

import java.util.Random;

public class Armadilha implements Atacante {
    private final Arma arma = Arma.ARMADILHA;

    @Override
    public void atacar(Inimigo inimigo, Jogador jogador) {}

    @Override
    public void atacar(Jogador jogador) {
        Random random = new Random();
        int danoDado = random.nextInt(10) + 1;
        if (danoDado == 1) {
            System.out.println("\n\nO ataque da armadilha pegou de raspão e você não sofreu dano.\n\n");
        } else {
            int danoTotal = arma.getAtaque() + danoDado;
            jogador.setSaude(jogador.getSaude()-danoTotal);
            System.out.printf("\n\nVocê sofreu %d de dano e agora possui %d pontos de vida\n\n", danoTotal, jogador.getSaude());
        }
    }
}
