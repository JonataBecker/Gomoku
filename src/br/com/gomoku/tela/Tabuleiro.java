package br.com.gomoku.tela;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

/**
 * Classe responsável pelo controle do tabuleiro
 */
public class Tabuleiro extends JPanel {

    /** Número de celulas */
    private static final int NUM = 19;
    /** Tamanho das celulas */
    private static final int TAM_CEL = 30;
    /** Tamanho da margin */
    private static final int MARGIN = 30;
    /** Borda */
    private static final int BORDA = 8;
    /** Tamanho do tabuleiro */
    private static final int TAM_TABULEIRO = BORDA + 8 + MARGIN * 2 + NUM * (TAM_CEL - 1);
    /** Ponto de hover do mouse */
    private Point mouseHover;
    
    /**
     * Construtor padrão da classe reponsável pelo controle do tabuleiro
     */
    public Tabuleiro() {
        int tam = TAM_TABULEIRO + BORDA;
        setBackground(Gomoku.BACKGROUND);
        setVisible(true);
        addMouseMotionListener(new TabuleiroMotionListener());
        setPreferredSize(new Dimension(tam, tam));
    }        

    /**
     * Desenha janela
     * 
     * @param g 
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g); 
        Graphics2D g2 = (Graphics2D) g;
        int pos = BORDA / 2;
        int ini = (pos / 2) + MARGIN;
        // Desenha tabuleiro
        for (int i=0; i<NUM; i++) {
            for (int j=0; j<NUM; j++) {
                int posX = ini + i * TAM_CEL;
                int posY = ini + j * TAM_CEL;
                // Se deve adicionar hover
                if (isAdicionaHover(posX, posY)) {
                    g2.setPaint(new Color(0x2F6796));
                    g2.fill(new Rectangle2D.Double(posX, posY, TAM_CEL, TAM_CEL));
                }
                g2.setPaint(Color.black);
                g2.drawRect(posX, posY, TAM_CEL, TAM_CEL);
            }
        }
        g2.setColor(Color.BLACK); 
        g2.setStroke(new BasicStroke(BORDA));
        g2.drawRect(pos, pos, TAM_TABULEIRO, TAM_TABULEIRO);
    }

    /**
     * Retorna verdadeiro se deve ser adicionar hover no tabuleiro
     * 
     * @param posX Posição X
     * @param posY Posição Y
     * @return boolean
     */
    private boolean isAdicionaHover(int posX, int posY) {
        if (mouseHover == null) {
            return false;
        }
        return (mouseHover.x > posX && mouseHover.x < (posX + TAM_CEL)) &&
                (mouseHover.y > posY && mouseHover.y < (posY + TAM_CEL));
    }
    
    /**
     * Adiciona hover no tabuleiro
     * 
     * @param e Evento
     */
    private void hover(MouseEvent e) {
        mouseHover = e.getPoint();
        repaint();
    }    

    /**
     * Classe responsável pelo evento de movimento do mouse 
     */
    private class TabuleiroMotionListener implements MouseMotionListener {

        @Override
        public void mouseDragged(MouseEvent e) {
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            hover(e);
        }
    }
}
