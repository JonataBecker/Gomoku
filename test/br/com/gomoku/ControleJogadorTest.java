package br.com.gomoku;

import static junit.framework.Assert.*;
import org.junit.Test;

/**
 * Classe responsável por testar controle do jogador
 */
public class ControleJogadorTest {

    /**
     * Executa teste de troca de peça
     */
    @Test
    public void trocaPeca() {
        Jogador jogador1 = new Jogador(TipoPecaEnum.BRANCA);
        Jogador jogador2 = new Jogador(TipoPecaEnum.PRETA);
        assertEquals(jogador1, ControleJogador.getInstance().getJogador());
        ControleJogador.getInstance().trocaJogador();
        assertEquals(jogador2, ControleJogador.getInstance().getJogador());
        ControleJogador.getInstance().trocaJogador();
        assertEquals(jogador1, ControleJogador.getInstance().getJogador());
    }
}
