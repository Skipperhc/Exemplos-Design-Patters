class Singleton private constructor() {
    init { println("Isso ($this) é um singleton") }

    private object Holder { val INSTANCE = Singleton() }

    companion object {
        val instance: Singleton by lazy { Holder.INSTANCE }
    }
    var b:String? = null
}

fun main() {
    val first = Singleton.instance
    first.b = "OIII singleton"

    val second = Singleton.instance
    println(first.b)
    println(second.b)
    //mesmo objeto o tempo todo
    println(first)
    println(second)
}