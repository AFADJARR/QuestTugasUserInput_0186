package com.example.tugasp5

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BiodataScreen(){
    var namaDepan by remember { mutableStateOf(String()) }
    var namaBelakang by remember { mutableStateOf(String()) }
    var email by remember { mutableStateOf(String()) }
    var tglLahir by remember { mutableStateOf(String()) }
    var experience by remember { mutableStateOf(String()) }
    var skillAndroid by remember { mutableStateOf(false) }
    var skillUiUx by remember { mutableStateOf(false) }
    var skillWeb by remember { mutableStateOf(false) }
}