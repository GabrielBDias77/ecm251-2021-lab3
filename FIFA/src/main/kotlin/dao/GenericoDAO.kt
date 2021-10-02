package dao

interface GenericoDAO {
    fun pegarUm(id:Int): Any;
    fun pegarTodos(): List<Any>;
    fun inserirUm(objeto:Any): Unit;
    fun inserirVarios(Lista: List<Any>): Unit;
    fun atualizar(objeto:Any): Unit;
    fun deletar(Id:Int): Unit;

}