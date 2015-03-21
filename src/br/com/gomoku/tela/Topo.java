package br.com.gomoku.tela;

import br.com.gomoku.Gomoku;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Classe responsável pelo topo
 */
public class Topo extends JPanel {

    /**
     * Construtor padrão da classe responsável pela adição do topo
     */
    public Topo() {
        setBackground(Gomoku.BACKGROUND);
        titulo();
    }

    /**
     * Define título
     */
    private void titulo() {
        JLabel label = new JLabel("GOMOKU");
        label.setFont(new Font("Arial", Font.BOLD, 30));
        label.setForeground(Color.BLACK);
        label.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
        add(label);
    }
}
