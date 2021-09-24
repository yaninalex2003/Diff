import kotlin.test.*

internal class TestAns {

    @Test
    fun testAns1() {
        assertContentEquals(
            findAns(
                arrayOf("РОмчик", "Приходил", "Сегодня"),
                arrayOf("Ромчик", "Приходил", "Сегодня"),
                arrayOf(2, 1),
                arrayOf(2, 1)
            ), arrayOf("$RED- 1: РОмчик", "$GREEN+ 1: Ромчик")
        )
    }

    @Test
    fun testAns2() {
        assertContentEquals(
            findAns(
                arrayOf("Жили", "Были", "Дед", "И", "Баба"), arrayOf("Жили", "Дед", "И", "Дед"),
                arrayOf(3, 2, 0), arrayOf(2, 1, 0)
            ), arrayOf(
                "$RED- 5: Баба",
                "$GREEN+ 5: Дед",
                "$RED- 2: Были"
            )
        )
    }

    @Test
    fun testAns3() {
        assertContentEquals(
            findAns(
                arrayOf("0", "1", "2"),
                arrayOf("3", "4", "5"),
                arrayOf(),
                arrayOf()
            ), arrayOf(
                "$RED- 3: 2",
                "$RED- 2: 1",
                "$RED- 1: 0",
                "$GREEN+ 1: 5",
                "$GREEN+ 1: 4",
                "$GREEN+ 1: 3"
            )
        )
    }

    @Test
    fun testAns4() {
        assertContentEquals(
            findAns(
                arrayOf("Отношение", "Является", "Эквивалентностью", "На", "Икс"),
                arrayOf("Отношение", "Людей", "Икс"),
                arrayOf(4, 0),
                arrayOf(2, 0)
            ), arrayOf(
                "$RED- 4: На",
                "$RED- 3: Эквивалентностью",
                "$RED- 2: Является",
                "$GREEN+ 2: Людей"
            )
        )
    }

    @Test
    fun testAns5() {
        assertContentEquals(
            findAns(
                arrayOf("1", "2", "3"), arrayOf("3", "2", "1"),
                arrayOf(2), arrayOf(0)
            ), arrayOf(
                "$GREEN+ 4: 1",
                "$GREEN+ 4: 2",
                "$RED- 2: 2",
                "$RED- 1: 1"
            )
        )
    }
}