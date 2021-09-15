import kotlin.test.*

fun assertEqualMatrix(table1: Array<Array<Int>>, table2: Array<Array<Int>>) {
    assert(table1.size == table2.size)
    for (i in table1.indices) {
        assertContentEquals(table1[i], table2[i])
    }
}

internal class TestMatrix {

    @Test
    fun testTestMatrix1() {
        assertEqualMatrix(
            matrix(arrayOf("РОмчик", "Приходил", "Сегодня"), arrayOf("Ромчик", "Приходил", "Сегодня")),
            arrayOf(arrayOf(0, 0, 0, 0), arrayOf(0, 0, 0, 0), arrayOf(0, 0, 1, 1), arrayOf(0, 0, 1, 2))
        )
    }

    @Test
    fun testTestMatrix2() {
        assertEqualMatrix(
            matrix(arrayOf("Жили", "Были", "Дед", "И", "Баба"), arrayOf("Жили", "Дед", "И", "Дед")),
            arrayOf(
                arrayOf(0, 0, 0, 0, 0, 0),
                arrayOf(0, 1, 1, 1, 1, 1),
                arrayOf(0, 1, 1, 2, 2, 2),
                arrayOf(0, 1, 1, 2, 3, 3),
                arrayOf(0, 1, 1, 2, 3, 3)
            )
        )
    }

    @Test
    fun testTestMatrix3() {
        assertEqualMatrix(
            matrix(arrayOf("0", "1", "2"), arrayOf("3", "4", "5")),
            arrayOf(arrayOf(0, 0, 0, 0), arrayOf(0, 0, 0, 0), arrayOf(0, 0, 0, 0), arrayOf(0, 0, 0, 0))
        )
    }

    @Test
    fun testTestMatrix4() {
        assertEqualMatrix(
            matrix(
                arrayOf("Отношение", "Является", "Эквивалентностью", "На", "Икс"),
                arrayOf("Отношение", "Людей", "Икс")
            ),
            arrayOf(
                arrayOf(0, 0, 0, 0, 0, 0),
                arrayOf(0, 1, 1, 1, 1, 1),
                arrayOf(0, 1, 1, 1, 1, 1),
                arrayOf(0, 1, 1, 1, 1, 2)
            )
        )
    }

    @Test
    fun testTestMatrix5() {
        assertEqualMatrix(
            matrix(arrayOf("1", "2", "3"), arrayOf("3", "2", "1")),
            arrayOf(arrayOf(0, 0, 0, 0), arrayOf(0, 0, 0, 1), arrayOf(0, 0, 1, 1), arrayOf(0, 1, 1, 1))
        )
    }
}
