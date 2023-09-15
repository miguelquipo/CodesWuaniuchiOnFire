#include <NewPing.h>                // SE DEFINE AL SENSOR ULTRASONICO
#include <Servo.h>                  // SE DEFINE AL SERVOMOTOR.

#define TRIG_PIN 22                 // SE DEFINE EL SENSOR ULTRASONICO, TRIG VA AL PIN A0 DEL ARDUINO UNO.
#define ECHO_PIN 24                // SE DEFINE EL SENSOR ULTRASONICO, ECHO VA AL PIN A1 ARDUINO UNO.
#define MAX_DISTANCE 350            
NewPing sonar(TRIG_PIN, ECHO_PIN, MAX_DISTANCE);

#include <Wire.h>                //include Wire.h library
#include <Servo.h>              //include servo.h library
#include <Adafruit_MLX90614.h> //include MLX90614.h library

Adafruit_MLX90614 mlx = Adafruit_MLX90614();
Servo myservo;

long randomNumber;


int pos = 0;    
boolean fire = false;
double temp;

#define Left 8         // left sensor
#define Right 9       // right sensor
#define Forward 10   //front sensor   

//Motor rigth                  

int LM1 = 6;
int LM2 = 5;
int ENA = 7;

// Motor left

int RM3 = 4;
int RM4 = 3;
int ENB = 2;

 
int  pump = 11 ;

 

void setup() {
  pinMode(Left, INPUT);
  pinMode(Right, INPUT);
  pinMode(Forward, INPUT);
   pinMode(LM1, OUTPUT);
  pinMode(LM2, OUTPUT);
  pinMode(RM3, OUTPUT);
  pinMode(RM4, OUTPUT);
  pinMode(pump, OUTPUT);

  mlx.begin();
  myservo.attach(33);
  myservo.write(90);

}

 

/////////////////LOOP//////////////////////////

void loop() {

 float temp = mlx.readObjectTempC();
 int tiempo = sonar.ping_median();
 int distancia = tiempo / US_ROUNDTRIP_CM;


if (distancia > 0){
  if(distancia < 30){
    if(distancia > 20){
      retrocede();
      delay(800);
      parada(1500);
    }else{
      randomNumber = random(1,3);
      Serial.print("El numero aleatorio es = ");
      Serial.println(randomNumber);
      if (randomNumber == 1){
        izquierda();
        delay(800);
        parada(1500);
      }else{
        derecha();
        delay(800);
        parada(1500);
      }
    }
  }else{
    avanza();
  }
 }else{
  avanza();
}


 if (digitalRead(Left) ==1 && digitalRead(Right)==1 && digitalRead(Forward) ==1)
    {
    avanza();
    }
    else if (digitalRead(Forward) ==0)
    {
    avanza();
    }
    else if (digitalRead(Left) ==0)
    {
    derecha();
    }
    else if (digitalRead(Right) ==0)
    {
    izquierda();
    }else{
       avanza();  
    }

if (temp > 30){

   parar();
   digitalWrite(pump, HIGH);

    for (pos = 50; pos <= 130; pos += 1) {
    myservo.write(pos);
    delay(10);  
  }

  for (pos = 130; pos >= 50; pos -= 1) {
    myservo.write(pos);
    delay(10);
  }
  for (pos = 50; pos <= 130; pos += 1) {
    myservo.write(pos);
    delay(10);  
  }

  for (pos = 130; pos >= 50; pos -= 1) {
    myservo.write(pos);
    delay(10);
  }
  digitalWrite(pump,LOW);
  myservo.write(90);
  fire=false;
  }else{
    avanza();
  }

}
 
void parada(uint16_t tiempo) {
  parar();
  delay(tiempo);
}
void avanza(){
 // MOTOR 1 
  analogWrite (ENA, 100);
  digitalWrite(LM1, LOW);
  digitalWrite(LM2, HIGH);
  // MOTOR 2
  analogWrite(ENB, 100);
  digitalWrite(RM3, LOW);
  digitalWrite(RM4, HIGH);
}
void retrocede(){
 // MOTOR 1 
  digitalWrite(ENA, 90);
  digitalWrite(LM1, HIGH);
  digitalWrite(LM2, LOW);
  // MOTOR 2
  digitalWrite(ENB, 90);
  digitalWrite(RM3, HIGH);
  digitalWrite(RM4, LOW);
}
void derecha(){
 // MOTOR 1 
  analogWrite (ENA, 90);
  digitalWrite(LM1, HIGH);
  digitalWrite(LM2, LOW);
  // MOTOR 2
  analogWrite (ENB, 90);
  digitalWrite(RM3, LOW);
  digitalWrite(RM4, HIGH);
}
void izquierda(){
 // MOTOR 1 
  analogWrite (ENA, 90);
  digitalWrite(LM1, LOW);
  digitalWrite(LM2, HIGH);
  // MOTOR 2
  analogWrite (ENB, 90);
  digitalWrite(RM3, HIGH);
  digitalWrite(RM4, LOW);
}
void parar(){
 // MOTOR 1 
  digitalWrite(ENA, 0);
  digitalWrite(LM1, LOW);
  digitalWrite(LM2, LOW);
  // MOTOR 2
  digitalWrite(ENB, 0);
  digitalWrite(RM3, LOW);
  digitalWrite(RM4, LOW);
}