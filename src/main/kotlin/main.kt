import java.io.File
fun max(a:Int, b:Int):Int{
    if (a>b) return a
    else return b
}
fun main(args: Array<String>) {
    var text1: Array<String> = arrayOf()
    for (line in File("test1.txt").readLines()){
        text1=text1+line
    }
    var text2: Array<String> = arrayOf()
    for (line in File("test2.txt").readLines()) {
        text2 = text2 + line
    }
    val shirina=text1.size
    val vysota=text2.size
    var matrix: Array<Array<Int>> = Array(vysota+1, {Array( shirina+1, {0})})
    for (i in 1..vysota){
        for (j in 1..shirina){
            if (text1[j-1]==text2[i-1]){
                matrix[j][i]=matrix[j-1][i-1]+1
            }
            else{
                matrix[j][i]=max(matrix[j][i-1],matrix[j-1][i])
            }
        }
    }
    var ans: Array<String> = arrayOf()
    var i = vysota
    var j = shirina
    while (i>0 && j>0) {
        if (text1[j-1]==text2[j-1]){
            ans = ans +text1[j-1]
            i-=1
            j-=1
        }
        else if (matrix[j][i]==matrix[j-1][i]) {
            j-=1
        }
        else{
            i-=1
        }
    }
    var a = max(vysota-1, shirina-1)
    while (a>=0){
        if (a<=shirina-1 && text1[a] !in ans) {
            println("Удалить строку номер ${a+1} : ${text1[a]}")
        }
        if (a<=vysota-1 && text2[a] !in ans) {
            println("Добавить строку номер ${a+1} : ${text2[a]}")
        }
        a-=1
    }
}
