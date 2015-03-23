package br.com.gomoku.tela;

import java.awt.Frame;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 * Classe responsável pela janela de processamento
 */
public class JanelaProcessamento extends JDialog {

    /**
     * Controtor da janela de processamento
     * 
     * @param owner Frame para abertura da janela de processamento
     */
    public JanelaProcessamento(Frame owner) {
        super(owner, true);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        setLocationRelativeTo(owner);
        JLabel teste = new JLabel("Processando");
        getContentPane().add(teste);        
        pack();
    }
    
}
