package br.com.florencio.relogio;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Calendar;

public class Relogio {
	Vetor[] segundos = new Vetor[60];
	Vetor[] intervalos5 = new Vetor[12];
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

		segundo = new Segundo((int) (metade * .85));
		minuto = new Minuto((int) (metade * .75));
		hora = new Hora((int) (metade * .65));

		xOrigem = largura / 2;
		yOrigem = altura / 2;
		x = xOrigem - metade;
		y = yOrigem - metade;

		for (int i = 0; i < segundos.length; i++) {
			segundos[i] = new Vetor(0, metade);
			segundos[i].rotacionar(i * 6);
		}

		for (int i = 0; i < intervalos5.length; i++) {
			intervalos5[i] = new Vetor(0, metade);
			intervalos5[i].rotacionar(i * 30);
		}
	}

	void desenhar(Graphics2D g2) {
		g2.drawOval(x, y, tamanho, tamanho);

		for (Vetor v : segundos) {
			g2.drawLine(xOrigem, yOrigem, (int) (xOrigem + v.x), (int) (yOrigem + v.y));
		}

		g2.setStroke(new BasicStroke(3f));

		for (Vetor v : intervalos5) {
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