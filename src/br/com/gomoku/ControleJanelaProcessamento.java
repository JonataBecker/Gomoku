package br.com.gomoku;

import br.com.gomoku.tela.JanelaProcessamento;
import java.awt.Frame;

/**
 * Classe responsável pelo controle de janela de processamento
 */
public class ControleJanelaProcessamento {

    /** Objeto responsável pelo controle de janelas de processamento */
    private static ControleJanelaProcessamento controleJanelaProcessamento;
    /** Janela de processamento */
    private JanelaProcessamento janelaProcessamento;

    /**
     * Executa abertura da janela de processamento
     *
     * @param frame Frame para abertura da janela
     */
    public void open(Frame frame) {
        janelaProcessamento = new JanelaProcessamento(frame);
        janelaProcessamento.setVisible(true);
    }

    /**
     * Executa fechamento da janela de processamento
     */
    public void close() {
        if (janelaProcessamento == null) {
            return;
        }
        janelaProcessamento.dispose();
    }

    /**
     * Retorna instância do controle de janela de processamento
     *
     * @return ControleJanelaProcessamento
     */
    public static ControleJanelaProcessamento getInstance() {
        if (controleJanelaProcessamento == null) {
            controleJanelaProcessamento = new ControleJanelaProcessamento();
        }
        return controleJanelaProcessamento;
    }

}
