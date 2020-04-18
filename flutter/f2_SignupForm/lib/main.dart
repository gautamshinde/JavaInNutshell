import 'package:flutter/material.dart';
import 'package:myweb2_loginForm/page/home.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
 
 var title = "Login App";
 
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title : "$title",
      debugShowCheckedModeBanner: false,
      home : Home(),
      theme : ThemeData(
        primarySwatch: Colors.blue
      )
    );
  }
}


