## Kotlin Compiler Plugin Taste Sample

코틀린 컴파일러 플러그인 맛보기 행사 샘플 프로젝트

```kotlin
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

```

---

### Run

```
./gradlew :sample:run
```
