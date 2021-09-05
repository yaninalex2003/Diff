import java.io.File
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
                if (matrix[j-1][i]>matrix[j][i-1]) matrix[j][i]=matrix[j-1][i]
                else matrix[j][i]=matrix[j][i-1]
            }
        }
    }
    var ans1: Array<Int> = arrayOf()
    var ans2: Array<Int> = arrayOf()
    var i = vysota
    var j = shirina
    while (i>0 && j>0) {
        if (text1[j-1]==text2[j-1]){
            ans1 = ans1 +(j-1)
            ans2 = ans2 +(i-1)
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
    ans1.reversed()
    ans2.reversed()
    var a = vysota-1
    if (a<shirina) a=shirina-1
    while (a>=0){

        a-=1
    }
}
