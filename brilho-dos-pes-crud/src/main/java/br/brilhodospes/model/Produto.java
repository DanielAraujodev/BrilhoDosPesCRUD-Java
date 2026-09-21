package br.brilhodospes.model;

public class Produto {

    private int id;
    private String nome;
    private int tamanho;
    private String cor;
    private double preco;
    private int quantidade;

    public Produto() {
    }

    public Produto(String nome, int tamanho, String cor, double preco, int quantidade) {
        this.nome = nome;
        this.tamanho = tamanho;
        this.cor = cor;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public Produto(int id, String nome, int tamanho, String cor, double preco, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.tamanho = tamanho;
        this.cor = cor;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return String.format("[%d] %s | Tam: %d | Cor: %s | R$ %.2f | Qtd: %d",
                id, nome, tamanho, cor, preco, quantidade);
    }
}
