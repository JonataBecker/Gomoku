package br.com.gomoku;

/**
 * Classe responsável pelo controle do jogador
 */
public class ControleJogador {

    /** Controle do jogador */
    private static ControleJogador controleJogador;
    /** Informações do jogador 1 */
    private final Jogador jogador1;
    /** Informações do jogador 2 */
    private final Jogador jogador2;
    /** Informações do jogador 1 */
    private Jogador jogador;
    
    /**
     * Construtor privad da classe resposável pelo controle do jogador
     */
    private ControleJogador() {
        jogador1 = new Jogador(TipoPecaEnum.BRANCA);
        jogador2 = new Jogador(TipoPecaEnum.PRETA);
        jogador = jogador1;
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
     * Realiza troca de jogador
     */
    public void trocaJogador() {
        if (jogador.equals(jogador1)) {
            jogador = jogador2;
            return;
        }
        jogador = jogador1;
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
