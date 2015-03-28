package br.com.gomoku;

import java.util.Objects;

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
