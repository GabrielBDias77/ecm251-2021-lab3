import 'package:http/http.dart' as http;

class Networkhelper {
  static const webSiteURL = "http://localhost";
  static const jogadorRepositoryURL = "$webSiteURL/Jogador";

  static Future getData(url) async {
    http.Response response = await http.get(Uri.parse(url), headers: {
      "Accept": "application/json",
      "Access-Control-Allow-Origin": "*"
    });

    if (response.statusCode == 200) {
      // print(response.statusCode);
      return response.body;
    } else {
      throw Exception(
          'Http Get ERROR:${response.statusCode}: ${response.reasonPhrase}');
    }
  }
}
