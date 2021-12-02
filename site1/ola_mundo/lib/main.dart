import 'dart:html';
import 'dart:ui';
import 'package:flutter/material.dart';
import 'JogadorLista.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.deepPurple,
      ),
      home: MinhaPagina(),
    );
  }
}

class MinhaPagina extends StatelessWidget {
  const MinhaPagina({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: (Text('Review FIFA 22')),
        actions: [
          MaterialButton(
            color: Colors.pinkAccent,
            shape: RoundedRectangleBorder(
                borderRadius: BorderRadius.all(Radius.circular(20.0))),
            onPressed: () {},
            child: Text(
              "Home",
              style: TextStyle(color: Colors.white),
            ),
          ),
          MaterialButton(
            color: Colors.pinkAccent,
            shape: RoundedRectangleBorder(
                borderRadius: BorderRadius.all(Radius.circular(20.0))),
            onPressed: () {},
            child: Text(
              "Login",
              style: TextStyle(color: Colors.white),
            ),
          ),
        ],
      ),
      body: incluiStack(),
      drawer: Drawer(
        // Add a ListView to the drawer. This ensures the user can scroll
        // through the options in the drawer if there isn't enough vertical
        // space to fit everything.
        child: ListView(
          // Important: Remove any padding from the ListView.
          padding: EdgeInsets.symmetric(vertical: 50),
          children: [
            const Spacer(),
            ListTile(
              leading: Image.asset('Imagens/Icon.png'),
              title: const Text('Icon'),
              onTap: () {
                // Update the state of the app
                // ...
                // Then close the drawer
                Navigator.push(
                  context,
                  MaterialPageRoute(builder: (context) => const MeuApp()),
                );
              },
            ),
            ListTile(
              leading: Image.asset('Imagens/Ouro.png'),
              title: const Text('Gold'),
              onTap: () {
                // Update the state of the app
                // ...
                // Then close the drawer
                Navigator.push(
                  context,
                  MaterialPageRoute(builder: (context) => const MeuApp()),
                );
              },
            ),
            ListTile(
              leading: Image.asset('Imagens/Prata.png'),
              title: const Text('Silver'),
              onTap: () {
                // Update the state of the app
                // ...
                // Then close the drawer
                Navigator.push(
                  context,
                  MaterialPageRoute(builder: (context) => const MeuApp()),
                );
              },
            ),
            ListTile(
              leading: Image.asset('Imagens/Bronze.png'),
              title: const Text('Bronze'),
              onTap: () {
                // Update the state of the app
                // ...
                // Then close the drawer
                Navigator.push(
                  context,
                  MaterialPageRoute(builder: (context) => const MeuApp()),
                );
              },
            ),
          ],
        ),
      ),
    );
  }
}

Widget incluiStack() {
  return Stack(
    children: <Widget>[
      Image.asset(
        'Imagens/banner.jpg',
        width: double.infinity,
        height: double.infinity,
        fit: BoxFit.cover,
      ),
      Positioned(
        top: 150,
        right: 150,
        child: Text(
          "Bem-Vindo!\n\n\n"
          "Nesse site é possível analisar cartas do \nFifa Ultimate Team, além de ver reviews e comentários\nde outros players sobre essas cartas.",
          style: TextStyle(
              color: Colors.white, fontSize: 20, fontFamily: 'Calibri'),
        ),
      ),
    ],
  );
}
