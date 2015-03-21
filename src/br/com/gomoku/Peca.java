package br.com.gomoku;

import java.awt.Point;

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
}
