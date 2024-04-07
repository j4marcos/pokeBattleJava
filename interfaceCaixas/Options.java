package interfaceCaixas; 

import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import java.awt.Font;
import java.awt.FontFormatException;


import javax.swing.JButton;
import javax.swing.JPanel;

public class Options extends JPanel {
    public Options() {
        editar();
    }

    public void editar() {
        setLayout(new GridLayout(2, 1));

        botao("FIGHT"); 
        botao("BAG"); 
        botao("POKEMON"); 
        botao("RUN"); 
    }

    public void botao(String nome) {
        JButton botao = new JButton(nome);

        try {
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("assents/font/pokemon_fire_red.ttf"));
            botao.setFont(customFont.deriveFont(Font.PLAIN, 22)); 
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
        botao.addActionListener(e -> {
            if (nome.equals("FIGHT")) {
                System.out.println(nome + " apertado!");
            } else if (nome.equals("BAG")) {
                System.out.println(nome + " apertado!");
            } else if (nome.equals("POKEMON")) {
                System.out.println(nome + " apertado!");
            } else if (nome.equals("RUN")) {
                System.out.println(nome + " apertado!");
            }
        });
        add(botao);
    }
}
