import java.io.File

const val RED = "\u001B[31m"
const val GREEN = "\u001B[32m"

fun main() {
    val text1 = scanFile(nameFile("первого"))
    val text2 = scanFile(nameFile("второго"))
    val ourMatrix = matrix(text1, text2)
    val pairOurLCS = findLCS(ourMatrix, text1, text2)
    val ourAnsArray = findAns(text1, text2, pairOurLCS.first, pairOurLCS.second)
    printAns(ourAnsArray)
}

//ввод названия файлов
fun nameFile(name : String): String {
    println("Вставьте название $name файла")
    return readLine()!!
}

//cчитывание файла
fun scanFile(name: String): Array<String> {
    var text: Array<String> = arrayOf()
    for (line in File(name).readLines())
        text += line
    return text
}

//построение матрицы для алгоритма поиска LCS
fun matrix(text1: Array<String>, text2: Array<String>): Array<Array<Int>> {
    val ourMatrix: Array<Array<Int>> = Array(text2.size + 1) { Array(text1.size + 1) { 0 } }
    for (i in 1..text2.size) {
        for (j in 1..text1.size) {
            if (text1[j - 1].hashCode() == text2[i - 1].hashCode()) {
                ourMatrix[i][j] = ourMatrix[i - 1][j - 1] + 1
            } else {
                ourMatrix[i][j] = maxOf(ourMatrix[i][j - 1], ourMatrix[i - 1][j])
            }
        }
    }
    return ourMatrix
}

//Восстановление LCS по матрице
//Функция выводит два массива индексов строк: для первого массива строк и для второго
fun findLCS(ourMatrix: Array<Array<Int>>, text1: Array<String>, text2: Array<String>): Pair<Array<Int>, Array<Int>> {
    var ourLCS1: Array<Int> = arrayOf()
    var ourLCS2: Array<Int> = arrayOf()
    var size1 = text1.size
    var size2 = text2.size
    while (size2 > 0 && size1 > 0) {
        if (text1[size1 - 1].hashCode() == text2[size2 - 1].hashCode()) {
            ourLCS2 += size2 - 1
            ourLCS1 += size1 - 1
            size2 -= 1
            size1 -= 1
        } else if (ourMatrix[size2][size1] == ourMatrix[size2 - 1][size1]) {
            size2 -= 1
        } else {
            size1 -= 1
        }
    }
    return Pair(ourLCS1, ourLCS2)
}

//Вывод ответа
fun findAns(text1: Array<String>, text2: Array<String>, ourLCS1: Array<Int>, ourLCS2: Array<Int>): Array<String> {
    var indexText1 = text1.size - 1
    var indexText2 = text2.size - 1
    var ourAnsArray: Array<String> = arrayOf()
    for (i in 0..ourLCS1.size) {
        while (indexText1 !in ourLCS1 && indexText1 >= 0) {
            ourAnsArray += RED + "- ${indexText1 + 1}: ${text1[indexText1]}"
            indexText1 -= 1
        }
        val place = indexText1 + 2
        while (indexText2 !in ourLCS2 && indexText2 >= 0) {
            ourAnsArray += GREEN + "+ $place: ${text2[indexText2]}"
            indexText2 -= 1
        }
        indexText2 -= 1
        indexText1 -= 1
    }
    return ourAnsArray
}

fun printAns(ansArray: Array<String>) {
    for (ind in ansArray.indices) {
        println(ansArray[ind])
    }
}