import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class Deck(var id : String = UUID.randomUUID().toString(), var name : String){
    var date = LocalDateTime.now().toString()
    val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")

    var cards = mutableListOf<Card>()

    fun add_card(){
        println("Type the question.")
        val question = readln()
        println("Type the answer.")
        val answer = readln()

        cards.add(Card(UUID.randomUUID().toString(),  LocalDateTime.now().toString(), question, answer))
        println("Card added successfully.")
    }

    fun simulate(num_days : Long){
        println("Simulation of the deck $name")
        val now = LocalDateTime.now()
        println("Date: ${now.format(formatter)}")
        //for(card in cards) {
            cards.forEach{it.show_card(now); it.update(now)}
            //card.update(now)
            //var jump = card.interval
        //cards.forEach{if(it.interval == num_days) it.show_card(now.plusDays(day))}
            for (day in 1..num_days) {
                val time = now.plusDays(day).format(formatter)
                println("Date: $time")
                cards.forEach{if(it.next_practice == now.plusDays(day).format(formatter)) it.show_card(now.plusDays(day))}
                cards.forEach{println("${it.next_practice} == ${now.plusDays(day).format(formatter)}")}
                cards.forEach{println(it.next_practice == now.plusDays(day).format(formatter))}
                //cards.forEach{println("${it.interval} = ${now.plusDays(day)}")}
                /*if (day == jump) {
                } else
                    println("Date: $time")
            }*/
        }
    }
}