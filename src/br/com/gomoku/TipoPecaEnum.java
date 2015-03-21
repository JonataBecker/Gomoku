package br.com.gomoku;

/**
 * Enumerado de peças
 */
public enum TipoPecaEnum {

    /** Tipo - Branca */
    BRANCA("peca_branca.png"),
    /** Tipo - Preta */
    PRETA("peca_preta.png");

    /** Nome da peça */
    private final String nome;

    /**
     * Construtor do enumerado de tipos de peças
     *
     * @param nome Nome da peça
     */
    private TipoPecaEnum(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o nome da peça
     *
     * @return String
     */
    public String getNome() {
        return nome;
    }
}
