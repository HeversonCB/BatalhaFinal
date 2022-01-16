package br.com.devinhouse.jogo.personagens.inimigos;

import br.com.devinhouse.jogo.enums.Arma;
import br.com.devinhouse.jogo.enums.Motivacao;
import br.com.devinhouse.jogo.personagens.jogador.Jogador;

import java.util.Random;

public class Lider extends Inimigo {

    public Lider() {
        super.setSaude(200);
        super.setAtaque(15);
        super.setDefesa(15);
        super.setArma(Arma.MACHADO_DUPLO);
    }

    @Override
    public void atacar(Inimigo inimigo, Jogador jogador) {
        int danoAtaque = inimigo.getAtaque();
        int danoArma = inimigo.getArma().getAtaque();
        Random random = new Random();
        int danoDado = random.nextInt(20) + 1;
        int danoTotal;
        if (danoDado == 1) {
            System.out.println("\nO inimigo errou o ataque! Você não sofreu dano.\n");
        } else if (danoDado == 20) {
            danoTotal = danoArma + danoAtaque + danoDado;
            jogador.setSaude(jogador.getSaude() - danoTotal);
            if (jogador.getSaude() <= 0) {
                if (jogador.getMotivacao() == Motivacao.VINGANCA) {
                    System.out.printf("""


                            Você não estava preparado para a força do inimigo. %s

                            """, Motivacao.VINGANCA.getFrase());
                } else if (jogador.getSexo() == 'M') {
                    System.out.printf("""


                            Você não estava preparado para a força do inimigo. %s

                            """, Motivacao.GLORIA.getFraseM());
                } else {
                    System.out.printf("""


                            Você não estava preparado para a força do inimigo. %s

                            """, Motivacao.GLORIA.getFraseF());
                }
            } else {
                System.out.printf("\nO inimigo acertou um ataque crítico! Você sofreu %d de dano e agora possui %d pontos de vida.\n",
                        danoTotal, jogador.getSaude());
            }
        } else {
            danoTotal = (danoArma + danoAtaque + danoDado) - jogador.getDefesa();
            jogador.setSaude(jogador.getSaude() - danoTotal);
            if (jogador.getSaude() <= 0) {
                if (jogador.getMotivacao() == Motivacao.VINGANCA) {
                    System.out.printf("""


                            Você não estava preparado para a força do inimigo. %s

                            """, Motivacao.VINGANCA.getFrase());
                } else if (jogador.getSexo() == 'M') {
                    System.out.printf("""


                            Você não estava preparado para a força do inimigo. %s

                            """, Motivacao.GLORIA.getFraseM());
                } else {
                    System.out.printf("""


                            Você não estava preparado para a força do inimigo. %s

                            """, Motivacao.GLORIA.getFraseF());
                }
            } else {
                System.out.printf("\nO inimigo atacou! Você sofreu %d de dano e agora possui %d pontos de vida.\n", danoTotal, jogador.getSaude());
            }
        }
    }
}