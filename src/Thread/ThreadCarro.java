package Thread;
import Entidade.Carro;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class ThreadCarro extends Thread {

	private Thread thread;

	private Carro carro;
	private Semaphore SM;

	private static final int MAXIMO_DESCANSO = 500;
	private static final int MAXIMO_Andamento = 50;

	private int distanciaTotal;
	private int distanciaPercorrida = 0;
	private int ultimoPulo;

	private ArrayList<Carro> _ListaCarros;
	private CorridaController corridaControle;

	public ThreadCarro(Carro Carrinho, Integer distanciaTotal) {

		this.carro = Carrinho;
		this.distanciaTotal = distanciaTotal;
		this.corridaControle = CorridaController.getInstance();

		_ListaCarros = new ArrayList<Carro>();

		carro.getListaCarros();

		_ListaCarros.add(Carrinho);

		this.carro.setCarros(_ListaCarros);

		for (Carro meuCarro : this.carro.getCarros()) {
			meuCarro.getNome();
			thread = new Thread(this, Carrinho.getNome());
			SM = new Semaphore(1);
			thread.start();
		}

		// thread = new Thread(this, Carrinho.getNome());
		// SM = new Semaphore(1);

		// thread.start();

	}

	public void pular(Carro _carro) {

		ultimoPulo = (int) (Math.random() * MAXIMO_Andamento);
		distanciaPercorrida += ultimoPulo;
		if (distanciaPercorrida > distanciaTotal) {
			distanciaPercorrida = distanciaTotal;
		}
	}

	private void avisarSituacao() {

		System.out.println(carro.getNome() + " Andou " + ultimoPulo + " M . A distancia percorrida foi de "
				+ distanciaPercorrida + "M!");
	}

	private void cruzarLinhaDeChegada() {
		try {
			SM.acquire();
			corridaControle.carroChegou(carro);
			SM.release();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void descansar() {
		int tempo = (int) (Math.random() * MAXIMO_DESCANSO);
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (distanciaPercorrida < distanciaTotal) {
			pular(this.carro);
			avisarSituacao();
			descansar();

		}

		cruzarLinhaDeChegada();

	}
}