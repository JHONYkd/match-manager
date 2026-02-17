package repositorio;

import modelo.Endereco;
import modelo.Evento;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventoRepositorio {
    public Evento salvar(Evento evento) {
        String sql = """
                INSERT INTO evento (nome, data_hora, preco) VALUES (?, ?, ?)
                              RETURNING id
                """;


        try {
            Connection conn = Conexao.getConexao();
            PreparedStatement ps = conn.prepareStatement(sql);


            ps.setString(1, String.valueOf(evento.getId()));
            ps.setLong(2, evento.getCusto());
            ps.setString(3, evento.getLocal().getEndereco());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                evento.setId(rs.getLong("id"));
            }
            return evento;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar evento", e);
        }
    }

    public void BuscarPorId(Evento evento) {

        String sql = """
                  SELECT e.id, e.nome, e.data_hora, e.preco, en.id AS endereco_id, en.nome_estabelecimento
                  FROM evento e
                  JOIN endereco en ON en.id = e.endereco_id
                  WHERE e.id = ?;
        """;
        try {
            Connection conn = Conexao.getConexao();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setLong(1, Endereco.id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Endereco endereco = new Endereco();
                endereco.setId(rs.getLong("id"));
                evento.setDatahora(rs.getTime("dara_hora").toLocalTime());
                evento.setCusto(rs.getLong("custo"));
                evento.setLocal(endereco);

                return evento;
            }

            return null;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar evento", e);


        }
    }

    public List<Evento> listarTodos() {

        String sql = """
                          SELECT * FROM evento;
                """;

        List<Evento> eventos = new ArrayList<>();

        try {
            Connection conn = Conexao.getConexao();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Evento evento = new Evento();
                evento.setId(rs.getLong("id"));
                evento.setDatahora((rs.getTime("data_hora")));
                evento.setCusto(rs.getLong("custo"));

                eventos.add(evento);

            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar eventos", e);
        }

        return eventos;

    }

    public void atualizar(Evento evento) {
        String sql = """
                          UPDATE evento
                          SET nome = ?, data_hora = ?, preco = ?
        """;
        try {
            Connection conn = Conexao.getConexao();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setLong(1, evento.getId());
            ps.setLong(2, evento.getCusto());
            ps.setLong(3, evento.getLocal().getId());
            ps.setTime(4, evento.getDatahora());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar evento", e);
        }

    }

    public void delete(long id) {
        String sql = """
                          DELETE FROM evento WHERE id = ?;
                          
        """;
        try {
            Connection conn = Conexao.getConexao();
            PreparedStatement ps = conn.prepareStatement(sql)

            ps.setLong(1, id);
            ps.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar evento", e);
        }
    }

}
