import 'package:flutter/material.dart';

class _MyFormState extends State<MyForm> {
  TextEditingController textEditingController = TextEditingController();
  String displayedText = 'Hello, Flutter';

  void _changeText(){
    setState(() {
      displayedText = textEditingController.text;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        Text(displayedText),
        TextField(
            controller: textEditingController),
        ElevatedButton(onPressed: _changeText, child: Text('Change Text')
        )
      ],
    );
  }
}

class MyForm extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return _MyFormState();
  }
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        title: 'Button and TextField Test',
        home:
        Scaffold(appBar: AppBar(title: Text('Appbar title')),
            body: MyForm())
    );
  }
}

void main() => runApp(MyApp());
