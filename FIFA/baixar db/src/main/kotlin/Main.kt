fun main(args: Array<String>) {
    for (i in 1..34) {
        val r = khttp.get(
            "https://futdb.app/api/clubs?page=${i}",
            headers = mapOf("X-AUTH-TOKEN" to "8932e420-7c26-4f18-a033-cce8616b87de")
        )

        println(r.text)
    }
    //até a 20 de players ja foi
}