package model;

public class Cliente {
    public String CPF;
    public String nome;
    public int idade;
    public double limiteCredito;

    public Cliente(String CPF, String nome, int idade, double limiteCredito) {
        this.CPF = CPF;
        this.nome = nome;
        this.idade = idade;
        this.limiteCredito = limiteCredito;
    }

    public Cliente() {
        super();
    }

    @Override
    public String toString() {
        return CPF + ";" + nome + ";" + idade + ";" + String.format("%.2f",limiteCredito);
    }
}
