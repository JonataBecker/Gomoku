package br.com.gomoku;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável pelo controle de peças
 */
public class ControlePeca {
    
    /** Instância do objeto responsável pelo controle de peças */
    private static ControlePeca peca;
    /** Matriz de peças */
    private final Peca[][] pecas;
    
    /**
     * Construtor privado da classe de controle de peças
     */
    private ControlePeca() {
        this.pecas = new Peca[Gomoku.ELEMENTOS][Gomoku.ELEMENTOS];
    }
    
    /**
     * Adiciona peca
     * 
     * @param x Posição x
     * @param y Posição y
     */
    public void addPeca(int x, int y) {
        Jogador jogador = ControleJogador.getInstance().getJogador();
        pecas[x][y] = new Peca(jogador.getTipoPeca(), new Point(x, y));
    }
    
    /**
     * Retorna lista de peças
     * 
     * @return {@code List<Peca>}
     */
    public List<Peca> getPeca() {
        List<Peca> list = new ArrayList<>();
        for (int x=0; x<Gomoku.ELEMENTOS; x++) {
            for (int y=0; y<Gomoku.ELEMENTOS; y++) {
                // Se existir peças
                if (pecas[x][y] != null) {
                    list.add(pecas[x][y]);
                }
            }
        }
        return list;
    }
    
    /**
     * Retorna instância do objeto de controle de peças
     * 
     * @return Peca
     */
    public static ControlePeca getInstance() {
        if (peca == null) {
            peca = new ControlePeca();
        }
        return peca;
    }
}
