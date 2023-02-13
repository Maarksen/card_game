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
        val now = LocalDateTime.now()

        println("Simulation of the deck $name")
        println("Date: ${now.format(formatter)}")

        cards.forEach{it.show_card(now)}

        for (day in 1..num_days) {
            val time = now.plusDays(day).format(formatter)
            println("Date: $time")
            cards.forEach{if(it.next_practice == now.plusDays(day).format(formatter)) it.show_card(now.plusDays(day))}
        }
    }
}