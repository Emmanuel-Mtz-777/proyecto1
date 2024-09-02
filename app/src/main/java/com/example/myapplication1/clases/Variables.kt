package com.example.myapplication1.clases

//class Variables {
    //funcion
    fun main(){
    //hay tipado y no tipado en variables
    //Variables numericas
        val a:Int =20;
        val longNumber:Long = 2876832643718374699;
        val temperatura:Float=27.123f;
        val weight:Double=60.786756728;

        //string
        val gender:Char='M';
        val name:String ="Pepito";

        //Boleana
        var boolean:Boolean=false;

        //array

        val names=arrayOf("pepito","Pancracio","Stevan");
        val numbers=arrayOf(1,2,3,4,5,6,7,8,9);
        println("Bienvenido a continuación mostraremos algunos datos");
        println("age:"+a);
        println("long number: "+longNumber);
        println("temperatura: "+temperatura);
        println("peso: "+weight);
        println("genero: "+gender);
        println("nombre: "+name)
        println("valor booleano: "+boolean);
        println("lista de nombres: "+names.contentToString());
        println(add())
        println(product(10,25))
        //Aqui se imprime la funcion del for
        println(printArray(names));
        //imprime el array como texto
        println(names.joinToString ());
        println(parInPar(numbers));
        println(obternerDia(7));

        val Person= Person("Elva Surita", 23)
        println(Person.name);
        println(Person.edad);
        Person.displayInformation();

    }
    //Para devolver un tipo de valor lo definimos en la funcion cuando tengamos un return
    fun add():Int{
        val x:Int =5;
        val y:Int =10;
        return x+y;
    }
    //La forma en que funcionan aqui las funciones es como JavaScript puedo tener la funcion hasta
    //Narnia y poder invocara desde el inicio o sin declararla, etc.
    fun product(x:Int,y:Int):Int{
        return x+y;
    }
    //se crea una funcion con un for para recorrer los elementos del array
    fun printArray(names:Array<String>){
        for(name in names){
            println("Hola $name");
        }
    }

    fun parInPar(numbers:Array<Int>){
        for(number in numbers){
            if (number%2==0){
                println("Este numero es par: $number");
            }else{
                println("ESte numero es impar: $number");
            }
        }
    }
    //Una funcion que va a recibir un numero y me va a regresar un entero
    fun obternerDia(day:Int):String{
        var name="";

        when(day){
            1 -> name = "Lunes";
            2 -> name = "Martes";
            3 -> name = "Miercoles";
            4 -> name = "Jueves";
            5 -> name = "Viernes";
            6 -> name = "Sabado";
            7 -> name = "Domingo";
            else -> name = "Hijole ese dia no existe";
        }
            return name;
    }

    class Person(val name:String, val edad:Int){
        fun displayInformation(){
            println("nombre: $name, edad: $edad")
        }
    }
//}