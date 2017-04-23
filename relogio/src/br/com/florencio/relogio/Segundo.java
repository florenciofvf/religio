package br.com.florencio.relogio;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.util.Calendar;

public class Segundo extends Ponteiro {

	public Segundo(int comprimento) {
		super(comprimento);
	}

	@Override
	void atualizar(Calendar c) {
		int seg = c.get(Calendar.SECOND);
		if (seg != ultimo) {
			ultimo = seg;
			vetor.rotacionar(6);
		}
	}

	@Override
	public void desenhar(Graphics2D g2, int x, int y) {
		g2.setStroke(new BasicStroke(1f));
		g2.drawLine(x, y, (int) (x + vetor.x), (int) (y + vetor.y));
	}

	@Override
	void config(Calendar c) {
		int seg = c.get(Calendar.SECOND);
		ultimo = seg;
		vetor.rotacionar(seg * 6);
	}

}