package br.com.gomoku.tela;

import br.com.gomoku.Config;
import br.com.gomoku.TipoComunicacaoEnum;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * Janela responsável por configurações de novo jogo
 */
public class Novo extends JDialog {

    /** Tipo de comunicação */
    private JComboBox<TipoComunicacaoEnum> tipoComunicacao;

    /**
     * Construtor da janela responsável por configurações de novo jogo
     *
     * @param gomoku
     */
    public Novo(Frame gomoku) {
        super(gomoku, true);
        setPreferredSize(new Dimension(200, 150));
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        panel.add(getBoxConfig(), BorderLayout.NORTH);
        panel.add(getButtonConfirmacao(), BorderLayout.SOUTH);
        add(panel);
        pack();
        setLocationRelativeTo(null);
    }

    /**
     * Retorna box de configurações
     *
     * @return JPanel
     */
    private JPanel getBoxConfig() {
        JPanel panelgrid = new JPanel();
        panelgrid.setLayout(new GridLayout(0, 1));
        JLabel label = new JLabel("Tipo de comunicação:");
        panelgrid.add(label);
        tipoComunicacao = new JComboBox<>(TipoComunicacaoEnum.values());
        tipoComunicacao.setPreferredSize(new Dimension(140, 20));
        tipoComunicacao.setSelectedItem(Config.getInstance().getTipoComunicacao());
        panelgrid.add(tipoComunicacao);
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(panelgrid, BorderLayout.WEST);
        return panel;
    }

    /**
     * Retorna botão de configurações
     *
     * @return JPanel
     */
    private JPanel getButtonConfirmacao() {
        JButton button = new JButton("Confirma");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Config.getInstance().setTipoComunicacao((TipoComunicacaoEnum) tipoComunicacao.getSelectedItem());
            }
        });
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(button, BorderLayout.EAST);
        return panel;
    }

}
