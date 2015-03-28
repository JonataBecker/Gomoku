package br.com.gomoku;

import br.com.gomoku.exception.ExceptionConjuntoExiste;
import br.com.gomoku.exception.ExceptionPeca;
import org.junit.Test;
import static junit.framework.Assert.*;

/**
 * Classe responsável por teste de controle de peças
 */
public class ControlePecaTest {

    /**
     * Executa testa da rotina de adição de peças
     *
     * @throws ExceptionPeca
     * @throws ExceptionConjuntoExiste
     */
    @Test
    public void addPeca() throws ExceptionPeca, ExceptionConjuntoExiste {
        ControlePeca.getInstance().clear();
        ControlePeca.getInstance().addPeca(5, 5);
        assertTrue(ControlePeca.getInstance().isExistPeca(5, 5));
        assertFalse(ControlePeca.getInstance().isExistPeca(1, 5));
    }

    /**
     * Executa testa da rotina de adição de peças em posição de peça já existênte
     *
     * @throws ExceptionPeca
     * @throws ExceptionConjuntoExiste
     */
    @Test(expected = ExceptionPeca.class)
    public void addPecaExistente() throws ExceptionPeca, ExceptionConjuntoExiste {
        ControlePeca.getInstance().clear();
        ControlePeca.getInstance().addPeca(5, 5);
        ControlePeca.getInstance().addPeca(5, 5);
    }

    /**
     * Executa teste de conunto existênte na horizontal
     *
     * @throws ExceptionPeca
     * @throws ExceptionConjuntoExiste
     */
    @Test(expected = ExceptionConjuntoExiste.class)
    public void conjuntoExistenteHorizontal() throws ExceptionPeca, ExceptionConjuntoExiste {
        ControlePeca.getInstance().clear();
        ControlePeca.getInstance().addPeca(5, 1);
        ControlePeca.getInstance().addPeca(6, 1);
        ControlePeca.getInstance().addPeca(5, 2);
        ControlePeca.getInstance().addPeca(6, 2);
        ControlePeca.getInstance().addPeca(5, 3);
        ControlePeca.getInstance().addPeca(6, 3);
        ControlePeca.getInstance().addPeca(5, 4);
        ControlePeca.getInstance().addPeca(6, 4);
        ControlePeca.getInstance().addPeca(5, 5);
    }

    /**
     * Executa teste de conunto existênte na horizontal com falhas
     *
     * @throws ExceptionPeca
     * @throws ExceptionConjuntoExiste
     */
    @Test(expected = ExceptionConjuntoExiste.class)
    public void conjuntoExistenteHorizontalFalha() throws ExceptionPeca, ExceptionConjuntoExiste {
        ControlePeca.getInstance().clear();
        ControlePeca.getInstance().addPeca(5, 1);
        ControlePeca.getInstance().addPeca(5, 2);
        ControlePeca.getInstance().addPeca(5, 3);
        ControlePeca.getInstance().addPeca(5, 4);
        ControlePeca.getInstance().addPeca(5, 5);
        ControlePeca.getInstance().addPeca(6, 3);
        ControlePeca.getInstance().addPeca(5, 6);
        ControlePeca.getInstance().addPeca(6, 4);
        ControlePeca.getInstance().addPeca(5, 7);
        ControlePeca.getInstance().addPeca(2, 7);
        ControlePeca.getInstance().addPeca(5, 8);
        ControlePeca.getInstance().addPeca(7, 8);
        ControlePeca.getInstance().addPeca(5, 9);
    }

    /**
     * Executa teste de conunto existênte na vertical 
     *
     * @throws ExceptionPeca
     * @throws ExceptionConjuntoExiste
     */
    @Test(expected = ExceptionConjuntoExiste.class)
    public void conjuntoExistenteVertical() throws ExceptionPeca, ExceptionConjuntoExiste {
        ControlePeca.getInstance().clear();
        ControlePeca.getInstance().addPeca(2, 3);
        ControlePeca.getInstance().addPeca(2, 4);
        ControlePeca.getInstance().addPeca(3, 3);
        ControlePeca.getInstance().addPeca(3, 4);
        ControlePeca.getInstance().addPeca(4, 3);
        ControlePeca.getInstance().addPeca(4, 4);
        ControlePeca.getInstance().addPeca(5, 3);
        ControlePeca.getInstance().addPeca(5, 4);
        ControlePeca.getInstance().addPeca(6, 3);
    }
    
   /**
     * Executa teste de conunto existênte na vertical com falhas
     *
     * @throws ExceptionPeca
     * @throws ExceptionConjuntoExiste
     */
    @Test(expected = ExceptionConjuntoExiste.class)
    public void conjuntoExistenteVerticalFalha() throws ExceptionPeca, ExceptionConjuntoExiste {
        ControlePeca.getInstance().clear();
        ControlePeca.getInstance().addPeca(2, 3);
        ControlePeca.getInstance().addPeca(3, 3);
        ControlePeca.getInstance().addPeca(4, 3);
        ControlePeca.getInstance().addPeca(3, 2);
        ControlePeca.getInstance().addPeca(5, 3);
        ControlePeca.getInstance().addPeca(3, 7);
        ControlePeca.getInstance().addPeca(6, 3);
        ControlePeca.getInstance().addPeca(3, 8);
        ControlePeca.getInstance().addPeca(7, 3);
        ControlePeca.getInstance().addPeca(4, 8);
        ControlePeca.getInstance().addPeca(8, 3);
    }
    
    /**
     * Executa teste de conunto existênte na diagonal 
     *
     * @throws ExceptionPeca
     * @throws ExceptionConjuntoExiste
     */
    @Test(expected = ExceptionConjuntoExiste.class)
    public void conjuntoExistenteDiagonalX() throws ExceptionPeca, ExceptionConjuntoExiste {
        ControlePeca.getInstance().clear();
        ControlePeca.getInstance().addPeca(1, 1);
        ControlePeca.getInstance().addPeca(1, 2);
        ControlePeca.getInstance().addPeca(2, 2);
        ControlePeca.getInstance().addPeca(2, 3);
        ControlePeca.getInstance().addPeca(3, 3);
        ControlePeca.getInstance().addPeca(3, 4);
        ControlePeca.getInstance().addPeca(4, 4);
        ControlePeca.getInstance().addPeca(4, 5);
        ControlePeca.getInstance().addPeca(5, 5);
    }
    
    /**
     * Executa teste de conunto existênte na diagonal com falhas 
     *
     * @throws ExceptionPeca
     * @throws ExceptionConjuntoExiste
     */
    @Test(expected = ExceptionConjuntoExiste.class)
    public void conjuntoExistenteDiagonalXFalha() throws ExceptionPeca, ExceptionConjuntoExiste {    
        ControlePeca.getInstance().clear();
        ControlePeca.getInstance().addPeca(1, 1);
        ControlePeca.getInstance().addPeca(2, 2);
        ControlePeca.getInstance().addPeca(3, 3);
        ControlePeca.getInstance().addPeca(4, 3);
        ControlePeca.getInstance().addPeca(4, 4);
        ControlePeca.getInstance().addPeca(6, 4);
        ControlePeca.getInstance().addPeca(5, 5);
        ControlePeca.getInstance().addPeca(8, 5);
        ControlePeca.getInstance().addPeca(6, 6);
        ControlePeca.getInstance().addPeca(7, 6);
        ControlePeca.getInstance().addPeca(7, 7);
    }
    
    /**
     * Executa teste de conunto existênte na diagonal 
     *
     * @throws ExceptionPeca
     * @throws ExceptionConjuntoExiste
     */
    @Test(expected = ExceptionConjuntoExiste.class)
    public void conjuntoExistenteDiagonalY() throws ExceptionPeca, ExceptionConjuntoExiste {
        ControlePeca.getInstance().clear();
        ControlePeca.getInstance().addPeca(5, 1);
        ControlePeca.getInstance().addPeca(5, 2);
        ControlePeca.getInstance().addPeca(4, 2);
        ControlePeca.getInstance().addPeca(4, 3);
        ControlePeca.getInstance().addPeca(3, 3);
        ControlePeca.getInstance().addPeca(3, 4);
        ControlePeca.getInstance().addPeca(2, 4);
        ControlePeca.getInstance().addPeca(2, 5);
        ControlePeca.getInstance().addPeca(1, 5);
    }    
}
