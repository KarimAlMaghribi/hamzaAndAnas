package TestExemple;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
        static String op,str,STR;
        static String[] array;//Attribute declaration str le 1er numero /STR le 2eme numero /op est l'operateur.
        public static void affichDuText() { // affichDuText() is a method to import data from User
            Scanner cl=new Scanner(System.in);
            System.out.print("Taper les numero : ");
            array = cl.nextLine().split(" ");
            str=array[0];op=array[1];STR=array[2];
        }
        public static double calcule(double x,double y) {// calcule() is a method that return a value of two numbers calculeted
            double z=0.0f;
            switch(op) {
                case "+":
                    z=x+y;
                    break;
                case "-":
                    z=(x-y);
                    break;
                case "*":
                    z=(x*y);
                    break;
                case "/":
                    if(y==0) {
                        System.out.print("Nous ne pouvons pas diviser par zéro");
                        break;
                    }
                    z=(x/y);
                    break;
                default:
                    System.out.printf("You have entered wrong operator or value");
                    break;
            }
            return z;
        }
        public static void WhichVAlue() {
            Scanner b=new Scanner(System.in);
            if(array[0].matches("[a-zA-Z]+")) {
                System.out.println("which value has "+str);
                str =b.next();
            }
            if(array[2].matches("[a-zA-Z]+")) {
                System.out.println("which value has "+STR);
                STR =b.next();
            }
        }
        public static boolean checkCharatersValue() {//P1() is a method where i can filter between a characters(string) and numbers and return a booleen value
            boolean F=false;boolean d=false;boolean c=false;int p=0;
            String[] symbol= {"/","*","-","+"};
            if(array[0].matches("[a-zA-Z]+")) {
                F=true;
            }
            if(array[2].matches("[a-zA-Z]+")) {
                d=true;
            }
            for(int i=0;i<symbol.length;++i) {
                if(op.equals(symbol[i])) {
                    d=true;i=p;
                    break;
                }
            }
            return((F==true)&(d==true)&(c==true));
        }
        public static boolean checkValuesOfCharacters() {//P3() is a method where i can filter between a characters(string) and numbers and return a booleen value
            boolean F=false;boolean d=false;boolean c=false;
            if(array[0].matches("[a-zA-Z]+")) {
                F=true;
            }
            if(array[2].matches("[a-zA-Z]+")) {
                d=true;
            }
            return((F==true)||(d==true));
        }
        public static void changeStringToDouble() {
            double d=Double.parseDouble(str);//job of (d and D) to change value from string to double
            double D=Double.parseDouble(STR);
            System.out.print(calcule( d, D)!=0.0 ? ("la valeur est : "+calcule( d, D)) :( " " ));
        }
        public static void yourRouting() throws ParseException {
            SimpleDateFormat dateInputFormat =new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat dateOutputFormat =new SimpleDateFormat("E d MMM yyyy");
            Scanner clavier=new Scanner(System.in);
            System.out.println("what's your to-do ? and when is your to-do ? (dd-MM-yyyy) : ");
            String [] input = clavier.nextLine().split(",");
            String yourToDo=input[0];String sDate1=input[1];
            Date d1 = dateInputFormat.parse(sDate1);
            System.out.println(dateOutputFormat.format(d1));
            System.out.println(yourToDo+"\t"+yourToDo.length());

        }
        public static void main(String[] args) throws ParseException {
            while(true) {
                System.out.println("choose between a Calculator(1) or a To-Do(2) ");
                Scanner clavier=new Scanner(System.in);
                String choose=clavier.next();
                switch (choose){
                    case "1": affichDuText();
                        if(checkCharatersValue()) {
                            WhichVAlue();
                            changeStringToDouble();
                        }else {
                            if(checkValuesOfCharacters()) {
                                System.out.println("error \"Just numbers:\"");
                                WhichVAlue();
                                changeStringToDouble();
                            }else {
                                changeStringToDouble();
                            }

                        }
                        break;
                    case"2": yourRouting();
                    break;
                    default:
                        System.out.println("Your have a wrong input try");
                }
                System.out.print("\n");
                System.out.println("Thanks see you later!");
                continue;
            }
        }

    }

