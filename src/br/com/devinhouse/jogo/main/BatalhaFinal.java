package br.com.devinhouse.jogo.main;

import br.com.devinhouse.jogo.enums.Arma;
import br.com.devinhouse.jogo.enums.Motivacao;
import br.com.devinhouse.jogo.personagens.inimigos.*;
import br.com.devinhouse.jogo.personagens.jogador.*;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class BatalhaFinal {

    public static void main(String[] args) {

        limparTela();
        System.out.println("------------Seja bem vindo(a) à BATALHA FINAL!------------\n\n" +
                           "Aumente o tamanho do terminal para uma melhor experiência!\n\n\n\n");
        esperarEnter();
        limparTela();
        Scanner scanner = new Scanner(System.in);
        String nome;
        char sexo;
        while (true) {
            System.out.print("Digite um nome para o seu personagem: ");
            nome = scanner.nextLine();
            if (Objects.equals(nome, "")) {
                limparTela();
                System.out.println("\nCampo \"NOME\" não pode estar vazio\n");
            } else {
                break;
            }
        }
        limparTela();
        while (true) {
            System.out.print("Digite o sexo do personagem (M ou F): ");
            try {
                sexo = scanner.next().charAt(0);
                if (sexo != 'M' && sexo != 'F') {
                    limparTela();
                    System.out.println("Por favor digite somente \"M\" para masculino ou \"F\" para feminino\n");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e);
            }
        }
        int opClasse;
        limparTela();
        while (true) {
            try {
                System.out.println("Selecione a classe do seu personagem abaixo: ");
                System.out.println("1 - Guerreiro \n2 - Paladino \n3 - Arqueiro \n4 - Mago");
                System.out.print("Opção: ");
                opClasse = scanner.nextInt();
                if (opClasse != 1 && opClasse != 2 && opClasse != 3 && opClasse != 4) {
                    limparTela();
                    System.out.println("Opção inválida!\n");
                } else {
                    break;
                }
            } catch (InputMismatchException inputMismatchException) {
                limparTela();
                System.out.println("Erro: " + inputMismatchException + "\n");
                scanner.next();
            }
        }


        Arma arma;
        Jogador jogador = null;
        limparTela();
        while (true) {
            try {
                System.out.println("Selecione a arma desejada abaixo: ");
                switch (opClasse) {
                    case 1 -> {
                        while (true) {
                            System.out.println("1 - Espada \n2 - Machado");
                            System.out.print("Opção: ");
                            int opArma = scanner.nextInt();
                            if (opArma != 1 && opArma != 2) {
                                limparTela();
                                System.out.println("Opção inválida\n");
                            } else if (opArma == 1) {
                                arma = Arma.ESPADA;
                                break;
                            } else {
                                arma = Arma.MACHADO;
                                break;
                            }
                        }
                        jogador = new Guerreiro(nome, sexo, arma);
                    }
                    case 2 -> {
                        while (true) {
                            System.out.println("1 - Martelo \n2 - Clava");
                            System.out.print("Opção: ");
                            int opArma = scanner.nextInt();
                            if (opArma != 1 && opArma != 2) {
                                limparTela();
                                System.out.println("Opção inválida\n");
                            } else if (opArma == 1) {
                                arma = Arma.MARTELO;
                                break;
                            } else {
                                arma = Arma.CLAVA;
                                break;
                            }
                        }
                        jogador = new Paladino(nome, sexo, arma);
                    }
                    case 3 -> {
                        while (true) {
                            System.out.println("1 - Arco \n2 - Besta");
                            System.out.print("Opção: ");
                            int opArma = scanner.nextInt();
                            if (opArma != 1 && opArma != 2) {
                                limparTela();
                                System.out.println("Opção inválida\n");
                            } else if (opArma == 1) {
                                arma = Arma.ARCO;
                                break;
                            } else {
                                arma = Arma.BESTA;
                                break;
                            }
                        }
                        jogador = new Arqueiro(nome, sexo, arma);
                    }
                    case 4 -> {
                        while (true) {
                            System.out.println("1 - Cajado \n2 - Livro");
                            System.out.print("Opção: ");
                            int opArma = scanner.nextInt();
                            if (opArma != 1 && opArma != 2) {
                                limparTela();
                                System.out.println("Opção inválida\n");
                            } else if (opArma == 1) {
                                arma = Arma.CAJADO;
                                break;
                            } else {
                                arma = Arma.LIVRO_DE_MAGIAS;
                                break;
                            }
                        }
                        jogador = new Mago(nome, sexo, arma);
                    }
                }
                break;
            } catch (InputMismatchException inputMismatchException) {
                limparTela();
                System.out.println("Erro: " + inputMismatchException + "\n");
                scanner.next();
            }
        }


        limparTela();
        System.out.println("""
                A noite se aproxima, a lua já surge no céu, estrelas vão se acendendo,
                e sob a luz do crepúsculo você está prestes a entrar na fase final da sua missão.
                Você olha para o portal à sua frente, e sabe que a partir desse ponto, sua vida mudará para sempre.
                """);

        System.out.println("""
                Memórias do caminho percorrido para chegar até aqui invadem sua mente.
                Você se lembra de todos os inimigos já derrotados para alcançar o covil do líder maligno.
                Olha para seu equipamento de combate, já danificado e desgastado depois de tantas lutas.
                Você está a um passo de encerrar para sempre esse mal.
                """);

        System.out.println("Buscando uma injeção de ânimo, você se força a lembrar o que te trouxe até aqui.");


        int op;
        while (true) {
            try {
                System.out.println("\nPorque você está nessa missão de destruir os inimigos? \n\n1 - Vingança \n2 - Glória");
                System.out.print("Opção: ");
                op = scanner.nextInt();
                if (op != 1 && op != 2) {
                    limparTela();
                    System.out.println("Opção inválida");
                } else if (op == 1) {
                    jogador.setMotivacao(Motivacao.VINGANCA);
                    break;
                } else {
                    jogador.setMotivacao(Motivacao.GLORIA);
                    break;
                }
            } catch (InputMismatchException inputMismatchException) {
                limparTela();
                System.out.println("Erro: " + inputMismatchException);
                scanner.next();
            }
        }

        if (jogador.getMotivacao() == Motivacao.VINGANCA) {
            limparTela();
            System.out.println("""
                    Imagens daquela noite trágica invadem sua mente.
                    Você nem precisa se esforçar para lembrar, pois essas memórias estão sempre presentes,
                    mesmo que de pano de fundo, quando você tem outros pensamentos em foco, elas nunca o deixaram.
                    Elas são o combustível que te fizeram chegar até aqui.
                    E você sabe que não irá desistir até ter vingado a morte
                    daqueles que foram - e pra sempre serão - sua fonte de amor e desejo de continuar vivo.
                    O maldito líder finalmente pagará por tanto mal causado na vida de tantos
                    (e principalmente na sua).""");
        } else {
            limparTela();
            System.out.println("""
                    Você já consegue visualizar na sua mente o povo da cidade te recebendo de braços abertos,
                    bardos criando canções sobre seus feitos heróicos, nobres te presenteando com jóias e diversas riquezas,
                    taberneiros se recusando a cobrar por suas bebedeiras e comilanças.
                    Desde já, você sente o amor do público, te louvando a cada passo que dá pelas ruas,
                    depois de destruir o vilão que tanto assombrou a paz de todos.
                    Porém, você sabe que ainda falta o último ato dessa história.
                    Você se concentra na missão.
                    A glória o aguarda, mas não antes da última batalha.""");

            System.out.println("""
                    Inspirado pelo motivo que te trouxe até aqui, você sente seu coração ardendo em chamas,
                    suas mãos formigarem em volta da sua arma. Você a segura com firmeza. Seu foco está renovado.
                    Você avança pelo portal.""");

            System.out.println("""
                    A escuridão te envolve. Uma iluminação muito fraca entra pelo portal às suas costas.
                    À sua frente, só é possível perceber que você se encontra em um corredor extenso.
                    Você só pode ir à frente, ou desistir.""");
        }

        while (true) {
            try {
                System.out.println("\nVocê deseja continuar ou desistir? \n\n1 - Continuar \n2 - Desistir");
                System.out.print("Opção: ");
                op = scanner.nextInt();
                if (op != 1 && op != 2) {
                    limparTela();
                    System.out.println("Opção inválida!\n");
                } else if (op == 2) {
                    limparTela();
                    System.out.println("O medo invade o seu coração e você sente que ainda não está à altura do desafio.\n"
                            + "Você se volta para a noite lá fora, e corre em direção à segurança.");
                    System.exit(0);
                } else {
                    break;
                }
            } catch (InputMismatchException inputMismatchException) {
                limparTela();
                System.out.println("Erro: " + inputMismatchException);
                scanner.next();
            }
        }

        limparTela();
        System.out.println("""
                Você caminha, atento a todos os seus sentidos, por vários metros,
                até visualizar a frente uma fonte de luz, que você imagina ser a chama de uma tocha,
                vindo de dentro de uma porta aberta.""");

        System.out.println("Você se pergunta se dentro dessa sala pode haver inimigos, ou alguma armadilha,\n"
                + "e pondera sobre como passar pela porta.");

        while (true) {
            try {
                System.out.println("\nVocê precisa passar pela porta, como deseja passar? \n\n1 - Andando cuidadosamente \n2 - Correndo \n3 - Saltando");
                System.out.print("Opção: ");
                op = scanner.nextInt();
                if (op != 1 && op != 2 && op != 3) {
                    limparTela();
                    System.out.println("Opção inválida!\n");
                } else if (op == 3) {
                    limparTela();
                    System.out.println("Você se concentra e pula em direção à luz, saltando de antes da porta até o interior da sala.\n");
                    break;
                } else if (op == 2) {
                    limparTela();
                    System.out.println("""
                            Você respira fundo e desata a correr em direção à sala.
                            Quando passa pela porta, sente que pisou em uma pedra solta,
                            mas não dá muita importância e segue para dentro da sala, olhando ao redor à procura de inimigos.
                            Não tem ninguém, mas você ouve sons de flechas batendo na pedra atrás de você,
                            e quando se vira, vê várias flechas no chão.
                            Espiando pela porta, você entende que pisou em uma armadilha que soltou flechas de uma escotilha aberta no teto,
                            mas por sorte você entrou correndo e conseguiu escapar desse ataque surpresa.
                            """);
                    break;
                } else {
                    limparTela();
                    System.out.print("""
                            Você toma cuidado e vai caminhando vagarosamente em direção à luz.
                            Quando você pisa exatamente embaixo da porta, você sente o chão ceder levemente, como se tivesse pisado em uma pedra solta.
                            Você ouve um ruído de mecanismos se movimentando, e uma escotilha se abre no teto atrás de você, no corredor.
                            Flechas voam da escotilha em sua direção, e você salta para dentro da sala, porém uma delas te acerta na perna.
                            """);

                    Armadilha armadilha = new Armadilha();
                    armadilha.atacar(jogador);
                    break;
                }
            } catch (InputMismatchException inputMismatchException) {
                limparTela();
                System.out.println("Erro: " + inputMismatchException);
                scanner.next();
            }
        }

        esperarEnter();
        limparTela();
        System.out.println("""
                Você se encontra sozinho em uma sala quadrada, contendo uma porta em cada parede.
                Uma delas foi aquela pela qual você entrou, que estava aberta, e as outras três estão fechadas.
                A porta à sua frente é a maior das quatro, com inscrições em seu entorno em uma língua que você não sabe ler,
                mas reconhece como sendo a língua antiga utilizada pelo inimigo.
                Você se aproxima da porta e percebe que ela está trancada por duas fechaduras douradas,
                e você entende que precisará primeiro derrotar o que estiver nas outras duas portas laterais,
                antes de conseguir enfrentar o líder.""");

        System.out.println("Você se dirige para a porta à direita.");

        System.out.println("""
                Você se aproxima, tentando ouvir o que acontece porta adentro, mas não escuta nada.
                Segura com mais força sua arma com uma mão, enquanto empurra a porta com a outra.
                Ao entrar, você se depara com uma sala espaçosa,
                com vários equipamentos de batalha pendurados nas paredes e dispostos em armários e mesas.
                Você imagina que este seja o arsenal do inimigo, onde estão guardados os equipamentos que seus soldados
                utilizam quando saem para espalhar o terror nas cidades e vilas da região.
                Enquanto seu olhar percorre a sala, você ouve a porta se fechando e gira rapidamente para olhar para trás.
                Ali, de pé entre você e a porta fechada, bloqueando o caminho do seu destino, está um dos capitães do inimigo.
                Um orque horrendo, de armadura, capacete e espada em punho, em posição de combate.
                Ele avança em sua direção.
                """);

        esperarEnter();
        limparTela();

        Armeiro armeiro = new Armeiro();
        do {
            armeiro.atacar(armeiro, jogador);
            if (jogador.getSaude() <= 0) {
                break;
            }
            jogador.atacar(armeiro, jogador);
            if (armeiro.getSaude() <= 0) {
                break;
            }
        } while (true);

        esperarEnter();
        limparTela();

        System.out.println("""
                Após derrotar o Armeiro, você percebe que seus equipamentos estão muito danificados.
                Olha em volta, encarando todas aquelas peças de armaduras resistentes e em ótimo estado.

                """);

        esperarEnter();

        while (true) {
            try {
                System.out.println("Você deseja pegar as armaduras do inimigo? \n\n1 - Sim \n2 - Não");
                System.out.print("Opção: ");
                op = scanner.nextInt();
                if (op != 1 && op != 2) {
                    limparTela();
                    System.out.println("Opção inválida!\n");
                } else if (op == 1){
                    limparTela();
                    System.out.println("""
                        Você resolve usar os equipamentos do inimigo contra ele, e trocar algumas peças suas,
                        que estavam danificadas, pelas peças de armaduras existentes na sala.
                        De armadura nova, você se sente mais protegido para os desafios à sua frente.
                        """);
                    jogador.setDefesa(jogador.getDefesa() + 5);
                    esperarEnter();
                    break;
                } else {
                    limparTela();
                    System.out.println("Você decide que não precisa utilizar nada que venha das mãos do inimigo.\n\n");
                    esperarEnter();
                    break;
                }
            } catch (InputMismatchException inputMismatchException) {
                limparTela();
                System.out.println("Erro :" + inputMismatchException);
                scanner.next();
            }
        }

        limparTela();
        System.out.println("Em uma mesa, você encontra uma chave dourada, e sabe que aquela chave abre uma das fechaduras da porta do líder inimigo.\n"
                + "Você pega a chave e guarda numa pequena bolsa que leva presa ao cinto.");

        System.out.println("""
                Você retorna à sala anterior e se dirige à porta da esquerda.
                Você se aproxima, tentando ouvir o que acontece porta adentro, mas não escuta nada.
                Segura com mais força sua arma com uma mão, enquanto empurra a porta com a outra.
                Ao entrar, você se depara com uma sala parecida com a do arsenal, mas em vez de armaduras,
                existem vários potes e garrafas de vidro com conteúdos misteriosos e de cores diversas,
                e você entende que o capitão que vive ali, realiza experimentos com diversos ingredientes,
                criando poções utilizadas pelos soldados para aterrorizar a região.""");
        System.out.println("""
                No fundo da sala, olhando em sua direção, está outro dos capitães do inimigo.
                Um orque horrendo, de armadura, cajado em punho, em posição de combate. Ele avança em sua direção.

                """);

        esperarEnter();

        limparTela();
        Alquimista alquimista = new Alquimista();
        System.out.println("\n\n\n\n\n\n");
        do {
            alquimista.atacar(alquimista, jogador);
            if (jogador.getSaude() <= 0) {
                break;
            }
            jogador.atacar(alquimista, jogador);
            if (alquimista.getSaude() <= 0) {
                break;
            }
        } while (true);

        esperarEnter();
        limparTela();
        System.out.println("""
                Após derrotar o Alquimista, você olha em volta, tentando reconhecer alguma poção do estoque do inimigo.
                Em uma mesa, você reconhece uma pequena garrafa de vidro contendo um líquido levemente rosado,
                pega a garrafa e pondera se deve beber um gole.""");


        while (true) {
            try {
                System.out.println("Você deseja beber? \n\n1 - Sim \n2 - Não");
                System.out.print("Opção: ");
                op = scanner.nextInt();
                if (op != 1 && op != 2) {
                    limparTela();
                    System.out.println("Opção inválida!\n");
                } else if (op == 1) {
                    limparTela();
                    System.out.println("Você se sente revigorado para seguir adiante!\n\n");
                    esperarEnter();
                    jogador.setSaude(200);
                    break;
                } else {
                    limparTela();
                    System.out.println("Você fica receoso de beber algo produzido pelo inimigo.\n");
                    break;
                }
            } catch (InputMismatchException inputMismatchException) {
                limparTela();
                System.out.println("Erro: " + inputMismatchException);
                scanner.next();
            }
        }

        limparTela();
        System.out.println("""
                Ao lado da porta, você vê uma chave dourada em cima de uma mesa,
                e sabe que aquela chave abre a outra fechadura da porta do líder inimigo.
                Você pega a chave e guarda na pequena bolsa que leva presa ao cinto.
                """);

        System.out.println("""
                De volta à sala das portas, você se dirige à porta final.
                Coloca as chaves nas fechaduras, e a porta se abre.
                Seu coração acelera, memórias de toda a sua vida passam pela sua mente,
                e você percebe que está muito próximo do seu objetivo final.
                Segura sua arma com mais firmeza, foca no combate que você sabe que irá se seguir, e adentra a porta.
                """);

        System.out.println("Lá dentro, você vê o líder sentado em uma poltrona dourada, com duas fogueiras de cada lado, e prisioneiros acorrentados às paredes.");

        System.out.println("Ele percebe sua chegada e se levanta com um salto, apanhando seu machado de guerra de lâmina dupla.\n\n");


        while (true) {
            try {
                System.out.println("1 - Iniciar combate \n2 - Esperar");
                System.out.print("Opção: ");
                op = scanner.nextInt();
                if (op != 1 && op != 2) {
                    limparTela();
                    System.out.println("Opção inválida!\n");
                } else if (op == 1) {
                    limparTela();
                    Lider lider = new Lider();
                    while (true) {
                        jogador.atacar(lider, jogador);
                        if (lider.getSaude() <= 0) {
                            break;
                        }
                        lider.atacar(lider, jogador);
                        if (jogador.getSaude() <= 0) {
                            break;
                        }
                    }
                    break;
                } else {
                    limparTela();
                    Lider lider = new Lider();
                    while (true) {
                        lider.atacar(lider, jogador);
                        if (jogador.getSaude() <= 0) {
                            break;
                        }
                        jogador.atacar(lider, jogador);
                        if (lider.getSaude() <= 0) {
                            break;
                        }
                    }
                    break;
                }
            } catch (InputMismatchException inputMismatchException) {
                limparTela();
                System.out.println("Erro: " + inputMismatchException);
                scanner.next();
            }
        }

        if (jogador.getSaude() > 0) {
            System.out.println("Você conseguiu!");

            if (jogador.getMotivacao().equals(Motivacao.VINGANCA)) {
                System.out.println("Você obteve sua vingança. Você se ajoelha e cai no choro, invadido por uma sensação de alívio e felicidade. " +
                        "Você se vingou, tudo que sempre quis, está feito. Agora você pode seguir sua vida.");
            } else {
                System.out.println("O êxtase em que você se encontra não cabe dentro de si. Você se ajoelha e grita de alegria. A glória o aguarda, você a conquistou.");
            }

            System.out.println("""
                    Você se levanta, olha para os prisioneiros, vai de um em um e os liberta,
                    e todos vocês saem em direção à noite, retornando à cidade.
                    Seu dever está cumprido.""");
        }
    }

    public static void limparTela() {
        for (int i = 0; i < 50; i++) {
            System.out.println("\n\n");
        }
    }

    public static void esperarEnter() {
        System.out.println("\"ENTER\" para continuar...");
        try {
            int i = System.in.read(new byte[2]);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

}
