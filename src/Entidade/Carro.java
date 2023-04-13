package Entidade;

import java.util.ArrayList;

public class Carro {

    private int posicao;
    private String nome;
    public ArrayList<Carro> _Carros;  

    public Carro(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }
    
   
    public ArrayList<Carro> getCarros() {
        return _Carros;
    }


    public void setCarros(ArrayList<Carro> carrinhos) {
        this._Carros = carrinhos;
    }
    
    public ArrayList<Carro> getListaCarros() {
        if (this._Carros == null) {
            this._Carros = new ArrayList<Carro>();
        }
        return this._Carros;
    }
}


