package br.com.ProjetoKraftHeinz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbManager {

    private static DbManager conexao;

    private DbManager() {
    }

    public static DbManager getInstance() {
        if (conexao == null) {
            conexao = new DbManager();
        }
        return conexao;
    }

    public Connection obterConexao() {
        Connection conexao = null;
        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");

            conexao = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "RM97177",
                    "150889");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conexao;
    }

}

