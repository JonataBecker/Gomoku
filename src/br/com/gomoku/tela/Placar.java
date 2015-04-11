package br.com.gomoku.tela;

import br.com.gomoku.ControleJogador;
import br.com.gomoku.Gomoku;
import br.com.gomoku.Jogador;
import br.com.gomoku.TrocaJogadorListner;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Classe responsável pela adição do placar
 */
public class Placar extends JPanel {

    /** Background do jogador selecionado */
    private static final Color COR_SELECIONADA = new Color(0x858d93);    
    /** Labels de jogadores */
    private final Map<Jogador, JLabel> label;
    
    /**
     * Construtor padrão da classe responsável pela adição do placar
     */
    public Placar() {
        this.label = new HashMap<>();
        setBackground(Gomoku.BACKGROUND);
        setLayout(new BorderLayout());
        add(getPaneJogador(), BorderLayout.NORTH);
        controleJogadorSelecionado(ControleJogador.getInstance().getJogador());
        ControleJogador.getInstance().addTrocaJogadorListner(new TrocaJogadorListner() {

            @Override
            public void troca(Jogador jogador) {
                controleJogadorSelecionado(jogador);
            }
        });
    }

    /**
     * Controle de troca de jogador
     * 
     * @param jogador Jogador
     */
    private void controleJogadorSelecionado(Jogador jogador) {
        for (Map.Entry<Jogador, JLabel> entry : label.entrySet()) {
            Color cor = Gomoku.BACKGROUND;
            // Se for label do jogador atual
            if (entry.getKey().equals(jogador)) {
                cor = COR_SELECIONADA;
            }
            entry.getValue().setBackground(cor);
        }
    }
    
    /**
     * Retorna panel de jogadores
     * 
     * @return JPanel
     */
    private JPanel getPaneJogador() {
        JPanel pJogador = new JPanel();
        pJogador.setPreferredSize(new Dimension(Gomoku.LATERAL_WIDTH, 80));
        pJogador.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
        pJogador.setBackground(Gomoku.BACKGROUND);
        pJogador.setLayout(new GridLayout(2, 1,0 ,5));
        addJogador(ControleJogador.getInstance().getJogador1(), pJogador);
        addJogador(ControleJogador.getInstance().getJogador2(), pJogador);
        return pJogador;
    }
    
    /**
     * Adiciona jogador
     * 
     * @param jogador Jogador
     * @param pJogador Panel do jogador
     */
    private void addJogador(Jogador jogador, JPanel pJogador) {
        JLabel labelJogador = new JLabel(jogador.getDescricao().toUpperCase(), SwingConstants.CENTER);
        labelJogador.setFont(new Font("Arial", Font.BOLD, 15));
        labelJogador.setOpaque(true);
        labelJogador.setBackground(Gomoku.BACKGROUND);
        labelJogador.setBorder(BorderFactory.createLineBorder(Color.black));
        labelJogador.setPreferredSize(new Dimension(200, 30));
        pJogador.add(labelJogador);
        label.put(jogador, labelJogador);
    }
}
