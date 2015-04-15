package br.com.gomoku.comunicacao;

import br.com.gomoku.Config;
import br.com.gomoku.ControlePeca;
import br.com.gomoku.Gomoku;
import br.com.gomoku.PecaListner;
import br.com.gomoku.VitoriaListner;

/**
 * Classe responsável pelo controle de comunicação
 */
public class ControleComunicacao {

    /** Objeto responsável pelo controle de comunicação */
    private static ControleComunicacao controleComunicacao;
    
    /**
     * Construtor privado da classe de controle de comunicação
     */
    private ControleComunicacao() {
        ControlePeca.getInstance().addPecaListner(new PecaListnerComunicacao());
        ControlePeca.getInstance().addVitoriaListner(new VitoriaListnerComunicacao());
    }
    
    /**
     * Executa rotinas iniciais de comunicação
     */
    public void inicia () {
        getComunicacao().inicia();
    }
    
    /**
     * Rotina executada quando houve adição de peça
     */
    private void pecaAdicionada() {
        getComunicacao().envia();
    }

    /**
     * Rotina executada quando houve fim do jogo
     */
    private void fimJogo() {
        getComunicacao().envia();
        Gomoku.openJanelaFimJogo();
    }
    
    /**
     * Retorna objeto responsável pela comunicação de dados
     * 
     * @return Comunicacao
     */
    private Comunicacao getComunicacao() {
        return Config.getInstance().getTipoComunicacao().getComunicacao();
    }
    
    /**
     * Retorna instância da classe de controle de comunicação
     * 
     * @return ControleComunicacao
     */
    public static ControleComunicacao getInstance() {
        if (controleComunicacao == null) {
            controleComunicacao = new ControleComunicacao();
        }
        return controleComunicacao;
    }

    /**
     * Classe responsável pelo listner de adição de peças
     */
    private class PecaListnerComunicacao implements PecaListner {

        /**
         * Peça adicionada
         */
        @Override
        public void add() {
            pecaAdicionada();
        }
        
    }
    
    /**
     * Classe responsável pelo listner de vitórias
     */
    private class VitoriaListnerComunicacao implements VitoriaListner {

        /**
         * Ocorreu vitótia
         */
        @Override
        public void vitoria() {
            fimJogo();
        }
        
    }
    
}
