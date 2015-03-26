package br.com.gomoku;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe responsável pelas configurações do sistema
 */
public class Config {

    /** Configuração - Tipo de comunicação */
    public static final String TIPO_COMUNICACAO = "tipoComunicacao";
    /** Objeto de configurações do sistema */
    private static Config config;
    /** Configurações */
    private final Map<String, Object> mapConf;
    
    /**
     * Construtor privado
     */
    private Config() {
        this.mapConf = new HashMap<>();
    }

    /**
     * Retorna o tipo de comunicação
     * 
     * @return TipoComunicacaoEnum
     */
    public TipoComunicacaoEnum getTipoComunicacao() {
        return getConfig(TIPO_COMUNICACAO, TipoComunicacaoEnum.LOCAL);
    }

    /**
     * Define o tipo de comunicação
     * 
     * @param tipoComunicacao 
     */
    public void setTipoComunicacao(TipoComunicacaoEnum tipoComunicacao) {
        setConfig(TIPO_COMUNICACAO, tipoComunicacao);
    }
    
    /**
     * Define configuração
     * 
     * @param key Chave
     * @param value Valor
     */
    private void setConfig(String key, Object value) {
        mapConf.put(key, value);
    }
    
    /**
     * Retorna configuração
     * 
     * @param <T> Tipo de valor
     * @param key Chave
     * @param def Default
     * @return T
     */
    private <T> T getConfig(String key, T def) {
        T value = (T) mapConf.get(key);
        if (value == null) {
            return def;
        }
        return value;
    }
    
    /**
     * Retorna instância da classe de configurações do sistema
     *
     * @return Config
     */
    public static Config getInstance() {
        if (config == null) {
            config = new Config();
        }
        return config;
    }

}
