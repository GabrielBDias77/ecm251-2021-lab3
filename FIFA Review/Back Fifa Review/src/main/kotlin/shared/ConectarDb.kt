package shared

import java.sql.DriverManager

class ConectarDb {
    companion object{

        val usuariodb = "admin"
        val senhadb = "admin"
        val host = "192.168.56.102"
        val banco_de_dados = "FIFA"
        val string_de_conexao_JDBC = "jdbc:mysql://[(host=${host},port=3306,user=${usuariodb},password=${senhadb})]/${banco_de_dados}"

    }
}