package br.com.gomoku.tela;

import br.com.gomoku.Gomoku;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 * Classe responsável pelo menu
 */
public class Menu extends JPanel {

    /**
     * Construtor padrão da classe responsável pelo menu
     */
    public Menu() {
        setBackground(Gomoku.BACKGROUND);
        setPreferredSize(new Dimension(Gomoku.LATERAL_WIDTH, 5));
    }
    
}
