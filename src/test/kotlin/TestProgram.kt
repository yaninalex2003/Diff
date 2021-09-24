import kotlin.test.*

internal class TestProgram {

    @Test
    fun testTestProgram1() {
        val text1 = scanFile("test1.txt")
        val text2 = scanFile("test2.txt")
        val ourMatrix = matrix(text1, text2)
        val pairOurLCS = findLCS(ourMatrix, text1, text2)
        val ourAnsArray = findAns(text1, text2, pairOurLCS.first, pairOurLCS.second)
        assertContentEquals(
            ourAnsArray, arrayOf(
                "$GREEN+ 25: для данного документа.",
                "$GREEN+ 25: важные дополнения",
                "$GREEN+ 25: Этот абзац содержит",
                "$GREEN+ 25: ",
                "$RED- 17: необходима провести",
                "$GREEN+ 17: необходимо провести",
                "$RED- 15: ",
                "$RED- 14: в ближайшем будущем.",
                "$RED- 13: Он будет удалён",
                "$RED- 12: устаревший текст.",
                "$RED- 11: Этот абзац содержит",
                "$RED- 10: ",
                "$RED- 9: изменений.",
                "$RED- 8: объёма произведённых",
                "$GREEN+ 8:  ",
                "$GREEN+ 8: объёма информации.",
                "$GREEN+ 1: ",
                "$GREEN+ 1: документа!",
                "$GREEN+ 1: в начале этого",
                "$GREEN+ 1: быть расположено",
                "$GREEN+ 1: Поэтому оно должно",
                "$GREEN+ 1: Это важное замечание!",
            )
        )
    }

    @Test
    fun testTestProgram2() {
        val text1 = scanFile("test1.txt")
        val text2 = scanFile("test3.txt")
        val ourMatrix = matrix(text1, text2)
        val pairOurLCS = findLCS(ourMatrix, text1, text2)
        val ourAnsArray = findAns(text1, text2, pairOurLCS.first, pairOurLCS.second)
        assertContentEquals(
            ourAnsArray, arrayOf(
                "$RED- 24: добавлять в конец документа.",
                "$RED- 23: Новый текст можно",
                "$RED- 22: не требует изменений.",
                "$RED- 21: Остальная часть абзаца",
                "$RED- 20: в слове - не конец света.",
                "$RED- 19: С другой стороны, ошибка",
                "$RED- 18: проверку правописания.",
                "$RED- 17: необходима провести",
                "$RED- 16: В этом документе",
                "$RED- 15: ",
                "$RED- 14: в ближайшем будущем.",
                "$RED- 13: Он будет удалён",
                "$RED- 12: устаревший текст.",
                "$RED- 11: Этот абзац содержит",
                "$RED- 10: ",
                "$RED- 9: изменений.",
                "$RED- 8: объёма произведённых",
                "$RED- 7: выводу оптимального",
                "$RED- 6: Иначе это не способствует",
                "$RED- 5: не должна отображаться.",
                "$RED- 4: в ней нет изменений, она",
                "$RED- 3: от версии к версии. Если",
                "$RED- 2: оставалась неизменной",
                "$RED- 1: Эта часть документа"

            )
        )
    }

    @Test
    fun testTestProgram3() {
        val text1 = scanFile("test3.txt")
        val text2 = scanFile("test3.txt")
        val ourMatrix = matrix(text1, text2)
        val pairOurLCS = findLCS(ourMatrix, text1, text2)
        val ourAnsArray = findAns(text1, text2, pairOurLCS.first, pairOurLCS.second)
        assertContentEquals(
            ourAnsArray, arrayOf()
        )
    }
}

