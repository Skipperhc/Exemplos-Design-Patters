interface Cor {
    fun getCor()
}

class Amarelo: Cor {
    override fun getCor() {
        println("Amarelo")
    }
}

class Vermelho: Cor {
    override fun getCor() {
        println("Vermelho")
    }
}

interface Casa {
    val Cor: Cor
    fun Exibir()
}

class CasaMadeira(override val Cor: Cor): Casa {
    override fun Exibir() {
        print("A cor da casa de madeira é: ")
        Cor.getCor()
    }
}

class CasaPedra(override val Cor: Cor): Casa {
    override fun Exibir() {
        print("A cor da casa de pedra é:  ")
        Cor.getCor()
    }
}

fun main() {
    val AmareloCasaMadeira = CasaMadeira(Cor = Amarelo())
    AmareloCasaMadeira.Exibir()

    val AmareloCasaPedra = CasaPedra(Cor = Amarelo())
    AmareloCasaPedra.Exibir()

    val VermelhoCasaMadeira = CasaMadeira(Cor = Vermelho())
    VermelhoCasaMadeira.Exibir()

    val VermelhoCasaPedra = CasaPedra(Cor = Vermelho())
    VermelhoCasaPedra.Exibir()
}