private fun currentFunctionName(): String = TODO()

fun main() {
  println(currentFunctionName()) // "main" 출력

  val lambda = { println(currentFunctionName()) }
  lambda.invoke() // "<anonymous>" 출력

  otherFunction() // "otherFunction" 출력
}

fun otherFunction() {
  println(currentFunctionName())
}
