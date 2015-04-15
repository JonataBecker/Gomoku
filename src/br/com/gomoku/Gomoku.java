package br.com.gomoku;

import br.com.gomoku.comunicacao.ControleComunicacao;
import br.com.gomoku.tela.Menu;
import br.com.gomoku.tela.Novo;
import br.com.gomoku.tela.Placar;
import br.com.gomoku.tela.Tabuleiro;
import br.com.gomoku.tela.Topo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

/**
 * Classe responsável pela controle da janela principal
 */
public class Gomoku extends JFrame {
    
    /** Background padrão */
    public static final Color BACKGROUND = new Color(0x4682B4);
    /** Número de celulas */
    public static final int ELEMENTOS = 19;    
    /** Largura das larerais */
    public static final int LATERAL_WIDTH = 200;
    /** Largura mínima */
    private static final int W = 1000;
    /** Altura mínima */
    private static final int H = 760;    
    /** Janela principal */
    private static Gomoku gomoku;
    
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
        // Box placar
        add(new Placar(), BorderLayout.WEST);
        // Box Menu
        add(new Menu(), BorderLayout.EAST);
        // Box tabuleiro
        JPanel panelTabuleiro = new JPanel();
        panelTabuleiro.setBackground(Gomoku.BACKGROUND);
        panelTabuleiro.setLayout(new FlowLayout());
        panelTabuleiro.add(new Tabuleiro());
        add(panelTabuleiro, BorderLayout.CENTER);
        openJanelaNovoJogo();
    }

    /**
     * Executa abertura de janela de configurações de novo jogo
     */
    public static void openJanelaNovoJogo() {
        Novo novo = new Novo(gomoku);
        novo.setVisible(true);
        ControleComunicacao.getInstance().inicia();
        ControlePeca.getInstance().clear();
    }
    
    /**
     * Executa abertura de janela de finalização do jogo
     */
    public static void openJanelaFimJogo() {
        JOptionPane.showMessageDialog(gomoku, "Acabou o joguinho");
        ControlePeca.getInstance().clear();
    }    
    
    /**
     * Execução do Jogo
     * 
     * @param args 
     * @throws Exception Problema na excução
     */
    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        gomoku = new Gomoku();
    }
}
