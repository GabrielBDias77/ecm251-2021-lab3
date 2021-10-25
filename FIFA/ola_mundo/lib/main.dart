import 'package:flutter/material.dart';

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
  const MinhaPagina({ Key? key }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title:(Text('Minha Pagina Web com Flutter'))
    ),
      body: Column(children: [
        Text("FIFA 22"),
        Image.network("https://media.contentapi.ea.com/content/dam/ea/fifa/fifa-22/fifa-22-shared-assets/common/fifa-22-featured-image.png.adapt.crop191x100.1200w.png")
      ],
    )
    );
  }
}