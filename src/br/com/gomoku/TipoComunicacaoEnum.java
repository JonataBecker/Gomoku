package br.com.gomoku;

import br.com.gomoku.comunicacao.Comunicacao;
import br.com.gomoku.comunicacao.ComunicacaoLocal;
import br.com.gomoku.comunicacao.ComunicacaoSerial;

/**
 * Enumerado de tipo de Comunicação
 */
public enum TipoComunicacaoEnum {
    
    /** Tipo de comunicação - Local */
    LOCAL(new ComunicacaoLocal()),
    /** Tipo de comunicação - Serial */
    SERIAL(new ComunicacaoSerial());
    
    /** Objeto responsável pela comunicação */
    private final Comunicacao comunicacao;
    
    /**
     * Construtor do enumerado de tipo de comunicação recebendo o objeto de comunicação
     * 
     * @param comunicacao Objeto responsável pela comunicação
     */
    private TipoComunicacaoEnum(Comunicacao comunicacao) {
        this.comunicacao = comunicacao;
    }
    
    /**
     * Retorna o objeto responsável pela comunicação de dados
     * 
     * @return Comunicacao
     */
    public Comunicacao getComunicacao() {
        return comunicacao;
    }
}
