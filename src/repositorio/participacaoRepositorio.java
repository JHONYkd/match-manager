package repositorio;

import com.sun.jdi.connect.spi.Connection;
import modelo.ParticipacaoEvento;

import java.sql.DriverManager;
import java.sql.PreparedStatement;

import static repositorio.Conexao.conn;

public class participacaoRepositorio{
    public void salvarParticipacao(ParticipacaoEvento participacaoEvento){

        String dql = "INSERT INTO particioacaoevento (particioante, posicao, pago) values (?, ?, ?)";

        try (
                Connection conn = Conexao.getConexao();
                PreparedStatement ps = conn.prepareStatement(sql)
                ) {
               ps.setLong(parameterIndex1, );
        }
        }

    }
}
