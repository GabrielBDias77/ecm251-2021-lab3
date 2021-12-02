import 'dart:convert';

class Jogador {
  final int idJogador;
  final String nomeJogador;
  final int idade;
  final String nomeComum;
  final int altura;
  final int peso;
  final String aniversario;
  final int idLiga;
  final int idPais;
  final int idEquipe;
  final int idRaridade;
  final String posicao;
  final int estrelaDrible;
  final int pernaRuim;
  final String perna;
  final String dedicacaoAtaque;
  final String dedicacaoDefesa;
  final int geral;
  final int velocidade;
  final int chute;
  final int passe;
  final int drible;
  final int defesa;
  final int fisico;
  Jogador(
      {required this.idJogador,
      required this.nomeJogador,
      required this.idade,
      required this.nomeComum,
      required this.altura,
      required this.peso,
      required this.aniversario,
      required this.idLiga,
      required this.idPais,
      required this.idEquipe,
      required this.idRaridade,
      required this.posicao,
      required this.estrelaDrible,
      required this.pernaRuim,
      required this.perna,
      required this.dedicacaoAtaque,
      required this.dedicacaoDefesa,
      required this.geral,
      required this.velocidade,
      required this.chute,
      required this.passe,
      required this.drible,
      required this.defesa,
      required this.fisico});

  Map<String, dynamic> toMap() {
    return {
      'idJogador': idJogador,
      'nomeJogador': nomeJogador,
      'idade': idade,
      'nomeComum': nomeComum,
      'altura': altura,
      'peso': peso,
      'aniversario': aniversario,
      'idLiga': idLiga,
      'idPais': idPais,
      'idEquipe': idEquipe,
      'idRaridade': idRaridade,
      'posicao': posicao,
      'estrelaDrible': estrelaDrible,
      'pernaRuim': pernaRuim,
      'perna': perna,
      'dedicacaoAtaque': dedicacaoAtaque,
      'dedicacaoDefesa': dedicacaoDefesa,
      'geral': geral,
      'velocidade': velocidade,
      'chute': chute,
      'passe': passe,
      'drible': drible,
      'defesa': defesa,
      'fisico': fisico,
    };
  }

  factory Jogador.fromMap(Map<String, dynamic> map) {
    return Jogador(
      idJogador: map['idJogador']?.toInt(),
      nomeJogador: map['nomeJogador'],
      idade: map['idade']?.toInt(),
      nomeComum: map['nomeComum'],
      altura: map['altura']?.toInt(),
      peso: map['peso'].toInt(),
      aniversario: map['aniversario'],
      idLiga: map['idLiga'].toInt(),
      idPais: map['idPais'].toInt(),
      idEquipe: map['idEquipe'].toInt(),
      idRaridade: map['idRaridade'].toInt(),
      posicao: map['posicao'],
      estrelaDrible: map['estrelaDrible'].toInt(),
      pernaRuim: map['pernaRuim'].toInt(),
      perna: map['perna'],
      dedicacaoAtaque: map['dedicacaoAtaque'],
      dedicacaoDefesa: map['dedicacaoDefesa'],
      geral: map['geral'].toInt(),
      velocidade: map['velocidade'].toInt(),
      chute: map['chute'].toInt(),
      passe: map['passe'].toInt(),
      drible: map['drible'].toInt(),
      defesa: map['defesa'].toInt(),
      fisico: map['fisico'].toInt(),
    );
  }

  String toJson() => json.encode(toMap());

  factory Jogador.fromJson(String source) =>
      Jogador.fromMap(jsonDecode(source));

  static List<Jogador> listFromJson(String source) {
    List<Jogador> returnList = [];
    final sourceList = jsonDecode(source);

    if (sourceList is! List) {
      returnList.add(Jogador.fromJson(source));
      return returnList;
    }

    for (var element in sourceList) {
      returnList.add(Jogador.fromMap(element));
    }
    return returnList;
  }

  @override
  String toString() {
    return 'Jogador(idJogador: $idJogador, nomeJogador: $nomeJogador, idade: $idade, nomeComum: $nomeComum, altura: $altura, peso: $peso, aniversario: $aniversario, idLiga: $idLiga, idPais: $idPais, idEquipe: $idEquipe, idRaridade: $idRaridade, posicao: $posicao, estrelaDrible: $estrelaDrible, pernaRuim: $pernaRuim, perna: $perna, dedicacaoAtaque: $dedicacaoAtaque, dedicacaoDefesa: $dedicacaoDefesa, geral: $geral, velocidade: $velocidade, chute: $chute, passe: $passe, drible: $drible, defesa: $defesa, fisico: $fisico)';
  }

  @override
  bool operator ==(Object other) {
    if (identical(this, other)) return true;

    return other is Jogador &&
        other.idJogador == idJogador &&
        other.nomeJogador == nomeJogador &&
        other.idade == idade &&
        other.nomeComum == nomeComum &&
        other.altura == altura &&
        other.peso == peso &&
        other.aniversario == aniversario &&
        other.idLiga == idLiga &&
        other.idPais == idPais &&
        other.idEquipe == idEquipe &&
        other.idRaridade == idRaridade &&
        other.posicao == posicao &&
        other.estrelaDrible == estrelaDrible &&
        other.pernaRuim == pernaRuim &&
        other.perna == perna &&
        other.dedicacaoAtaque == dedicacaoAtaque &&
        other.dedicacaoDefesa == dedicacaoDefesa &&
        other.geral == geral &&
        other.velocidade == velocidade &&
        other.chute == chute &&
        other.passe == passe &&
        other.drible == drible &&
        other.defesa == defesa &&
        other.fisico == fisico;
  }

  @override
  int get hashCode {
    return idJogador.hashCode ^
        nomeJogador.hashCode ^
        idade.hashCode ^
        nomeComum.hashCode ^
        altura.hashCode ^
        peso.hashCode ^
        aniversario.hashCode ^
        idLiga.hashCode ^
        idPais.hashCode ^
        idEquipe.hashCode ^
        idRaridade.hashCode ^
        posicao.hashCode ^
        estrelaDrible.hashCode ^
        pernaRuim.hashCode ^
        perna.hashCode ^
        dedicacaoAtaque.hashCode ^
        dedicacaoDefesa.hashCode ^
        geral.hashCode ^
        velocidade.hashCode ^
        chute.hashCode ^
        passe.hashCode ^
        drible.hashCode ^
        defesa.hashCode ^
        fisico.hashCode;
  }
}
