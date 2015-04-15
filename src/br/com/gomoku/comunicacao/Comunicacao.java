package br.com.gomoku.comunicacao;

/**
 * Classe responsável pela comunicação entre maquinas
 */
public interface Comunicacao {

    /**
     * Inicia comunicação
     */
    public void inicia();
    
    /**
     * Envia dados
     */
    public void envia();
}
