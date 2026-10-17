package com.example.tugasp5

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.core.content.res.ResourcesCompat
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

    val skillKosong = stringResource(R.string.hasil_skill_kosong)
    val pemisahSkill = stringResource(R.string.pemisah_skill)
    val teksAndroid = stringResource(R.string.skill_android)
    val teksUiUx = stringResource(R.string.skill_uiux)
    val teksWeb = stringResource(R.string.skill_web)
    val skillTerpilih = listOfNotNull(
        teksAndroid.takeIf { skillAndroid },
        teksUiUx.takeIf { skillUiUx },
        teksWeb.takeIf { skillWeb }
    ).joinToString(pemisahSkill).ifEmpty { skillKosong }

    val formValid = namaDepan.isNotBlank() &&
            namaBelakang.isNotBlank() &&
            email.isNotBlank() &&
            tglLahir.isNotBlank()
    val resources = LocalContext.current.resources
    val imageHeightFraction = ResourcesCompat.getFloat(resources, R.dimen.image_height_fraction)
    val cardHeightFraction = ResourcesCompat.getFloat(resources, R.dimen.card_height_fraction)
    val fieldWeight = ResourcesCompat.getFloat(resources, R.dimen.field_weight)

    val fieldShape = RoundedCornerShape(dimensionResource(R.dimen.field_corner))
    val resultShape = RoundedCornerShape(dimensionResource(R.dimen.result_corner))
    val cardShape = RoundedCornerShape(
        topStart = dimensionResource(R.dimen.card_corner),
        topEnd = dimensionResource(R.dimen.card_corner)
    )
}