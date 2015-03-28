package br.com.gomoku.exception;

/**
 * Exception lançada na existência de um conjunto válido
 */
public class ExceptionConjuntoExiste extends Exception {

    /**
     * Construtor padrão da exception de existência de conjunto válido
     */
    public ExceptionConjuntoExiste() {
        super("Conjento existênte");
    }

}
