data class Estudiante(val nombre: String, val edad: Int, val curso: String)

fun listStudentResponse(edad: Int, filtro: (Int) -> List<Estudiante>): List<Estudiante> {
    return filtro(edad)
}

fun main() {
    // Crear una lista manual de 5 estudiantes
    val estudiantes = listOf(
        Estudiante("Juan", 20, "Matemáticas"),
        Estudiante("Ana", 17, "Física"),
        Estudiante("Luis", 22, "Química"),
        Estudiante("María", 16, "Historia"),
        Estudiante("Carlos", 19, "Ingeniería")
    )

    // Lambda que filtra estudiantes según la edad ingresada
    val filtroEstudiantes = { edad: Int ->
        estudiantes.filter { it.edad >= edad }
    }

    // Llamar a listStudentResponse con una edad >=18
    val estudiantesMayores = listStudentResponse(18, filtroEstudiantes)
    println("Estudiantes con edad >= 18:")
    estudiantesMayores.forEach { println("${it.nombre}, ${it.edad}, ${it.curso}") }

    // Lambda que filtra estudiantes menores a la edad ingresada
    val filtroEstudiantesMenores = { edad: Int ->
        estudiantes.filter { it.edad < edad }
    }

    // Llamar a listStudentResponse con una edad <18
    val estudiantesMenores = listStudentResponse(18, filtroEstudiantesMenores)
    println("\nEstudiantes con edad < 18:")
    estudiantesMenores.forEach { println("${it.nombre}, ${it.edad}, ${it.curso}") }
}