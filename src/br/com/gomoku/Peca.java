package br.com.gomoku;

import java.awt.Point;
import java.util.Objects;

/**
 * Classe com informações de peças
 */
public class Peca {

    /** Tipo da peça */
    private final TipoPecaEnum tipo;
    /** Posição da imagem */
    private final Point point;

    /**
     * Construtor da classe responsável por informações de peças
     *
     * @param tipo Tipo da peças
     * @param point Posição da imagem
     */
    public Peca(TipoPecaEnum tipo, Point point) {
        this.tipo = tipo;
        this.point = point;
    }

    /**
     * Retorna o tipo da peça
     *
     * @return TipoPecaEnum
     */
    public TipoPecaEnum getTipo() {
        return tipo;
    }

    /**
     * Retorna a posição da imagem
     *
     * @return Point
     */
    public Point getPoint() {
        return point;
    }

    /**
     * Retorna hashcode
     *
     * @return int
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.tipo);
        hash = 29 * hash + Objects.hashCode(this.point);
        return hash;
    }

    /**
     * Retorna verdadeiro caso haja igualdede entre peças
     *
     * @param obj Objeto
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
        final Peca other = (Peca) obj;
        if (this.tipo != other.tipo) {
            return false;
        }
        if (!Objects.equals(this.point, other.point)) {
            return false;
        }
        return true;
    }

}
