import java.time.LocalDateTime
import java.util.*

class Cloze(id: String = UUID.randomUUID().toString(), date: String = LocalDateTime.now().toString(),
            override var question: String, override var answer: String) : Card(id, date, question, answer) {

    override fun show_card(date: LocalDateTime){
        println("$question [ENTER] using cloze")
        val input = readln()

        val substring = question.substringAfter('*').substringBefore('*')

        if(input == " "){
            println("${question.replace(substring, answer).replace("*", "")} [TYPE : 0 -> DIFFICULT | 3 -> DOUBT | 5 -> EASY]")
            val difficulty = readln().toInt()
            quality = difficulty
        }

        update(date)
        details()
    }
}