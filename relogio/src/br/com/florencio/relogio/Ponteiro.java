package br.com.florencio.relogio;

import java.awt.Graphics2D;
import java.util.Calendar;

public abstract class Ponteiro {
	Vetor vetor;
	int ultimo;

	Ponteiro(int comprimento) {
		vetor = new Vetor(0, -comprimento);
	}

	abstract void config(Calendar c);

	abstract void atualizar(Calendar c);

	abstract void desenhar(Graphics2D g2, int x, int y);

}