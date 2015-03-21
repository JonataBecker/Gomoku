package br.com.gomoku;

/**
 * Classe responável por informações do jogador
 */
public class Jogador {

    /** Tipo de peças */
    private final TipoPecaEnum tipoPeca;

    /**
     * Construtor padrão da classe responsável por informações do jogador
     *
     * @param tipoPeca Tipo de peça
     */
    public Jogador(TipoPecaEnum tipoPeca) {
        this.tipoPeca = tipoPeca;
    }

    /**
     * Retorna o tipo da peça
     *
     * @return TipoPecaEnum
     */
    public TipoPecaEnum getTipoPeca() {
        return tipoPeca;
    }

}
