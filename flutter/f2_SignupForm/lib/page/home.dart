import 'package:flutter/material.dart';
import 'package:myweb2_loginForm/widget/gender.dart';
import 'package:myweb2_loginForm/widget/input_field.dart';
import 'package:myweb2_loginForm/widget/membership.dart';

class Home extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        backgroundColor: Colors.blue[50],
        body: Padding(
          padding: EdgeInsets.only(
              top: 30.0, bottom: 30.0, left: 100.0, right: 100.0),
          child: Card(
            shape: RoundedRectangleBorder(
                borderRadius: BorderRadius.circular(40.0)),
            elevation: 5.0,
            child: Container(
              child: Row(
                children: <Widget>[
                  HomeLeftCard(),
                  HomeRightCard(),
                ],
              ),
            ),
          ),
        ));
  }
}

class HomeLeftCard extends StatelessWidget {
  const HomeLeftCard({
    Key key,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Container(
      width: MediaQuery.of(context).size.width / 3.3,
      height: MediaQuery.of(context).size.height,
      color: Colors.yellow[600],
      child: Padding(
        padding: EdgeInsets.only(top: 20.0, right: 40.0, left: 40.0),
        child: Align(
          alignment: Alignment.centerRight,
          child: Column(
            children: <Widget>[
              Container(
                child: CircleAvatar(
                  backgroundColor: Colors.black87,
                  backgroundImage: AssetImage("assets/jhipster.png"),
                  radius: 70.0,
                ),
              ),
              SizedBox(
                height: 60.0,
              ),
              Container(
                padding: EdgeInsets.only(top: 5.0, bottom: 5.0),
                child: Text(
                  "Let's get you set up",
                  style: TextStyle(
                    fontSize: 30.0,
                    fontWeight: FontWeight.w900,
                  ),
                ),
              ),
              SizedBox(
                height: 5.0,
              ),
              Container(
                padding: EdgeInsets.only(top: 5.0, bottom: 5.0),
                child: Text(
                  "It should only take a couple of minutes to pair with your watch",
                  style: TextStyle(
                    fontSize: 18.0,
                  ),
                  textAlign: TextAlign.center,
                ),
              ),
              SizedBox(
                height: 50.0,
              ),
              Container(
                child: CircleAvatar(
                  backgroundColor: Colors.black87,
                  child: Text(
                    ">",
                    style: TextStyle(color: Colors.yellow),
                  ),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}

class HomeRightCard extends StatelessWidget {
  const HomeRightCard({
    Key key,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Container(
      padding:
          EdgeInsets.only(top: 40.0, right: 70.0, left: 70.0, bottom: 40.0),
      child: Column(
        children: <Widget>[
          //InputField Widget from the widgets folder
          InputField(label: "Name", content: "Full Name"),

          SizedBox(height: 20.0),

          //Gender Widget from the widgets folder
          Gender(),

          SizedBox(height: 20.0),

          //InputField Widget from the widgets folder
          InputField(label: "Date of birth", content: "01/02/1986"),

          SizedBox(height: 20.0),

          //InputField Widget from the widgets folder
          InputField(label: "Email", content: "yo@seethat.com"),

          SizedBox(height: 20.0),

          InputField(label: "Mobile", content: "+22994684468"),

          SizedBox(height: 20.0),

          //InputField Widget from the widgets folder
          InputField(label: "Customer ID", content: "22223311111"),

          SizedBox(
            height: 40.0,
          ),

          //Membership Widget from the widgets folder
          Membership(),

          SizedBox(
            height: 40.0,
          ),

          Row(
            children: <Widget>[
              SizedBox(
                width: 170.0,
              ),
              FlatButton(
                color: Colors.grey[200],
                onPressed: () {},
                child: Text("Cancel"),
              ),
              SizedBox(
                width: 20.0,
              ),
              FlatButton(
                color: Colors.green,
                onPressed: () {},
                child: Text(
                  "Save",
                  style: TextStyle(color: Colors.white),
                ),
              ),
            ],
          ),
        ],
      ),
    );
  }
}
