package br.com.gomoku;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável pelo controle do jogador
 */
public class ControleJogador {

    /** Controle do jogador */
    private static ControleJogador controleJogador;
    /** Listner de troca de jogador */
    private final List<TrocaJogadorListner> listnerTrocaJogador;
    /** Informações do jogador 1 */
    private final Jogador jogador1;
    /** Informações do jogador 2 */
    private final Jogador jogador2;
    /** Informações do jogador 1 */
    private Jogador jogador;

    /**
     * Construtor privad da classe resposável pelo controle do jogador
     */
    private ControleJogador() {
        listnerTrocaJogador = new ArrayList<>();
        jogador1 = new Jogador(TipoPecaEnum.BRANCA, "Jogador 1");
        jogador2 = new Jogador(TipoPecaEnum.PRETA, "Jogador 2");
        jogador = jogador1;
        ControlePeca.getInstance().addVitoriaListner(new VitoriaListner() {

            @Override
            public void vitoria() {
                jogador.addVitorias();
            }
        });
    }

    /**
     * Retorna jogador que esta jogando
     *
     * @return Jogador
     */
    public Jogador getJogador() {
        return jogador;
    }

    /**
     * Retorna o jogador 1
     *
     * @return Jogador
     */
    public Jogador getJogador1() {
        return jogador1;
    }

    /**
     * Retorna o jogador 2
     *
     * @return Jogador
     */
    public Jogador getJogador2() {
        return jogador2;
    }

    /**
     * Realiza troca de jogador
     */
    public void trocaJogador() {
        if (jogador.equals(jogador1)) {
            jogador = jogador2;
        } else {
            jogador = jogador1;
        }
        fireListner(jogador);
    }

    /**
     * Adiciona listner de troca de jogador
     * 
     * @param listner Lister de controle de troca de jogador
     */
    public void addTrocaJogadorListner(TrocaJogadorListner listner) {
        listnerTrocaJogador.add(listner);
    }
    
    /**
     * Dipara listners de troca de jogador
     * 
     * @param jogador Novo jogador
     */
    private void fireListner(Jogador jogador) {
        for (TrocaJogadorListner listner : listnerTrocaJogador) {
            listner.troca(jogador);
        }
    }
    
    /**
     * Retorna instância de controle de jogador
     *
     * @return ControleJogador
     */
    public static ControleJogador getInstance() {
        if (controleJogador == null) {
            controleJogador = new ControleJogador();
        }
        return controleJogador;
    }

}
