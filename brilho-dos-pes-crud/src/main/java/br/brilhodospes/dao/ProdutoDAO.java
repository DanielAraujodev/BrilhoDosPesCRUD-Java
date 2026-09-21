package br.brilhodospes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.brilhodospes.conexao.Conexao;
import br.brilhodospes.model.Produto;

public class ProdutoDAO {

    // 1. CREATE (Cadastrar um novo produto)
    public void cadastrar(Produto produto) {
        String sql = "INSERT INTO produtos (nome, tamanho, cor, preco, quantidade) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, produto.getNome());
            stmt.setInt(2, produto.getTamanho());
            stmt.setString(3, produto.getCor());
            stmt.setDouble(4, produto.getPreco());
            stmt.setInt(5, produto.getQuantidade());

            stmt.executeUpdate();
            System.out.println("-> Produto '" + produto.getNome() + "' cadastrado!");

        } catch (Exception e) {
            System.err.println("Erro ao cadastrar produto: " + e.getMessage());
        }
    }

    // 2. READ (Consultar o estoque disponível)
    public List<Produto> listarTodos() {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM produtos";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Produto p = new Produto(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("tamanho"),
                        rs.getString("cor"),
                        rs.getDouble("preco"),
                        rs.getInt("quantidade"));
                produtos.add(p);
            }

        } catch (Exception e) {
            System.err.println("Erro ao listar produtos: " + e.getMessage());
        }

        return produtos;
    }

    // 3. UPDATE (Atualizar preço e/ou quantidade, por exemplo após uma venda)
    public void atualizar(int id, double novoPreco, int novaQuantidade) {
        String sql = "UPDATE produtos SET preco = ?, quantidade = ? WHERE id = ?";

        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, novoPreco);
            stmt.setInt(2, novaQuantidade);
            stmt.setInt(3, id);

            int linhas = stmt.executeUpdate();
            if (linhas > 0) {
                System.out.println("-> Produto ID " + id + " atualizado!");
            } else {
                System.out.println("-> Nenhum produto encontrado com ID " + id);
            }

        } catch (Exception e) {
            System.err.println("Erro ao atualizar produto: " + e.getMessage());
        }
    }

    // 4. DELETE (Remover um produto descontinuado)
    public void remover(int id) {
        String sql = "DELETE FROM produtos WHERE id = ?";

        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int linhas = stmt.executeUpdate();

            if (linhas > 0) {
                System.out.println("-> Produto ID " + id + " removido!");
            } else {
                System.out.println("-> Nenhum produto encontrado com ID " + id);
            }

        } catch (Exception e) {
            System.err.println("Erro ao remover produto: " + e.getMessage());
        }
    }
}
