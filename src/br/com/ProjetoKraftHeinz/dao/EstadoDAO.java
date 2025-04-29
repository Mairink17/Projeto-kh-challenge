package br.com.ProjetoKraftHeinz.dao;

import br.com.ProjetoKraftHeinz.beans.Estado;
import br.com.ProjetoKraftHeinz.jdbc.DbManager;

import java.sql.*;

import static br.com.ProjetoKraftHeinz.constantes.TabelaSistema.*;

public class EstadoDAO {

    private Connection conexao;

    public void cadastrar(Estado estado) {

        PreparedStatement stmt = null;

        try {
            conexao = DbManager.getInstance().obterConexao();

            String sql = " INSERT INTO " + TABESTADO + "(ID_ESTADO , DS_ESTADO , CD_SIGLA , CD_IBGE , FK_ID_PAIS ) VALUES " +
                    "( " + SQESTADO + ".NEXTVAL, ? , ? , ? , ?)";
            stmt = conexao.prepareStatement(sql);

            stmt.setString(1, estado.getDescricaoEstado());
            stmt.setString(2, estado.getSigla());
            stmt.setString(3, estado.getCodigoIbge());
            stmt.setLong(4, estado.getPais().getCodigo());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public Estado getConsulta(long idEstado){

        Estado estadoConsulta = new Estado();
        PreparedStatement stmt = null;

        ResultSet rs = null;

        try{
            conexao = DbManager.getInstance().obterConexao();

            stmt = conexao.prepareStatement("SELECT * FROM " + TABESTADO +" WHERE ID_ESTADO= "
                    + idEstado);
            rs = stmt.executeQuery();

            while (rs.next()){
                int codigo = rs.getInt("ID_ESTADO");
                String descricaoEstado = rs.getString("DS_ESTADO");
                String codSigla = rs.getString("CD_SIGLA");
                String codIbge = rs.getString("CD_IBGE");
                long idPais = rs.getLong("FK_ID_PAIS");


                Estado estado = new Estado(codigo, descricaoEstado,codSigla ,codIbge,
                        new PaisDAO().getConsulta(idPais));
                estadoConsulta  = estado;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try{
                stmt.close();
                rs.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return estadoConsulta;
    }
}
