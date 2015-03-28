package br.com.gomoku;

import br.com.gomoku.exception.ExceptionConjuntoExiste;
import br.com.gomoku.exception.ExceptionPeca;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável pelo controle de peças
 */
public class ControlePeca {

    /** Número de elementos que formam um conjunto */
    private static final int NUM_CONJUNTO = 5;
    /** Instância do objeto responsável pelo controle de peças */
    private static ControlePeca peca;
    /** Matriz de peças */
    private Peca[][] pecas;

    /**
     * Construtor privado da classe de controle de peças
     */
    private ControlePeca() {
        clear();
    }

    /**
     * Adiciona peca
     *
     * @param x Posição x
     * @param y Posição y
     * @throws ExceptionPeca Problema ao adiciona peça
     * @throws ExceptionConjuntoExiste Conjunto existênte
     */
    public void addPeca(int x, int y) throws ExceptionPeca, ExceptionConjuntoExiste {
        if (isExistPeca(x, y)) {
            throw new ExceptionPeca("Posição já ocupada por outra peça!");
        }
        Jogador jogador = ControleJogador.getInstance().getJogador();
        ControleJogador.getInstance().trocaJogador();
        pecas[x][y] = new Peca(jogador.getTipoPeca(), new Point(x, y));
        existeConjunto(pecas[x][y]);
    }

    /**
     * Retorna verdadeiro se ponto já existe
     *
     * @param x Posição X
     * @param y Posição Y
     * @return boolean
     */
    public boolean isExistPeca(int x, int y) {
        return pecas[x][y] != null;
    }

    /**
     * Retorna lista de peças
     *
     * @return {@code List<Peca>}
     */
    public List<Peca> getPeca() {
        List<Peca> list = new ArrayList<>();
        for (int x = 0; x < Gomoku.ELEMENTOS; x++) {
            for (int y = 0; y < Gomoku.ELEMENTOS; y++) {
                // Se existir peças
                if (pecas[x][y] != null) {
                    list.add(pecas[x][y]);
                }
            }
        }
        return list;
    }

    /**
     * Retorna lista de peças a partir de um ponto
     *
     * @param peca Peça
     * @return {@code List<List<Peca>>}
     */
    private List<List<Peca>> getPeca(Peca peca) {
        List<List<Peca>> lista = new ArrayList<>();
        lista.add(getPecaHorizontal(peca));
        lista.add(getPecaVertical(peca));
        lista.add(getPecaDiagonalX(peca));
        lista.add(getPecaDiagonalY(peca));
        return lista;
    }

    /**
     * Retorna lista de peças na horizontal a partir de um ponto
     *
     * @param peca Peça
     * @return {@code List<Peca>}
     */
    private List<Peca> getPecaHorizontal(Peca peca) {
        List<Peca> lista = new ArrayList<>();
        int xIni = trataNumero(peca.getPoint().x - NUM_CONJUNTO);
        int xFim = trataNumero(peca.getPoint().x + NUM_CONJUNTO);
        for (int i = xIni; i < xFim; i++) {
            lista.add(pecas[i][peca.getPoint().y]);
        }
        return lista;
    }

    /**
     * Retorna lista de peças na vertical a partir de um ponto
     *
     * @param peca Peça
     * @return {@code List<Peca>}
     */
    private List<Peca> getPecaVertical(Peca peca) {
        List<Peca> lista = new ArrayList<>();
        int yIni = trataNumero(peca.getPoint().y - NUM_CONJUNTO);
        int yFim = trataNumero(peca.getPoint().y + NUM_CONJUNTO);
        for (int i = yIni; i < yFim; i++) {
            lista.add(pecas[peca.getPoint().x][i]);
        }
        return lista;
    }

    /**
     * Retorna lista de peças na diagonal a partir de uma ponto
     *
     * @param peca Peça
     * @return {@code List<Peca>}
     */
    private List<Peca> getPecaDiagonalX(Peca peca) {
        List<Peca> lista = new ArrayList<>();
        int xIni = peca.getPoint().x;
        int yIni = peca.getPoint().y;
        if (xIni > 0 && yIni > 0) {
            for (int i = 0; i<NUM_CONJUNTO; i++) {
                xIni--;
                yIni--;
                if (xIni == 0 || yIni == 0) {
                    break;
                }
            }
        }
        int xFim = trataNumero(peca.getPoint().x + NUM_CONJUNTO);
        for (int i = xIni; i < xFim && yIni < Gomoku.ELEMENTOS; i++) {
            lista.add(pecas[i][yIni]);
            yIni++;
        }
        return lista;
    }

    /**
     * Retorna lista de peças na diagonal a partir de uma ponto
     *
     * @param peca Peça
     * @return {@code List<Peca>}
     */
    private List<Peca> getPecaDiagonalY(Peca peca) {
        List<Peca> lista = new ArrayList<>();
        int xIni = peca.getPoint().x;
        int yIni = peca.getPoint().y;
        if (xIni < Gomoku.ELEMENTOS && yIni > 0) {
            for (int i = 0; i<NUM_CONJUNTO; i++) {
                xIni++;
                yIni--;
                if (xIni == Gomoku.ELEMENTOS || yIni == 0) {
                    break;
                }
            }
        }
        int xFim = trataNumero(peca.getPoint().x - NUM_CONJUNTO);
        for (int i = xIni; i >= xFim && yIni < Gomoku.ELEMENTOS; i--) {
            lista.add(pecas[i][yIni]);
            yIni++;
        }
        return lista;
    }

    /**
     * Executa tratamento na posição, caso exceda o limite retorn o limite
     *
     * @param posicao Posição a ser tratada
     * @return int
     */
    private int trataNumero(int posicao) {
        if (posicao < 0) {
            return 0;
        }
        if (posicao > Gomoku.ELEMENTOS) {
            return Gomoku.ELEMENTOS;
        }
        return posicao;
    }

    /**
     * Verifica se existe um conjunto com o mesmo tipo de peça
     *
     * @param peca Peça
     * @throws ExceptionConjuntoExiste Conjento existente
     */
    public void existeConjunto(Peca peca) throws ExceptionConjuntoExiste {
        for (List<Peca> linha : getPeca(peca)) {
            int num = 0;
            for (Peca obj : linha) {
                // Se peças não possuirem o mesmo tipo
                if (!isEqualsTipoPeca(peca, obj)) {
                    num = 0;
                    continue;
                }
                num++;
                // Se possuir um conjunto
                if (num == NUM_CONJUNTO) {
                    throw new ExceptionConjuntoExiste();
                }
            }
        }
    }

    /**
     * Retorna verdadeiro se peças possuem o mesmo tipo
     *
     * @param peca Peça
     * @param obj Peça
     * @return boolean
     */
    private boolean isEqualsTipoPeca(Peca peca, Peca obj) {
        if (obj == null) {
            return false;
        }
        return peca.getTipo().equals(obj.getTipo());
    }

    /**
     * Inicializa controle de peças
     */
    public final void clear() {
        pecas = new Peca[Gomoku.ELEMENTOS][Gomoku.ELEMENTOS];
    }

    /**
     * Retorna instância do objeto de controle de peças
     *
     * @return Peca
     */
    public final static ControlePeca getInstance() {
        if (peca == null) {
            peca = new ControlePeca();
        }
        return peca;
    }
}
