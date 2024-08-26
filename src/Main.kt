import java.io.File

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    println("1. Задание")
    val outStroke1 = "Я проверяю возможность записи текста в файл"
    val outStroke2 = "Я проверяю возможность добавления текста в файл\nИ чтения текста из файла"
    val file = File("D://AndroidFail/fail_module_12_number_4")

    saveTextInFile(outStroke1, outStroke2, file)
    println("Читаем текст, записанный в файл")
    readTextFile(file)

    getLine("-")

    println("\n2. Задание\n")

    val n = 100

    file.writeText("2\n")

    for (i in 3..100) {
        if (i % 2 == 0) {
            file.appendText(i.toString() + "\n")
        }
    }
    println(
        "Значения первых положительных четных чисел в диапазоне [2..$n] записаны в файл: ${file.absolutePath}\n"
    )
    getLine("-")
    println("\n3.Задание\n")

    val sizeFile = file.bufferedReader().readLines().size
    println("Дан файл с количеством элементов: $sizeFile\n")

    val firstNumber = file.bufferedReader().useLines { it.first() }
    println("Первый элемент файла: $firstNumber")

    val secondNumber = file.bufferedReader().readLines()[1]
    println("Второй элемент файла: $secondNumber")

    val penultimateOneNumber = file.bufferedReader().readLines()[file.bufferedReader().readLines().size - 2]
    println("Предпоследний элемент файла: $penultimateOneNumber")

    val lastNumber = file.bufferedReader().useLines { it.last() }
    println("Последний элемент файла: $lastNumber")
}

fun saveTextInFile(text: String, textAppend: String, file: File) {
    file.writeText(text)
    file.appendText("\n" + textAppend)
}

fun readTextFile(file: File) {
    val textRead = file.bufferedReader().readText()
    println(textRead)
}