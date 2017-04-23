package br.com.florencio.relogio;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JPanel;

public class Painel extends JPanel {
	private static final long serialVersionUID = 1L;
	private DateFormat format = new SimpleDateFormat("HH:mm:ss");
	private String string = "";
	private Relogio relogio;

	public Painel(int largura, int altura) {
		relogio = new Relogio();
		relogio.config(largura, altura);
		new THREAD().start();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.drawString(string, 10, 10);
		relogio.desenhar(g2);
	}

	private void montarString(Calendar c) {
		string = format.format(c.getTime());
	}

	class THREAD extends Thread {

		@Override
		public void run() {
			while (true) {
				Calendar c = Calendar.getInstance();
				montarString(c);
				relogio.atualizar(c);
				repaint();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

}