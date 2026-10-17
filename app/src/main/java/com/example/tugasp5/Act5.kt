package com.example.tugasp5

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import java.text.SimpleDateFormat
import java.util.Locale

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

    var showDatePicker by remember { mutableStateOf(false) }
    var expandedExperience by remember { mutableStateOf(false) }
    var tampilHasil by remember { mutableStateOf(false) }

    val datePickerState = rememberDatePickerState()
    val experienceOptions = stringArrayResource(R.array.experience_options)
    val dateFormat = SimpleDateFormat(stringResource(R.string.format_tanggal), Locale.getDefault())
}