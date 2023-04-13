package Thread;

import Entidade.Carro;

import java.util.HashMap;
import java.util.Map;

public class CorridaController {

    private boolean finalizada;

    private Map<Integer, Carro> CarroChegada;

    private static CorridaController corridaControle;

    private static int posicao;

    public int qtdeCarro;

    private CorridaController() {
        finalizada = false;
        posicao = 1;
    }

    public static CorridaController getInstance() {

        if (corridaControle == null) {
            corridaControle = new CorridaController();
        }

        return corridaControle;
    }

    public void carroChegou(Carro carro) {

        if (CarroChegada == null) {
            CarroChegada = new HashMap<>();
            posicao = 1;
        }

        CarroChegada.put(posicao++, carro);

        if (CarroChegada.size() == qtdeCarro) {
            finalizada = true;
        }
    }

    public void setQtdeCarros(int qtdeCarros) {
        this.qtdeCarro = qtdeCarros;
    }

    public int getQtdeCarros() {
        return qtdeCarro;
    }

    public boolean isFinalizada() {
        return finalizada;
    }

    public Map<Integer, Carro> getCarrosChegada() {
        return CarroChegada;
    }

    public void executa() {

    }
}