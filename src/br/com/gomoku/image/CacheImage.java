package br.com.gomoku.image;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.HashMap;

/**
 * Classe responsável por realizar cache de carregamento de imagens
 */
public class CacheImage {

    /** Objeto de cache de imagens */
    private static CacheImage cacheImage;
    /** Mapa de cache de imagens */
    private final HashMap<String, Image> cache;

    /**
     * Construtor privado para cache de imagens
     */
    private CacheImage() {
        this.cache = new HashMap<>();
    }
    
    /**
     * Executa leitura de imagem a partir de seu caminho
     * 
     * @param path Caminho da imagem
     * @return Imagem
     */
    public Image read(String path) {
        Image imagem = cache.get(path);
        if (imagem == null) {
            imagem = loadImage(path);
        }
        return imagem;
    }

    /**
     * Carrega imagem do disco para memória
     * 
     * @param path Caminho da imagem
     * @return Imagem
     */
    private Image loadImage(String path) {
        Toolkit tk = Toolkit.getDefaultToolkit();
        ClassLoader cl = getClass().getClassLoader();
        return tk.getImage(cl.getResource(path));        
    }
    
    /**
     * Retorna instância de cache de imagens
     * 
     * @return CacheImage
     */
    public static CacheImage getInstanse() {
        if (cacheImage == null) {
            cacheImage = new CacheImage();
        }
        return cacheImage;
    }
    
}
