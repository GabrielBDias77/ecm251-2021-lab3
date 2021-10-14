import dao.JogadoresDAO


fun main(args: Array<String>) {
    val jogadoresDao = JogadoresDAO()
    jogadoresDao.pegarTodos()

}
