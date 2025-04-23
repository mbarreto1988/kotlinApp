package com.example.kotlinapp

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.unit.dp



data class Nota(val titulo: String, val contenido: String)

@Composable
fun kotlinAppView(modifier: Modifier = Modifier) {
    var titulo by remember { mutableStateOf("") }
    var contenido by remember { mutableStateOf("") }
    var notas by remember { mutableStateOf(listOf<Nota>()) }

    Column(modifier = modifier.padding(16.dp)) {
        Text("Título:")
        BasicTextField(
            value = titulo,
            onValueChange = { titulo = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )

        Text("Contenido:")
        BasicTextField(
            value = contenido,
            onValueChange = { contenido = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )

        Button(onClick = {
            if (titulo.isNotBlank() && contenido.isNotBlank()) {
                notas = notas + Nota(titulo, contenido)
                titulo = ""
                contenido = ""
            }
        }) {
            Text("Agregar nota")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Notas agregadas:")
        notas.forEach { nota ->
            Column(modifier = Modifier.padding(vertical = 4.dp)) {
                Text("📌 ${nota.titulo}")
                Text(nota.contenido)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun kotlinAppViewPreview() {
    kotlinAppView()
}