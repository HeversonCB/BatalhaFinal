package br.com.devinhouse.jogo.personagens;

public abstract class Personagem {
    private int saude;
    private int ataque;
    private int defesa;

    @Override
    public String toString() {
        return "Personagem{" +
                "saude=" + saude +
                ", ataque=" + ataque +
                ", defesa=" + defesa +
                '}';
    }

    public int getSaude() {
        return saude;
    }

    public void setSaude(int saude) {
        this.saude = saude;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }
}
