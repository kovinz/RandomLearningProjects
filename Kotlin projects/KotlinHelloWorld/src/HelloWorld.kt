import java.lang.Thread.sleep
import java.util.Timer
import kotlin.concurrent.schedule


val WAIT_COMMAND = "/wait"

fun main() {
//    onWaitCommand("01:00")
//    onWaitCommand("30")
//    onWaitCommand("2")
//    onWaitCommand("01:05")
    var listOfTimes: List<Long> = "60:00".split(":").map { s: String -> s.toLong() }
    println(countSeconds(listOfTimes))
    listOfTimes = "454530".split(":").map { s: String -> s.toLong() }
    println(countSeconds(listOfTimes))
    listOfTimes = "12:72".split(":").map { s: String -> s.toLong() }
    println(countSeconds(listOfTimes))
    listOfTimes = "24:01:05".split(":").map { s: String -> s.toLong() }
    println(countSeconds(listOfTimes))
    listOfTimes = "01:65".split(":").map { s: String -> s.toLong() }
    println(countSeconds(listOfTimes))
    listOfTimes = "255".split(":").map { s: String -> s.toLong() }
    println(countSeconds(listOfTimes))
    listOfTimes = "12:60".split(":").map { s: String -> s.toLong() }
    println(countSeconds(listOfTimes))
    listOfTimes = "05:06:01:05".split(":").map { s: String -> s.toLong() }
    println(countSeconds(listOfTimes))
}

private fun countSeconds(listOfTimes: List<Long>): Long {
    var secondsToWait: Long = 0
    var h: Long = 0
    var m: Long = 0
    var s: Long = 0
    var wrongFormat = false

    if (listOfTimes.size == 3) {
        if (listOfTimes[0] in 0..23
            && listOfTimes[1] in 0..59
            && listOfTimes[2] in 0..59) {
            h = listOfTimes[0]
            m = listOfTimes[1]
            s = listOfTimes[2]
        } else {
            wrongFormat = true
        }
    } else if (listOfTimes.size == 2) {
        if (listOfTimes[0] in 0..59
            && listOfTimes[1] in 0..59) {
            m = listOfTimes[0]
            s = listOfTimes[1]
        } else {
            wrongFormat = true
        }
    } else if (listOfTimes.size == 1) {
        s = listOfTimes[0]
    } else {
        wrongFormat = true
    }

    if (wrongFormat) {
        return -1
    }

    secondsToWait += h * 3600 * 1000
    secondsToWait += m * 60 * 1000
    secondsToWait += s * 1000
    return secondsToWait / 1000
}

fun countSeconds2(listOfTimes: List<Long>): Long {
    var secondsToWait: Long = 0
    var h: Long = 0
    var m: Long = 0
    var s: Long = 0
    var wrongFormat: Boolean = false

    if (listOfTimes.size == 3) {
        if (listOfTimes.get(0) >= 0 && listOfTimes.get(0) < 24
            && listOfTimes.get(1) >= 0 && listOfTimes.get(1) < 60
            && listOfTimes.get(2) >= 0 && listOfTimes.get(2) < 60) {
            h = listOfTimes.get(0)
            m = listOfTimes.get(1)
            s = listOfTimes.get(2)
        } else {
            wrongFormat = true
        }
    } else if (listOfTimes.size == 2) {
        if (listOfTimes.get(0) >= 0 && listOfTimes.get(0) < 60
            && listOfTimes.get(1) >= 0 && listOfTimes.get(1) < 60) {
            m = listOfTimes.get(0)
            s = listOfTimes.get(1)
        } else {
            wrongFormat = true
        }
    } else if (listOfTimes.size == 1) {
        s = listOfTimes.get(0)
    } else {
        wrongFormat = true
    }

    secondsToWait += h * 3600 * 1000
    secondsToWait += m * 60 * 1000
    secondsToWait += s * 1000

    if (wrongFormat){
        return -1
    } else {
        return secondsToWait / 1000
    }
}



















private fun onWaitCommand(textWithoutCommand: String){
    if (textWithoutCommand.all { c: Char -> c.isDigit().or(c == ':') }.and(textWithoutCommand.isNotEmpty())){
        val listOfTimes: List<Long> = textWithoutCommand.split(":").map { s: String -> s.toLong() }
        var secondsToWait: Long = 0
        if (listOfTimes.size == 3) {
            val h = listOfTimes.get(0)
            val m = listOfTimes.get(1)
            val s = listOfTimes.get(2)
            if (h >= 0 && h < 24
                && m >= 0 && m < 60
                && s >= 0 && s < 60){
                secondsToWait += listOfTimes.get(0) * 3600 * 1000
                secondsToWait += listOfTimes.get(1) * 60 * 1000
                secondsToWait += listOfTimes.get(2) * 1000
                //sleep(secondsToWait)
                val response = "I've been waiting for " + secondsToWait / 1000 + " seconds!"
                Timer("SettingUp", false).schedule(secondsToWait) {
                    println(response)
                }
            } else {
                val response = "Wrong format of time. You should use hh:mm:ss or just quantity of seconds I should wait"
                println(response)
            }
        } else if (listOfTimes.size == 2){
            val m = listOfTimes.get(0)
            val s = listOfTimes.get(1)
            if (m >= 0 && m < 60
                && s >= 0 && s < 60){
                secondsToWait += listOfTimes.get(0) * 60 * 1000
                secondsToWait += listOfTimes.get(1) * 1000
                //sleep(secondsToWait)
                val response = "I've been waiting for " + secondsToWait / 1000 + " seconds!"
                Timer("SettingUp", false).schedule(secondsToWait) {
                    println(response)
                }
            } else {
                val response = "Wrong format of time. You should use hh:mm:ss or just quantity of seconds I should wait"
                println(response)
            }
        } else {
            secondsToWait +=listOfTimes.get(0) * 1000
            //sleep(secondsToWait)
            val response = "I've been waiting for " + secondsToWait / 1000 + " seconds!"
            Timer("SettingUp", false).schedule(secondsToWait) {
                println(response)
            }
        }
    } else {
        val response = "Wrong format of time. You should use hh:mm:ss or just quantity of seconds I should wait"
        println(response)
    }
}