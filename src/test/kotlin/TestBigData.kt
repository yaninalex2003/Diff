import kotlin.test.*

internal class TestBigData {

    @Test
    fun testTestBigData() {
        val text1 = scanFile("src\\bigData1")
        val text2 = scanFile("src\\bigData2")
        val ourMatrix = matrix(text1, text2)
        val pairOurLCS = findLCS(ourMatrix, text1, text2)
        val ourAnsArray = findAns(text1, text2, pairOurLCS.first, pairOurLCS.second)
        assertContentEquals(
            ourAnsArray, arrayOf(
                "$GREEN+ 748: КОНЕЦ!!!",
                "$GREEN+ 704:     // Bulk Modification Operations",
                "$RED- 698:     PlatformDependent",
                "$GREEN+ 698:     @PlatformDependent",
                "$RED- 8: package kotlin",
                "$GREEN+ 8: package Котлин"
            )
        )
    }
}