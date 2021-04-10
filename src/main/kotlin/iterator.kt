fun main() {
    val iterator = ListarLivros().getIterator()

    while(iterator.hasNext()){
        print(iterator.next())
    }
}

interface Iterator {
    fun hasNext(): Boolean
    fun next(): String?
}

interface Container {
    fun getIterator():Iterator
}

class Livro(val nome: String, val autor: String) {
    override fun toString(): String = "Livro: " + nome + "\n" + "Autor: "+ autor + "\n\n"
}

var listaLivros = ArrayList<Livro>()

class ListarLivros: Container{

    private fun addLivros() {
        listaLivros.add(Livro("A Sociedade do Anel", "J.R.R.Tolkien"))
        listaLivros.add(Livro("As Duas Torres", "J.R.R.Tolkien"))
        listaLivros.add(Livro("O Retorno do Rei", "J.R.R.Tolkien"))
        listaLivros.add(Livro("O Hobbit", "J.R.R.Tolkien"))
    }

    override fun getIterator(): Iterator {
        addLivros()
        return Livros()
    }

    class Livros: Iterator {

        var posicao = 0;

        override fun hasNext(): Boolean {
            if (posicao < listaLivros!!.size) {
                return true
            }
            return false
        }

        override fun next(): String? {
            if (this.hasNext()) {
                return listaLivros!!.get(posicao++).toString()
            }
            return null
        }
    }


}