fun main(args: Array<String>) {
    val r = khttp.get("https://viacep.com.br/ws/03129110/json/")
    println(r.statusCode)
// 200
   println(r.headers["Content-Type"])
// "application/json; charset=utf-8"
    println(r.text)
// """{"type": "User"..."""
    println(r.jsonObject)
// org.json.JSONObject
}