import kotlin.test.*

fun assertEqualPair(twoArrays1: Array<Array<Int>>, twoArrays2: Array<Array<Int>>) {
    assert(twoArrays1.size == twoArrays2.size)
    for (i in twoArrays1.indices) {
        assertContentEquals(twoArrays1[i], twoArrays2[i])
    }
}

internal class TestFindLCS {

    @Test
    fun testFindLCS() {
        assertEqualPair(
            findLCS(
                matrix(arrayOf("РОмчик", "Приходил", "Сегодня"), arrayOf("Ромчик", "Приходил", "Сегодня"))
                , arrayOf("РОмчик", "Приходил", "Сегодня"), arrayOf("Ромчик", "Приходил", "Сегодня")
            ), arrayOf(arrayOf(2, 1), arrayOf(2, 1))
        )
        assertEqualPair(
            findLCS(
                matrix(arrayOf("Жили", "Были", "Дед", "И", "Баба"), arrayOf("Жили", "Дед", "И", "Дед"))
                , arrayOf("Жили", "Были", "Дед", "И", "Баба"), arrayOf("Жили", "Дед", "И", "Дед")
            ), arrayOf(arrayOf(3, 2, 0), arrayOf(2, 1, 0))
        )
        assertEqualPair(
            findLCS(
                matrix(
                    arrayOf("0", "1", "2"),
                    arrayOf("3", "4", "5")
                ), arrayOf("0", "1", "2"),
                arrayOf("3", "4", "5")
            ), arrayOf(arrayOf(), arrayOf())
        )
        assertEqualPair(
            findLCS(
                matrix(
                    arrayOf("Отношение", "Является", "Эквивалентностью", "На", "Икс"),
                    arrayOf("Отношение", "Людей", "Икс")
                ), arrayOf("Отношение", "Является", "Эквивалентностью", "На", "Икс"),
                arrayOf("Отношение", "Людей", "Икс")
            ), arrayOf(arrayOf(4, 0), arrayOf(2, 0))
        )
        assertEqualPair(
            findLCS(
                matrix(arrayOf("1", "2", "3"), arrayOf("3", "2", "1")),
                arrayOf("1", "2", "3"),
                arrayOf("3", "2", "1")
            ),
            arrayOf(arrayOf(2), arrayOf(0))
        )
    }
}