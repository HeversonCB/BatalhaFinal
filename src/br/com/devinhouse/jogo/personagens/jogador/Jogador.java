package br.com.devinhouse.jogo.personagens.jogador;

import br.com.devinhouse.jogo.enums.Arma;
import br.com.devinhouse.jogo.enums.Motivacao;
import br.com.devinhouse.jogo.main.Atacante;
import br.com.devinhouse.jogo.main.BatalhaFinal;
import br.com.devinhouse.jogo.personagens.inimigos.Inimigo;
import br.com.devinhouse.jogo.personagens.Personagem;
import jdk.management.jfr.FlightRecorderMXBean;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public abstract class Jogador extends Personagem implements Atacante {
    private String nome;
    private char sexo;
    private Motivacao motivacao;
    private Arma arma;

    @Override
    public void atacar(Inimigo inimigo, Jogador jogador) {
        Scanner scanner = new Scanner(System.in);
        int danoTotal;
        int danoAtaque = jogador.getAtaque();
        int danoArma = jogador.getArma().getAtaque();
        Random random = new Random();
        int danoDado = random.nextInt(20) + 1;

        while (true) {
            try {
                System.out.println("\nSelecione uma ação: \n1 - Atacar \n2 - Fugir");
                System.out.print("Opção: ");
                int op = scanner.nextInt();
                if (op != 1 && op != 2) {
                    BatalhaFinal.limparTela();
                    System.out.println("Opção inválida!\n");
                } else if (op == 2) {
                    BatalhaFinal.limparTela();
                    System.out.println("\n\nVocê não estava preparado para a força do inimigo, e decide fugir para que possa tentar novamente em uma próxima vez.");
                    System.exit(0);
                } else {
                    if (danoDado == 1) {
                        BatalhaFinal.limparTela();
                        System.out.println("\n\nVocê errou seu ataque! O inimigo não sofreu dano algum.\n\n");
                    } else {
                        if (danoDado == 20) {
                            danoTotal = danoArma + danoAtaque + danoDado;
                            inimigo.setSaude(inimigo.getSaude() - danoTotal);
                            if (inimigo.getSaude() <= 0) {
                                BatalhaFinal.limparTela();
                                System.out.println("\nO inimigo não é páreo para o seu heroísmo, e jaz imóvel aos seus pés.\n");
                            } else {
                                BatalhaFinal.limparTela();
                                System.out.printf("\nVocê acertou um ataque crítico! Você atacou com %s e causou %d de dano no inimigo!\n", jogador.getArma().getFrase(), danoTotal);
                            }
                        } else {
                            danoTotal = (danoArma + danoAtaque + danoDado) - inimigo.getDefesa();
                            inimigo.setSaude(inimigo.getSaude() - danoTotal);
                            if (inimigo.getSaude() <= 0) {
                                BatalhaFinal.limparTela();
                                System.out.println("\n\nO inimigo não é páreo para o seu heroísmo, e jaz imóvel aos seus pés.\n\n");
                            } else {
                                BatalhaFinal.limparTela();
                                System.out.printf("\nVocê atacou com %s e causou %d de dano no inimigo!\n", jogador.getArma().getFrase(), danoTotal);
                            }
                        }
                    }
                    break;
                }
            } catch (InputMismatchException inputMismatchException) {
                BatalhaFinal.limparTela();
                System.out.println("Erro: " + inputMismatchException);
                scanner.next();
            }
        }

    }

    @Override
    public String toString() {
        return "Jogador{" +
                "nome='" + nome + '\'' +
                ", sexo=" + sexo +
                ", motivacao=" + motivacao +
                ", arma=" + arma +
                ", saude=" + super.getSaude() +
                "} " + super.toString();
    }

    public Jogador() {

    }

    public Jogador(String nome, char sexo, Arma arma) {
        try {
            if (nome.equals("")) {
                System.out.println("Campo \"Nome\" não pode estar vazio!!");
            } else {
                this.nome = nome;
            }
            if (sexo == 'M' || sexo == 'F') {
                this.sexo = sexo;
            } else {
                System.out.println("Por favor digite apenas M ou F para sexo.");
            }
        } catch (Exception e) {
            System.out.println("Erro " + e);
        }
        this.arma = arma;
        super.setSaude(200);
    }

    public Motivacao getMotivacao() {
        return motivacao;
    }

    public void setMotivacao(Motivacao motivacao) {
        this.motivacao = motivacao;
    }

    public Arma getArma() {
        return arma;
    }

    public char getSexo() {
        return sexo;
    }
}
