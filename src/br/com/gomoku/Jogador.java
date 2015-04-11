package br.com.gomoku;

import java.util.Objects;

/**
 * Classe responável por informações do jogador
 */
public class Jogador {

    /** Tipo de peças */
    private final TipoPecaEnum tipoPeca;
    /** Descrição do jogador */
    private final String descricao;
    /** Número de vitórias */
    private int vitorias;
    
    /**
     * Construtor padrão da classe responsável por informações do jogador
     *
     * @param tipoPeca Tipo de peça
     * @param descricao Descrição
     */
    public Jogador(TipoPecaEnum tipoPeca, String descricao) {
        this.tipoPeca = tipoPeca;
        this.descricao = descricao;
        this.vitorias = 0;
    }

    /**
     * Retorna o tipo da peça
     *
     * @return TipoPecaEnum
     */
    public TipoPecaEnum getTipoPeca() {
        return tipoPeca;
    }

    /**
     * Retorna a descrição do jogador
     *
     * @return String
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Retorna o número de vitórias
     * 
     * @return int
     */
    public int getVitorias() {
        return vitorias;
    }

    /**
     * Incrementa número de vitórias
     */
    public void addVitorias() {
        vitorias = vitorias++;
    }
    
    /**
     * Retorna hashcode para o jogador
     *
     * @return int
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.tipoPeca);
        return hash;
    }

    /**
     * Verifica igualdade entre jogadores
     *
     * @param obj Jogador
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Jogador other = (Jogador) obj;
        if (this.tipoPeca != other.tipoPeca) {
            return false;
        }
        return true;
    }

}
