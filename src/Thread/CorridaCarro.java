package Thread;

import Entidade.Carro;

import java.util.ArrayList;

public class CorridaCarro {

	public int distanciaTotal;

	private CorridaController corridaControle;

	public Carro _carro = new Carro(null);
	public ArrayList<Carro> CarroList;
	public ArrayList<Carro> _ListaCarros;

	public int quantidadeCarro;

	public CorridaCarro(int quantidadeCarros, int distanciaTotal) {
		this.distanciaTotal = distanciaTotal;
		this.quantidadeCarro = quantidadeCarros;

		this.corridaControle = CorridaController.getInstance();

		corridaControle.setQtdeCarros(quantidadeCarros);

	}

	public void preparar() {

		CarroList = new ArrayList<>();
		System.out.println("A corrida vai começar. -  " + quantidadeCarro + " Carro correndo um percurso de "
				+ distanciaTotal + "M. ");

		for (int i = 0; i < corridaControle.getQtdeCarros(); i++) {
			CarroList.add(new Carro("Carro " + (i + 1)));
			System.out.println("Carro " + (i + 1) + " preparado para corrida!");

		}

		this._carro._Carros = CarroList;
	}

	public void iniciar() {

		if (CarroList == null) {
			System.out.println("Os Carros devem ser preparados antes da corrida iniciar!");
		}

		for (Carro car : CarroList) {
			new Thread(new ThreadCarro(car, distanciaTotal));
		}

		while (!corridaControle.isFinalizada()) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void exibirResultado() {
		corridaControle.getCarrosChegada()
				.forEach((k, v) -> System.out.println(new String(k + "º lugar - " + ((Carro) v).getNome())));
	}
}
