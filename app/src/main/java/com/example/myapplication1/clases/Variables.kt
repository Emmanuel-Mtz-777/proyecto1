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
        val genero:Char='M';
        val name:String ="Pepito";

        //Boleana
        var boolean:Boolean=false;

        //array

        val names=arrayOf("pepito","Pancracio","Stevan");
        println("Bienvenido a continuación mostraremos algunos datos");
        println("edad:"+a);
        println("numero largo: "+longNumber);
        println("temperatura: "+temperatura);
        println("peso: "+weight);
        println("genero: "+genero);
        println("nombre: "+name)
        println("valor booleano: "+boolean);
        println("lista de nombres: "+names.contentToString());
        println(add())
        println(product(10,25))
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

//}