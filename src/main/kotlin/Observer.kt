import kotlin.properties.ObservableProperty
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

fun main(args: Array<String>) {
    val observer = Observer()
    val user = User(observer)

    println("Não executou")
    user.name = "teste"
    println("Executou")
}

inline fun <T> observable(initialValue: T,
                          crossinline beforeChange: (property: KProperty<*>, oldValue: T, newValue: T) -> Boolean,
                          crossinline afterChange: (property: KProperty<*>, oldValue: T, newValue: T) -> Unit): ReadWriteProperty<Any?, T> = object : ObservableProperty<T>(initialValue) {
    override fun afterChange(property: KProperty<*>, oldValue: T, newValue: T) = afterChange(property, oldValue, newValue)
    override fun beforeChange(property: KProperty<*>, oldValue: T, newValue: T) = beforeChange(property, oldValue, newValue)
}

interface PropertyObserver {
    fun willChange(propertyName: String, newPropertyValue: Any?)
    fun didChange(propertyName: String, oldPropertyValue: Any?)
}

class Observer : PropertyObserver {
    override fun willChange(propertyName: String, newPropertyValue: Any?) {
        if (newPropertyValue is String && newPropertyValue == "test") {
            println("Vai Mudar")
        }
    }

    override fun didChange(propertyName: String, oldPropertyValue: Any?) {
        if (oldPropertyValue is String && oldPropertyValue == "<no name>") {
            println("Ja mudou")
        }
    }
}

class User (val propertyObserver: PropertyObserver?) {
    var name: String by observable("<no name>", { prop, old, new ->
        println("Antes da mudança: $old -> $new")
        propertyObserver?.willChange(name, new)

        return@observable true
    }, { prop, old, new ->
        propertyObserver?.didChange(name, old)

        println("Depois da mudança: $old -> $new")
    })
}