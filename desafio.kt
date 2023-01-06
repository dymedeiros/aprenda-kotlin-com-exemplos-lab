// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val nome: String, val matricula: String)
{
    override fun toString(): String {
        return "$nome (matrícula $matricula)"
    }
}

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)
{
    override fun toString(): String {
        return "$nome (Duração: $duracao)"
    }
}

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(vararg usuario: Usuario) {
        inscritos.addAll(usuario)
    }

    override fun toString(): String
    {
        return """
        Formação: $nome
        Conteúdo educacional: $conteudos
        Nível: $nivel
        Alunos inscritos na Formação: $inscritos
        """.trimIndent()
    }
}

fun gerarMatricula(): String {
    return (1000..10000).random().toString()
}

fun main() {
    val samuel = Usuario("Samuel", gerarMatricula())
    val paula = Usuario("Paula", gerarMatricula())

    val conteudoEducacionalAndroid = ConteudoEducacional("Formação desenvolvedor Android", 80)
    val conteudoEducacionalIOS = ConteudoEducacional("Formação desenvolvedor IOS", 44)

    val formacaoMobile =
            Formacao(
                    "Formação Mobile Developer",
                    listOf(
                            conteudoEducacionalAndroid,
                            conteudoEducacionalIOS
                    ),
                    Nivel.AVANCADO
            )

    formacaoMobile.matricular(paula, samuel)

    println(formacaoMobile)
    println("\n**********************\n")
}
