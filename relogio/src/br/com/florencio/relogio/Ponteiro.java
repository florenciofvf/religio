package br.com.florencio.relogio;

import java.awt.Graphics2D;
import java.util.Calendar;

public abstract class Ponteiro {
	Vetor vetor;

	Ponteiro(int comprimento) {
		vetor = new Vetor(0, -comprimento);
	}

	abstract void atualizar(Calendar c);

	abstract void desenhar(Graphics2D g2, int x, int y);

}