import java.time.LocalDateTime
import java.util.*

object Collection{
    val decks = mutableListOf<Deck>()
    val cards = mutableListOf<Card>()
}

fun main(){

    val card_deck = Deck(UUID.randomUUID().toString(), "English")
    val cloze_deck = Deck(UUID.randomUUID().toString(), "English")

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
        println("4. READ CARDS FROM FILE [4]")
        println("5. WRITE CARDS TO FILE [5]")
        println("6. EXIT [6]")
        println("CHOOSE AN OPTION.")

        val choice = readln().toInt()

        when (choice) {
            1 -> card_deck.add_card()
            2 -> card_deck.cards.forEach{println("${it.question} -> ${it.answer}")}
            3 -> card_deck.simulate(10)
            4 -> card_deck.readCards()
            5 -> card_deck.writeCards()
            6 -> end = true
            else -> println("ERROR")
        }
    }
}