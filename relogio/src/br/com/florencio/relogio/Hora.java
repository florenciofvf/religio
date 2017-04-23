package br.com.florencio.relogio;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.util.Calendar;

public class Hora extends Ponteiro {

	public Hora(int comprimento) {
		super(comprimento);
	}

	@Override
	void atualizar(Calendar c) {
		int hor = c.get(Calendar.HOUR);
		vetor.reiniciar();
		vetor.rotacionar(hor * 30);
	}

	@Override
	public void desenhar(Graphics2D g2, int x, int y) {
		g2.setStroke(new BasicStroke(3f));
		g2.drawLine(x, y, (int) (x + vetor.x), (int) (y + vetor.y));
	}

}