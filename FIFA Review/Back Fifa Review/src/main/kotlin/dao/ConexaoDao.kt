package dao

import shared.ConectarDb
import java.sql.*

class ConexaoDao {
    val connection: Connection?
    var statement : Statement?
    var resultSet : ResultSet?
    var preparedStatement : PreparedStatement?

    init {
        this.connection = DriverManager.getConnection(ConectarDb.string_de_conexao_JDBC)
        this.statement = null
        this.resultSet = null
        this.preparedStatement = null
    }

    fun executarQuery(sqlString:String) : ResultSet?{
        this.statement = this.connection?.createStatement()
        this.resultSet = this.statement?.executeQuery(sqlString)
        return this.resultSet

    }

    fun fechar(){
        this.resultSet?.close()
        this.statement?.close()
        this.preparedStatement?.close()
        this.connection?.close()
    }

    fun getPreparedStatement(sqlString: String): PreparedStatement? {
        this.preparedStatement = this.connection?.prepareStatement(sqlString)
        return this.preparedStatement

    }

    fun commit() {
        this.connection?.commit()
    }


}