import 'package:flutter/material.dart';

class MyApp extends StatelessWidget{
  @override
  Widget build(context) => MaterialApp(
    title: 'flutter list',
    //initialRoute: '/',
    home: Scaffold(
        appBar: AppBar(title: Text('hw12 flutterlist')), body:MyBody()),
  );
}

class MyBody extends StatelessWidget {
  _buildList(context) => ListView(
    children: [
      _tile(context, 'Memories of Murder','2003',Icons.theaters),
      _tile(context, 'Old Boy','2003',Icons.theaters),
      _tile(context, 'Thirst','2009',Icons.theaters),
      const Divider(),
      _tile(context, 'Moneyball','2011',Icons.theaters_outlined),
      _tile(context, 'Her','2013',Icons.theaters_outlined),
      _tile(context, 'Joker','2019',Icons.theaters_outlined),
    ],
  );

  _tile(context, title , subtitle, icon) => ListTile(
    leading: Icon(icon),
    title: Text(title),
    subtitle: Text(subtitle),
    onTap: () => Navigator.push(context,
      MaterialPageRoute(
          builder: (context) => SubPage(title,subtitle)),
  ));

  @override
  Widget build(BuildContext context) {
    return _buildList(context);
  }
}

class SubPage extends StatelessWidget {
  String title;
  String subtitle;

  SubPage(this.title, this.subtitle);

  @override
  Widget build(BuildContext context) {
    return Scaffold(appBar: AppBar(title: Text(title)), body: Text(subtitle));
  }
}

void main() => runApp(MyApp());
