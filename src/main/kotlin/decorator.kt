abstract class Sorvete {
    abstract fun getDescription(): String
}

class SorveteDeBaunilha : Sorvete() {
    override fun getDescription() = "SORVETE DE BAUNILHA"
}

class SorveteDeMorango : Sorvete() {
    override fun getDescription() = "SORVETE DE MORANGO"
}

class SorveteDeChocolate : Sorvete() {
    override fun getDescription() = "SORVETE DE CHOCOLATE"
}

abstract class CoberturaDecorator() : Sorvete() {
    abstract fun addCobertura(): String
}

class CoberturaDeMelDecorator(private val sorvete: Sorvete) : CoberturaDecorator() {
    override fun getDescription() = sorvete.getDescription() + addCobertura()
    override fun addCobertura() = " COM COBERTURA DE MEL &"
}

class CoberturaDeNozesDecorator(private val sorvete: Sorvete) : CoberturaDecorator() {
    override fun getDescription() = sorvete.getDescription() + addCobertura()
    override fun addCobertura() = " COM COBERTURA DE NOZES &"
}

fun main() {
    val sorveteDeBaunilhaComCoberturaDeMel = CoberturaDeMelDecorator(SorveteDeBaunilha())
    val sorveteDeBaunilhaComCoberturaDeMelDescription = sorveteDeBaunilhaComCoberturaDeMel.getDescription()
    println("You ordered: ${sorveteDeBaunilhaComCoberturaDeMelDescription.trimEnd('&')}")

    val sorveteDeMorangoComCoberturaDeNozes = CoberturaDeNozesDecorator(SorveteDeMorango())
    val sorveteDeMorangoComCoberturaDeNozesDescription = sorveteDeMorangoComCoberturaDeNozes.getDescription()
    println("You ordered: ${sorveteDeMorangoComCoberturaDeNozesDescription.trimEnd('&')}")

    val sorveteDeChocolateComCoberturaDeMeleNozes = CoberturaDeNozesDecorator(CoberturaDeMelDecorator(SorveteDeChocolate()))
    val sorveteDeChocolateComCoberturaDeMeleNozesDescription = sorveteDeChocolateComCoberturaDeMeleNozes.getDescription()
    println("You ordered: ${sorveteDeChocolateComCoberturaDeMeleNozesDescription.trimEnd('&')}")
}