// ignore: file_names
// ignore_for_file: unnecessary_this, prefer_collection_literals, file_names

class Liga {
  int? idLiga;
  String? nomeLiga;
  int? idPais;

  Liga({this.idLiga, this.nomeLiga, this.idPais});

  Liga.fromJson(Map<String, dynamic> json) {
    idLiga = json['idLiga'];
    nomeLiga = json['nomeLiga'];
    idPais = json['idPais'];
  }

  Map<dynamic, dynamic> toJson() {
    final Map<dynamic, dynamic> data = Map<dynamic, dynamic>();
    data['idLiga'] = this.idLiga;
    data['nomeLiga'] = this.nomeLiga;
    data['idPais'] = this.idPais;
    return data as Map<String, dynamic>;
  }
}
