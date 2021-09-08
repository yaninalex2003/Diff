import java.io.File

fun main(args: Array<String>) {
    var text1 = scanFile("test1.txt")
    var text2 = scanFile("test2.txt")
    val ourMatrix = matrix(text1, text2)
    val ourLCS = findLCS(ourMatrix, text1, text2)
    printAns(text1, text2, ourLCS)
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
fun findLCS(ourMatrix: Array<Array<Int>>, text1: Array<String>, text2: Array<String>): Array<String> {
    var ourLCS: Array<String> = arrayOf()
    var i = text2.size
    var j = text1.size
    while (i > 0 && j > 0) {
        if (text1[j - 1] == text2[i - 1]) {
            ourLCS += text1[j - 1]
            i -= 1
            j -= 1
        } else if (ourMatrix[i][j] == ourMatrix[i - 1][j]) {
            i -= 1
        } else {
            j -= 1
        }
    }
    return ourLCS
}

//Вывод ответа
fun printAns(text1: Array<String>, text2: Array<String>, ourLCS: Array<String>) {
    var a = max(text2.size - 1, text1.size - 1)
    while (a >= 0) {
        if (a <= text1.size - 1 && text1[a] !in ourLCS) {
            println("Удалить строку номер ${a + 1} : ${text1[a]}")
        }
        if (a <= text2.size - 1 && text2[a] !in ourLCS) {
            println("Добавить строку номер ${a + 1} : ${text2[a]}")
        }
        a -= 1
    }
}