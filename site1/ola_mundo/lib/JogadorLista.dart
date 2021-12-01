import 'dart:html';

import 'package:flutter/material.dart';

import 'jogador.dart';
import 'network_helper.dart';

void main() => runApp(const MeuApp());

class MeuApp extends StatelessWidget {
  const MeuApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      title: 'Welcome to Flutter',
      home: JogadorListScroll(),
    );
  }
}

class JogadorListScroll extends StatefulWidget {
  const JogadorListScroll({Key? key}) : super(key: key);

  @override
  _JogadorListScrollState createState() => _JogadorListScrollState();
}

class _JogadorListScrollState extends State<JogadorListScroll> {
  final _jogadorlist = <Jogador>[
    Jogador(
        idJogador: 114,
        nomeJogador: "nomeJogador",
        idade: 30,
        nomeComum: "nomeComum",
        altura: 168,
        peso: 70,
        aniversario: "aniversario",
        idLiga: 13,
        idPais: 18,
        idEquipe: 5,
        idRaridade: 1,
        posicao: "posicao",
        estrelaDrible: 2,
        pernaRuim: 3,
        perna: "perna",
        dedicacaoAtaque: "dedicacaoAtaque",
        dedicacaoDefesa: "dedicacaoDefesa",
        geral: 90,
        velocidade: 78,
        chute: 66,
        passe: 75,
        drible: 82,
        defesa: 87,
        fisico: 83),
    Jogador(
        idJogador: 115,
        nomeJogador: "nomeJogador",
        idade: 30,
        nomeComum: "nomeComum",
        altura: 168,
        peso: 70,
        aniversario: "aniversario",
        idLiga: 13,
        idPais: 18,
        idEquipe: 5,
        idRaridade: 1,
        posicao: "posicao",
        estrelaDrible: 2,
        pernaRuim: 3,
        perna: "perna",
        dedicacaoAtaque: "dedicacaoAtaque",
        dedicacaoDefesa: "dedicacaoDefesa",
        geral: 90,
        velocidade: 78,
        chute: 66,
        passe: 75,
        drible: 82,
        defesa: 87,
        fisico: 83)
  ];
  // final _listfontstyle = const TextStyle(fontSize: 15);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Lista Jogadores"),
      ),
      body: _buildJogadorList(),
      floatingActionButton: FloatingActionButton(
        onPressed: _requestJogadorList,
        tooltip: 'Load Player List',
        child: const Icon(Icons.add),
      ),
    );
  }

  void _requestJogadorList() {
    Future filmRequest = NetworkHelper.getData();
    filmRequest.then((value) {
      final parsedList = Jogador.listFromJson(value);
      setState(() {
        _jogadorlist.addAll(parsedList);
      });
    });
  }

  Widget _buildJogadorList() {
    return ListView.builder(
        padding: const EdgeInsets.all(16),
        itemCount: _jogadorlist.length,
        itemBuilder: (BuildContext _contex, int i) {
          return ListTile(
            title: Text(_jogadorlist[i].nomeJogador),
            subtitle: Text(_jogadorlist[i].posicao),
          );
        });
  }
}
