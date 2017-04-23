package br.com.florencio.relogio;

import static java.lang.Math.PI;

public class Vetor {
	final double rad = PI / 180;
	float a;
	float b;
	float x;
	float y;

	Vetor(float x, float y) {
		this.x = x;
		this.y = y;
		a = x;
		b = y;
	}

	void reiniciar() {
		x = a;
		y = b;
	}

	void rotacionar(int grau) {
		double cos = Math.cos(grau * rad);
		double sen = Math.sin(grau * rad);
		double novoX = x * cos - y * sen;
		double novoY = x * sen + y * cos;
		x = (float) novoX;
		y = (float) novoY;
	}

	public String toString() {
		return "Vetor[x=" + x + ", y=" + y + "]";
	}

}