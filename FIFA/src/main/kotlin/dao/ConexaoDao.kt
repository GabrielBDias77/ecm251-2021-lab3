package dao

import shared.ConectarDb
import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement

class ConexaoDao {
    val connection: Connection
    var statement : Statement?
    var resultSet : ResultSet?

    init {
        this.connection = DriverManager.getConnection(ConectarDb.string_de_conexao_JDBC)
        this.statement = null
        this.resultSet = null
    }

    fun executarQuery(sqlString:String) : ResultSet?{
        this.statement = this.connection.createStatement()
        this.resultSet = this.statement?.executeQuery(sqlString)
        return this.resultSet

    }

    fun fechar(){
        this.resultSet?.close()
        this.statement?.close()
        this.connection.close()
    }



}