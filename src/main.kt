import java.io.File
import java.nio.channels.FileLockInterruptionException

var cislo = 1 //int  var se da upravit
val den = 20  //val se neda upravit
lateinit var text: String //vyvolá funkci později (lateinit)
val INPUT = "input.txt"
val OUTPUT = "output.txt"

fun pocitani(cislo: Int, den: Int): Int = cislo + den //jednoradkova deklarace funkce = kratka funkce

fun jmeno(){
    var nalada: Int?
    print("Zadej sve jmeno: ")
    var jmen: String = readLine()!!

    print("Zadej sve prijmeni: ")
    var prijm: String = readLine()!!

    print("Zdravim ${jmen} ${prijm}, jak se mas od 1 do 10?: ")
    do{
        nalada = readLine()!!.toIntOrNull()
        if(nalada == null){
            print("Ty si spatny zadej znova CISLO: ")
        }
    }while(nalada == null)


    if(nalada < 0){
        println("To si smutne smutny :(")
    }
    else if(nalada in 0..4){
        println("Smutne, bez hrat fortnajt.")
    }
    else if(nalada in 5..8){
        println("Bez si zhoršit naladu hranim lolka :).")
    }
    else{
        println("Kůl")
    }
}
fun cteni(): MutableList<String> {
    val zapisList = mutableListOf<String>()
    val eachline: List<String> = File(INPUT).readLines()
       /* for (line in eachline){
            println(line)
        }*/
    eachline.forEach {
        var posplitu = it.split(" ")
                println("Adrese je: "+posplitu[0])
                println("Ip je: "+posplitu[1])
        zapisList.add("Adrese je: "+posplitu[0])
        zapisList.add("IP je: "+posplitu[1])

    }
    return zapisList
}
fun zapis(){
    var bufr = File(OUTPUT).writer()
    cteni().forEach{
        bufr.write(it+"\n")
    }
    bufr.close()
}
fun main(){
    /*
        println("David Uran Kukuřica je totální taška!")
        print("Zadej nejaky hezky text: ")
        text = readLine()!!
        println("$text Je to pravda !")
        println("Soucet %d a %d je %d".format(cislo, den, pocitani(cislo, den)))  //metoda vypisu s necim 1
        println("Soucet $cislo + $den = ${pocitani(cislo, den)}") //metoda vypisu s necim 2
        jmeno()
        */
        cteni()
        zapis()
}
