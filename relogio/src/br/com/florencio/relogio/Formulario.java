package br.com.florencio.relogio;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Formulario extends JFrame {
	private static final long serialVersionUID = 1L;
	private Painel painel;

	public Formulario(int largura, int altura) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		painel = new Painel(largura, altura);
		setLayout(new BorderLayout());
		add(BorderLayout.CENTER, painel);
		setSize(largura, altura);
		setVisible(true);
	}

}