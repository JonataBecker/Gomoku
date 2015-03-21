package br.com.gomoku;

import br.com.gomoku.tela.Menu;
import br.com.gomoku.tela.Placar;
import br.com.gomoku.tela.Tabuleiro;
import br.com.gomoku.tela.Topo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Classe responsável pela controle da janela principal
 */
public class Gomoku extends JFrame {
    
    /** Background padrão */
    public static final Color BACKGROUND = new Color(0x4682B4);
    /** Número de celulas */
    public static final int ELEMENTOS = 19;    
    /** Largura mínima */
    private static final int W = 1000;
    /** Altura mínima */
    private static final int H = 760;    
    
    /**
     * Construtor da classe de controle da janela principal
     */
    public Gomoku() {
        super("Gomoku");
        setSize(W, H);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new BorderLayout());
        // Box topo
        add(new Topo(), BorderLayout.NORTH);
        // Box Menu
        add(new Menu(), BorderLayout.EAST);
        // Box placar
        add(new Placar(), BorderLayout.WEST);
        // Box tabuleiro
        JPanel panelTabuleiro = new JPanel();
        panelTabuleiro.setBackground(Gomoku.BACKGROUND);
        panelTabuleiro.setLayout(new FlowLayout());
        panelTabuleiro.add(new Tabuleiro());
        add(panelTabuleiro, BorderLayout.CENTER);
    }

    /**
     * Execução do Jogo
     * 
     * @param args 
     */
    public static void main(String[] args) {
        ControleJogador.getInstance().addJogador();
        Gomoku gomoku = new Gomoku();
    }
}
