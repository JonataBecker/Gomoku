package br.com.gomoku.exception;

/**
 * Exception de controle de adição de peças
 */
public class ExceptionPeca extends Exception {

    /**
     * Construtor da exception de controle de adição de peças recebendo uma mensagem
     *
     * @param messege Mensagem
     */
    public ExceptionPeca(String messege) {
        super(messege);
    }

}
