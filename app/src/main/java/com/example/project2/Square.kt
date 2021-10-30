package com.example.project2

data class Square(val alive: Boolean = false,
                  val location: Map<Char, Int?> = mapOf('X' to null, 'Y' to null))