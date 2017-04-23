package br.com.florencio.relogio;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Calendar;

public class Relogio {
	Vetor[] vetores = new Vetor[60];
	Segundo segundo;
	Minuto minuto;
	int tamanho;
	int xOrigem;
	int yOrigem;
	Hora hora;
	int x;
	int y;

	void config(int largura, int altura) {
		tamanho = Math.min(largura, altura);
		int metade = tamanho / 2;

		xOrigem = largura / 2;
		yOrigem = altura / 2;
		x = xOrigem - metade;
		y = yOrigem - metade;

		for (int i = 0; i < vetores.length; i++) {
			vetores[i] = new Vetor(0, metade);
			vetores[i].rotacionar(i * 6);
		}
	}

	void config() {
		Calendar c = Calendar.getInstance();

		int metade = tamanho / 2;

		segundo = new Segundo((int) (metade * .85));
		minuto = new Minuto((int) (metade * .75));
		hora = new Hora((int) (metade * .65));

		segundo.config(c);
		minuto.config(c);
		hora.config(c);
	}

	void desenhar(Graphics2D g2) {
		g2.drawOval(x, y, tamanho, tamanho);

		for (Vetor v : vetores) {
			g2.drawLine(xOrigem, yOrigem, (int) (xOrigem + v.x), (int) (yOrigem + v.y));
		}

		g2.fillOval(x + 10, y + 10, tamanho - 20, tamanho - 20);

		g2.setColor(Color.WHITE);

		segundo.desenhar(g2, xOrigem, yOrigem);
		minuto.desenhar(g2, xOrigem, yOrigem);
		hora.desenhar(g2, xOrigem, yOrigem);
	}

	void atualizar(Calendar c) {
		segundo.atualizar(c);
		minuto.atualizar(c);
		hora.atualizar(c);
	}

}