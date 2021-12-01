class Jogador1 {
  int? idJogador;
  String? nomeJogador;
  int? idade;
  String? nomeComum;
  int? altura;
  int? peso;
  String? aniversario;
  int? idLiga;
  int? idPais;
  int? idEquipe;
  int? idRaridade;
  String? posicao;
  int? estrelaDrible;
  int? pernaRuim;
  String? perna;
  String? dedicacaoAtaque;
  String? dedicacaoDefesa;
  int? geral;
  int? velocidade;
  int? chute;
  int? passe;
  int? drible;
  int? defesa;
  int? fisico;

  Jogador1(
      {this.idJogador,
      this.nomeJogador,
      this.idade,
      this.nomeComum,
      this.altura,
      this.peso,
      this.aniversario,
      this.idLiga,
      this.idPais,
      this.idEquipe,
      this.idRaridade,
      this.posicao,
      this.estrelaDrible,
      this.pernaRuim,
      this.perna,
      this.dedicacaoAtaque,
      this.dedicacaoDefesa,
      this.geral,
      this.velocidade,
      this.chute,
      this.passe,
      this.drible,
      this.defesa,
      this.fisico});

  Jogador1.fromJson(Map<String, dynamic> json) {
    idJogador = json['idJogador'];
    nomeJogador = json['nomeJogador'];
    idade = json['idade'];
    nomeComum = json['nomeComum'];
    altura = json['altura'];
    peso = json['peso'];
    aniversario = json['aniversario'];
    idLiga = json['idLiga'];
    idPais = json['idPais'];
    idEquipe = json['idEquipe'];
    idRaridade = json['idRaridade'];
    posicao = json['posicao'];
    estrelaDrible = json['estrelaDrible'];
    pernaRuim = json['pernaRuim'];
    perna = json['perna'];
    dedicacaoAtaque = json['dedicacaoAtaque'];
    dedicacaoDefesa = json['dedicacaoDefesa'];
    geral = json['geral'];
    velocidade = json['velocidade'];
    chute = json['chute'];
    passe = json['passe'];
    drible = json['drible'];
    defesa = json['defesa'];
    fisico = json['fisico'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['idJogador'] = this.idJogador;
    data['nomeJogador'] = this.nomeJogador;
    data['idade'] = this.idade;
    data['nomeComum'] = this.nomeComum;
    data['altura'] = this.altura;
    data['peso'] = this.peso;
    data['aniversario'] = this.aniversario;
    data['idLiga'] = this.idLiga;
    data['idPais'] = this.idPais;
    data['idEquipe'] = this.idEquipe;
    data['idRaridade'] = this.idRaridade;
    data['posicao'] = this.posicao;
    data['estrelaDrible'] = this.estrelaDrible;
    data['pernaRuim'] = this.pernaRuim;
    data['perna'] = this.perna;
    data['dedicacaoAtaque'] = this.dedicacaoAtaque;
    data['dedicacaoDefesa'] = this.dedicacaoDefesa;
    data['geral'] = this.geral;
    data['velocidade'] = this.velocidade;
    data['chute'] = this.chute;
    data['passe'] = this.passe;
    data['drible'] = this.drible;
    data['defesa'] = this.defesa;
    data['fisico'] = this.fisico;
    return data;
  }
}
