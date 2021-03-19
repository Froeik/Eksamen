import controlP5.*;
ControlP5 cp5;

//instance
login l;

void setup(){
  size(400,600);
  smooth();
  noStroke();
  cp5 = new ControlP5(this);
   l = new login();
}

void draw(){
  background(0);
}
