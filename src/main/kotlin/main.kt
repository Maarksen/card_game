import java.util.*

lateinit var card_deck : Deck

fun main(){

    val decks = mutableListOf<Deck>()

    fun create_deck(){
        println("Type the name of the deck.")
        val name = readln()
        decks.add(Deck(UUID.randomUUID().toString(), name))
    }

    fun remove_deck(){
        println("Type the name of the deck.")
        val delete = readln()

        if (decks.removeIf { it.name.trim() == delete })
            println("Deck removed successfully.")
        else
            println("[ERROR] Deck was not found.")
    }

    fun choose_deck(){
        println("Type the name of the deck.")
        decks.forEach {
            if(it == decks[decks.lastIndex]) println(it.name)
            else print("${it.name} | ")
        }
        println()
        val name = readln()
        decks.forEach { if(it.name == name) card_deck = it}
    }

    var end = false
    while(!end) {
        println("- ADD/REMOVE DECK [1/2]")
        println("- CHOOSE DECK [3]")
        println("- ADD/REMOVE CARD [4/5]")
        println("- LIST OF CARDS [6]")
        println("- SIMULATION [7]")
        println("- READ CARDS FROM FILE [8]")
        println("- WRITE CARDS TO FILE [9]")
        println("- EXIT [10]")
        println("CHOOSE AN OPTION.")

        val choice = readln().toInt()

        when (choice) {
            1 -> create_deck()
            2 -> remove_deck()
            3 -> choose_deck()
            4 -> card_deck.add_card()
            5 -> card_deck.remove_card()
            6 -> card_deck.cards.forEach{println("${it.question} -> ${it.answer}")}
            7 -> card_deck.simulate(10)
            8 -> card_deck.readCards()
            9 -> card_deck.writeCards()
            10 -> end = true
            else -> println("ERROR")
        }
    }
}