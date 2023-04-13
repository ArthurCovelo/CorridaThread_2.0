package Start;

import Thread.CorridaCarro;

public class Main {

	public static final int QNTD_Carros = 5;
	public static final int DISTANCIA_TOTAL = 200;

	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				CorridaCarro corridaCarro = new CorridaCarro(QNTD_Carros, DISTANCIA_TOTAL);

				corridaCarro.preparar();
				corridaCarro.iniciar();
				corridaCarro.exibirResultado();
			}
		}).start();
		;
	}
}

