import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class Deck(var id : String = UUID.randomUUID().toString(), var name : String){
    var date = LocalDateTime.now().toString()
    val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")

    var cards = mutableListOf<Card>()

    fun add_card(){
        println("Adding card to $name deck.")
        println("Type the type of the question.[1/2]")

        val q_type = readln().toIntOrNull()?: "[ERROR] wrong input"
        if(q_type != 1 && q_type != 2){
            println("[ERROR] wrong input")
            return
        }
        println("Type the question.")
        val question = readln()
        println("Type the answer.")
        val answer = readln()

        if(q_type == 1) {
            cards.add(Card(UUID.randomUUID().toString(), LocalDateTime.now().toString(), question, answer))
            println("Card added successfully.")
        }
        else if(q_type == 2){
            cards.add(Cloze(UUID.randomUUID().toString(), LocalDateTime.now().toString(), question, answer))
            println("Card added successfully.")
        }
        else
            println("[ERROR] Wrong Input")
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