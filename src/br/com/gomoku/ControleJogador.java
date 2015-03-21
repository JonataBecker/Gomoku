package br.com.gomoku;

/**
 * Classe responsável pelo controle do jogador
 */
public class ControleJogador {

    /** Controle do jogador */
    private static ControleJogador controleJogador;
    /** Informações do jogador */
    private Jogador jogador;

    /**
     * Construtor privad da classe resposável pelo controle do jogador
     */
    private ControleJogador() {
    }

    /**
     * Adiciona jogador
     */
    public void addJogador() {
        jogador = new Jogador(TipoPecaEnum.BRANCA);
    }

    /**
     * Retorna jogador
     *
     * @return Jogador
     */
    public Jogador getJogador() {
        return jogador;
    }

    /**
     * Retorna instância de controle de jogador
     *
     * @return ControleJogador
     */
    public static ControleJogador getInstance() {
        if (controleJogador == null) {
            controleJogador = new ControleJogador();
        }
        return controleJogador;
    }

}
