import java.time.LocalDateTime
import java.util.*

fun main(){

    val deck = Deck(UUID.randomUUID().toString(), "initial name")

    val cards = mutableListOf<Card>()
    cards.add(Card(UUID.randomUUID().toString(), LocalDateTime.now().toString(), "To wake up","Despertarse"))
    cards.add(Card(UUID.randomUUID().toString(), LocalDateTime.now().toString(), "To eat","Comer"))

   // Deck(UUID.randomUUID().toString(), "English")
   // cards[0].simulate(10)

    var end = false

    while(!end) {
        println("1. ADD CARD [1]")
        println("2. LIST OF CARDS [2]")
        println("3. SIMULATION [3]")
        println("4. EXIT [4]")
        println("CHOOSE AN OPTION.")

        val choice = readln().toInt()

        when (choice) {
            1 -> deck.add_card()
            2 -> deck.cards.forEach{println("${it.question} -> ${it.answer}")}
            3 -> deck.simulate(20)
            4 -> end = true
            else -> println("ERROR")
        }
    }


}