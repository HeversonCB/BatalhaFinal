package br.com.devinhouse.jogo.enums;

public enum Motivacao {
    VINGANCA("Não foi possível concluir sua vingança, e agora resta saber se alguém se vingará por você."),
    GLORIA("A glória que buscavas não será sua, e a cidade aguarda por seu próximo herói.",
            "A glória que buscavas não será sua, e a cidade aguarda por sua próxima heroina.");

    private String frase = null;
    private String fraseM = null;
    private String fraseF = null;

    Motivacao(String fraseM, String fraseF) {
        this.fraseM = fraseM;
        this.fraseF = fraseF;
    }

    Motivacao(String frase) {
        this.frase = frase;
    }

    public String getFrase() {
        return frase;
    }

    public String getFraseM() {
        return fraseM;
    }

    public String getFraseF() {
        return fraseF;
    }
}
