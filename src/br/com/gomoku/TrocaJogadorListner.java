package br.com.gomoku;

/**
 * Listner de controle de troca de jogador
 */
public interface TrocaJogadorListner {

    /**
     * Troca de jogador
     * 
     * @param jogador Novo jogador
     */
    public void troca(Jogador jogador);
}
