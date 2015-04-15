package br.com.gomoku.tela;

import br.com.gomoku.ControlePeca;
import br.com.gomoku.Gomoku;
import br.com.gomoku.Peca;
import br.com.gomoku.exception.ExceptionPeca;
import br.com.gomoku.image.CacheImage;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Classe responsável pelo controle do tabuleiro
 */
public class Tabuleiro extends JPanel {

    /** Tamanho das celulas */
    private static final int TAM_CEL = 30;
    /** Tamanho da margin */
    private static final int MARGIN = 30;
    /** Borda */
    private static final int BORDA = 8;
    /** Posição inicial de crição */
    private static final int INI = (BORDA / 4) + MARGIN;
    /** Tamanho do tabuleiro */
    private static final int TAM_TABULEIRO = BORDA + 8 + MARGIN * 2 + Gomoku.ELEMENTOS * (TAM_CEL - 1);
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
        addMouseListener(new TabuleiroMouseListener());
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
        // Desenha tabuleiro
        for (int i = 0; i < Gomoku.ELEMENTOS; i++) {
            for (int j = 0; j < Gomoku.ELEMENTOS; j++) {
                int posX = INI + i * TAM_CEL;
                int posY = INI + j * TAM_CEL;
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
        // Percorre peças
        for (Peca peca : ControlePeca.getInstance().getPeca()) {
            Point point = peca.getPoint();
            Image img = CacheImage.getInstanse().read(peca.getTipo().getNome());
            int posX = INI + point.x * TAM_CEL;
            int posY = INI + point.y * TAM_CEL;            
            g2.drawImage(img, posX, posY, this);
        }
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
     * Cliente no tabuleiro
     * 
     * @param e Evento
     */
    private void click(MouseEvent e) {
        try {
            int x = e.getPoint().x - INI;
            int y = e.getPoint().y - INI;
            int posX = (int) Math.floor(x / TAM_CEL);
            int posY = (int) Math.floor(y / TAM_CEL);
            // Se posição for inválida
            if (isPosicaoInvalida(posX, posY)) {
                return;
            }
            ControlePeca.getInstance().addPeca(posX, posY);
        } catch (ExceptionPeca ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        repaint();
    }
    
    /**
     * Retorna verdadeiro se posição é inválida
     * 
     * @param x Posição x
     * @param y Posição y
     * @return boolean
     */
    private boolean isPosicaoInvalida(int x, int y) {
        return (x < 0 || x > Gomoku.ELEMENTOS) ||
                (y < 0 || y > Gomoku.ELEMENTOS);
    }
    
    /**
     * Classe responsável pelos eventos de movimento do mouse
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
    
    /**
     * Classe responspavel pelos eventos de mouse
     */
    private class TabuleiroMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            click(e);
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
        
    }
}
