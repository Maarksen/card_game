import java.time.LocalDateTime
import java.util.*

class Cloze(id: String = UUID.randomUUID().toString(), date: String = LocalDateTime.now().toString(),
            override var question: String, override var answer: String) : Card(id, date, question, answer) {

    override fun show_card(date: LocalDateTime){
        println("${question.trim()} [ENTER]")
        val input = readln()

        val substring = question.substringAfter('*').substringBefore('*')

        if(input == ""){
            println("${question.replace(substring, answer).replace("*", "").trim()} [TYPE : 0 -> DIFFICULT | 3 -> DOUBT | 5 -> EASY]")
            val difficulty = readln().toInt()
            quality = difficulty
        }

        update(date)
        details()
    }

    override fun toString(): String {
        return "cloze | $question | $answer | $date | $id | $easiness | $repetitions | $interval | $next_practice\n"
    }

    companion object {
        fun fromString(line: String): Cloze {
            val chunks = line.split(" | ")
            chunks.forEach { it.trim() }

            val cloze = Cloze(chunks[4], chunks[3], chunks[1], chunks[2])
            cloze.easiness = chunks[5].toDouble()
            cloze.repetitions = chunks[6].toInt()
            cloze.interval = chunks[7].toLong()
            cloze.next_practice = chunks[8]

            return cloze
        }
    }
}