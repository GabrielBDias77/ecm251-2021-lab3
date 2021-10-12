import dao.JogadoresDAO


fun main(args: Array<String>) {
    val jogadoresDao = JogadoresDAO()
    val jogadores = jogadoresDao.pegarUm(1)

}
