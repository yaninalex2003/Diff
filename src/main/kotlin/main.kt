import java.io.File

fun main(args: Array<String>) {
    val text1 = scanFile("test1.txt")
    val text2 = scanFile("test2.txt")
    val ourMatrix = matrix(text1, text2)
    val ourLCS1 = findLCS(ourMatrix, text1, text2)[0]
    val ourLCS2 = findLCS(ourMatrix, text1, text2)[1]
    printAns(text1, text2, ourLCS1, ourLCS2)
}

//нахождения максимума из двух чисел
fun max(a: Int, b: Int): Int {
    return if (a > b) a
    else b
}

//считывание файла
fun scanFile(name: String): Array<String> {
    var text: Array<String> = arrayOf()
    for (line in File(name).readLines())
        text += line
    return text
}

//построение матрицы для алгоритма поиска LCS
fun matrix(text1: Array<String>, text2: Array<String>): Array<Array<Int>> {
    var ourMatrix: Array<Array<Int>> = Array(text2.size + 1) { Array(text1.size + 1) { 0 } }
    for (i in 1..text2.size) {
        for (j in 1..text1.size) {
            if (text1[j - 1] == text2[i - 1]) {
                ourMatrix[i][j] = ourMatrix[i - 1][j - 1] + 1
            } else {
                ourMatrix[i][j] = max(ourMatrix[i][j - 1], ourMatrix[i - 1][j])
            }
        }
    }
    return ourMatrix
}

//Восстановление LCS по матрице
fun findLCS(ourMatrix: Array<Array<Int>>, text1: Array<String>, text2: Array<String>): Array<Array<Int>> {
    var ourLCS1: Array<Int> = arrayOf()
    var ourLCS2: Array<Int> = arrayOf()
    var i = text2.size
    var j = text1.size
    while (i > 0 && j > 0) {
        if (text1[j - 1] == text2[i - 1]) {
            ourLCS2 += i - 1
            ourLCS1 += j - 1
            i -= 1
            j -= 1
        } else if (ourMatrix[i][j] == ourMatrix[i - 1][j]) {
            i -= 1
        } else {
            j -= 1
        }
    }
    return arrayOf(ourLCS1, ourLCS2)
}

//Вывод ответа
fun printAns(text1: Array<String>, text2: Array<String>, ourLCS1: Array<Int>, ourLCS2: Array<Int>) {
    var indexText1 = text1.size - 1
    var indexText2 = text2.size - 1
    for (i in 0..ourLCS1.size){
        while (indexText1 !in ourLCS1 && indexText1>=0) {
            println("Удалить строку с места номер ${indexText1+1}: ${text1[indexText1]}")
            indexText1-=1
        }
        val place = indexText1+2
        while (indexText2 !in ourLCS2 && indexText2>=0) {
            println("Добавить строку на место номер $place: ${text2[indexText2]}")
            indexText2-=1
        }
        indexText2-=1
        indexText1-=1
    }
}