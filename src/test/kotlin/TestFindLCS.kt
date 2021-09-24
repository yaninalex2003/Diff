import kotlin.test.*

fun assertEqualPair(twoArrays1: Pair<Array<Int>, Array<Int>>, twoArrays2: Pair<Array<Int>, Array<Int>>) {
    assertContentEquals(twoArrays1.first, twoArrays2.first)
    assertContentEquals(twoArrays1.second, twoArrays2.second)
}

internal class TestFindLCS {

    @Test
    fun testFindLCS1() {
        assertEqualPair(
            findLCS(
                matrix(arrayOf("РОмчик", "Приходил", "Сегодня"), arrayOf("Ромчик", "Приходил", "Сегодня")),
                arrayOf("РОмчик", "Приходил", "Сегодня"),
                arrayOf("Ромчик", "Приходил", "Сегодня")
            ), Pair(arrayOf(2, 1), arrayOf(2, 1))
        )
    }

    @Test
    fun testFindLCS2() {
        assertEqualPair(
            findLCS(
                matrix(arrayOf("Жили", "Были", "Дед", "И", "Баба"), arrayOf("Жили", "Дед", "И", "Дед")),
                arrayOf("Жили", "Были", "Дед", "И", "Баба"),
                arrayOf("Жили", "Дед", "И", "Дед")
            ), Pair(arrayOf(3, 2, 0), arrayOf(2, 1, 0))
        )
    }

    @Test
    fun testFindLCS3() {
        assertEqualPair(
            findLCS(
                matrix(
                    arrayOf("0", "1", "2"),
                    arrayOf("3", "4", "5")
                ), arrayOf("0", "1", "2"),
                arrayOf("3", "4", "5")
            ), Pair(arrayOf(), arrayOf())
        )
    }

    @Test
    fun testFindLCS4() {
        assertEqualPair(
            findLCS(
                matrix(
                    arrayOf("Отношение", "Является", "Эквивалентностью", "На", "Икс"),
                    arrayOf("Отношение", "Людей", "Икс")
                ), arrayOf("Отношение", "Является", "Эквивалентностью", "На", "Икс"),
                arrayOf("Отношение", "Людей", "Икс")
            ), Pair(arrayOf(4, 0), arrayOf(2, 0))
        )
    }

    @Test
    fun testFindLCS5() {
        assertEqualPair(
            findLCS(
                matrix(arrayOf("1", "2", "3"), arrayOf("3", "2", "1")),
                arrayOf("1", "2", "3"),
                arrayOf("3", "2", "1")
            ),
            Pair(arrayOf(2), arrayOf(0))
        )
    }
}