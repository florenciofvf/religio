package br.com.florencio.relogio;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.util.Calendar;

public class Minuto extends Ponteiro {

	public Minuto(int comprimento) {
		super(comprimento);
	}

	@Override
	void atualizar(Calendar c) {
		int min = c.get(Calendar.MINUTE);
		if (min != ultimo) {
			ultimo = min;
			vetor.rotacionar(6);
		}
	}

	@Override
	public void desenhar(Graphics2D g2, int x, int y) {
		g2.setStroke(new BasicStroke(2f));
		g2.drawLine(x, y, (int) (x + vetor.x), (int) (y + vetor.y));
	}

	@Override
	void config(Calendar c) {
		int min = c.get(Calendar.MINUTE);
		ultimo = min;
		vetor.rotacionar(min * 6);
	}

}