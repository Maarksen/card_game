import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.math.max
import kotlin.math.roundToLong

class Card(var id: String = UUID.randomUUID().toString(), var date: String = LocalDateTime.now().toString(),
           var question: String, var answer: String){

    val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")

    var quality : Int = 0
    var easiness : Double = 2.5
    var repetitions : Int = 0
    var interval : Long = 1L
    var next_practice : String = date

    fun show_card(date: LocalDateTime){
        //println("Date: ${date.format(formatter)}")
        println("$question [ENTER]")
        val input = readln()

        if(input == " "){
            println("$answer [TYPE : 0 -> DIFFICULT | 3 -> DOUBT | 5 -> EASY]")
            val difficulty = readln().toInt()
            quality = difficulty
        }

        update(date)
        details()
    }

    fun simulate(num_days : Long){
        println("Simulation of the card $question")
        val now = LocalDateTime.now()
        show_card(now)
        var jump = interval
        for(day in 1 .. num_days){
            val time = now.plusDays(day).format(formatter)
            if(day == jump){
                show_card(now.plusDays(day))
                jump += interval
            }
            else
                println("Date: $time")
        }
    }

    fun easiness() : Double{
        return max(1.3, easiness + 0.1 - (5 - quality) * (0.08 + (5 - quality) * 0.02))
    }

    fun repetition() : Int{
        if(quality < 3)
            return 0
        else
            return (repetitions + 1)
    }

    fun interval() : Long {
        if(repetitions <= 1)
            return 1
        else if(repetitions == 2)
            return 6
        else
            return (interval.toDouble() * easiness).roundToLong()
    }

    fun update(curr_date : LocalDateTime){
        easiness = easiness()
        repetitions = repetition()
        interval = interval()
        next_practice = curr_date.plusDays(interval).format(formatter).toString()
    }

    fun details(){
        println("eas = ${"%.2f".format(easiness)} rep = $repetitions int = $interval next = $next_practice")
    }
}

