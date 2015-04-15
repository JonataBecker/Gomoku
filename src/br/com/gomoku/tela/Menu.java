package br.com.gomoku.tela;

import br.com.gomoku.Gomoku;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
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
        setLayout(new BorderLayout());
        add(getBoxMenu(), BorderLayout.NORTH);
    }
    
    /**
     * Retorna box de menu
     * 
     * @return 
     */
    private JPanel getBoxMenu() {
        JButton button = new JButton("Novo Jogo");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Gomoku.openJanelaNovoJogo();
            }
        });
        JPanel panel = new JPanel();
        panel.setBackground(Gomoku.BACKGROUND);
        panel.add(button);        
        return panel;
    }
    
}
