package br.brilhodospes.main;

import java.util.List;

import br.brilhodospes.dao.ProdutoDAO;
import br.brilhodospes.model.Produto;

public class Principal {

    public static void main(String[] args) {
        ProdutoDAO dao = new ProdutoDAO();

        System.out.println("=== 1. TESTANDO O 'CREATE' ===");
        dao.cadastrar(new Produto("Tênis Esportivo", 40, "Preto", 199.90, 15));
        dao.cadastrar(new Produto("Sandália Rasteira", 36, "Branco", 79.90, 30));
        dao.cadastrar(new Produto("Bota de Couro", 42, "Marrom", 259.90, 8));

        System.out.println();
        System.out.println("=== 2. TESTANDO O 'READ' ===");
        listarEstoque(dao);

        System.out.println();
        System.out.println("=== 3. TESTANDO O 'UPDATE' ===");
        // Simula uma venda: baixa no estoque e reajuste de preço do produto de ID 1
        dao.atualizar(1, 179.90, 14);
        listarEstoque(dao);

        System.out.println();
        System.out.println("=== 4. TESTANDO O 'DELETE' ===");
        // Remove um produto que saiu de linha
        dao.remover(2);

        System.out.println();
        System.out.println("=== RESULTADO FINAL NO ESTOQUE ===");
        listarEstoque(dao);
    }

    private static void listarEstoque(ProdutoDAO dao) {
        List<Produto> produtos = dao.listarTodos();
        for (Produto p : produtos) {
            System.out.println(p);
        }
    }
}
