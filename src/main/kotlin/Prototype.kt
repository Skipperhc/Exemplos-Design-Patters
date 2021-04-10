open class Carro : Cloneable
{
    private var modelo : String? = null
    private var marca : String? = null
    private var valor : Double = 0.0

    init
    {
        modelo = "Gol"
        marca = "Volkswagen"
        valor = 30.599
    }

    public override fun clone() : Carro
    {
        return Carro();
    }

    fun transformarGolTSI ()
    {
        modelo = "Gol TSI"
        valor = 50.546
    }

    public override fun toString(): String {
        return "Modelo: $modelo Marca: $marca Valor: $valor";
    }
}

fun main(args: Array<String>) {
    val gol = Carro();
    println("Carro padrao (init):\n$gol\n")

    val cloneGol = gol.clone()
    println("Carro clone:\n$cloneGol\n")

    val golTSI = golParaGolTSI(cloneGol)
    println("Carro transformado:\n$golTSI")
    println("Carro padrao após o clone:\n$gol")
    println("Carro clone após transformação:\n$cloneGol")
}

fun golParaGolTSI(gol : Carro) : Carro
{
    gol.transformarGolTSI()
    return gol
}