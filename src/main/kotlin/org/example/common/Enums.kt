package org.example.common


enum class Region {
    IR,
    US,
    RU,
}

enum class Color(value: String) {
    RED("#CODE-COLOR"),
    GREEN("#CODE-COLOR"),
    BLUE("#CODE-COLOR")
}

enum class DatabaseSource(index: Int) {
    PRIMARY(0),
    SECONDARY(1)
}