package com.example.tugasp5

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.core.content.res.ResourcesCompat
import java.text.SimpleDateFormat
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BiodataScreen(menuAnchor: Modifier.Companion.() -> Unit, fillMaxWidth: Unit.() -> Unit) {
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
    val fieldColors = OutlinedTextFieldDefaults.colors(
        focusedBorderColor = colorResource(R.color.purple_title),
        unfocusedBorderColor = colorResource(R.color.field_border),
        focusedTextColor = colorResource(R.color.text_primary),
        unfocusedTextColor = colorResource(R.color.text_primary),
        focusedContainerColor = colorResource(R.color.white),
        unfocusedContainerColor = colorResource(R.color.white)
    )

    val checkboxColors = CheckboxDefaults.colors(
        checkedColor = colorResource(R.color.checkbox_checked),
        uncheckedColor = colorResource(R.color.checkbox_unchecked)
    )

    Scaffold( containerColor = colorResource(R.color.screen_background)){
            innerPadding ->
        Box(
            modifier = Modifier.fillMaxSize().padding(innerPadding)
        ) {
            Image(
                painter = painterResource(R.drawable.image),
                contentDescription = stringResource(R.string.cd_background),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(imageHeightFraction)
                    .align(Alignment.TopCenter)
            )
            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .fillMaxHeight(cardHeightFraction)
                    .shadow(
                        elevation = dimensionResource(R.dimen.card_elevation),
                        shape = cardShape
                    )
                    .clip(cardShape)
                    .background(colorResource(R.color.white))
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                        .padding(dimensionResource(R.dimen.card_padding)),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(R.string.title_form),
                        color = colorResource(R.color.purple_title),
                        fontSize = with(LocalDensity.current) {
                            dimensionResource(R.dimen.text_title).toSp()
                        },
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(Modifier.height(dimensionResource(R.dimen.title_gap)))
                    Text(
                        text = stringResource(R.string.subtitle_form),
                        color = colorResource(R.color.text_subtitle),
                        fontSize = with(LocalDensity.current) {
                            dimensionResource(R.dimen.text_subtitle).toSp()
                        },
                        textAlign = TextAlign.Center
                    )
                    Spacer(
                        Modifier.height(
                            dimensionResource(R.dimen.section_gap) + dimensionResource(R.dimen.field_gap)
                        )
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.field_gap))
                    ) {
                        OutlinedTextField(
                            value = namaDepan,
                            onValueChange = { namaDepan = it },
                            placeholder = { Text(stringResource(R.string.hint_nama_depan)) },
                            singleLine = true,
                            shape = fieldShape,
                            colors = fieldColors,
                            modifier = Modifier.weight(fieldWeight)
                        )
                        OutlinedTextField(
                            value = namaBelakang,
                            onValueChange = { namaBelakang = it },
                            placeholder = { Text(stringResource(R.string.hint_nama_belakang)) },
                            singleLine = true,
                            shape = fieldShape,
                            colors = fieldColors,
                            modifier = Modifier.weight(fieldWeight)
                        )
                    }
                    Spacer(Modifier.height(dimensionResource(R.dimen.section_gap)))

                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        placeholder = { Text(stringResource(R.string.hint_email)) },
                        singleLine = true,
                        shape = fieldShape,
                        colors = fieldColors,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(Modifier.height(dimensionResource(R.dimen.section_gap)))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.field_gap))
                    ) {
                        OutlinedTextField(
                            value = tglLahir,
                            onValueChange = {},
                            readOnly = true,
                            placeholder = { Text(stringResource(R.string.hint_tgl_lahir)) },
                            trailingIcon = {
                                IconButton(onClick = { showDatePicker = true }) {
                                    Icon(
                                        painter = painterResource(R.drawable.ic_calendar),
                                        contentDescription = stringResource(R.string.cd_pilih_tanggal)
                                    )
                                }
                            },
                            singleLine = true,
                            shape = fieldShape,
                            colors = fieldColors,
                            modifier = Modifier.weight(fieldWeight)
                        )
                        ExposedDropdownMenuBox(
                            expanded = expandedExperience,
                            onExpandedChange = { expandedExperience = it },
                            modifier = Modifier.weight(fieldWeight)
                        ) {
                            OutlinedTextField(
                                value = experience,
                                onValueChange = {},
                                readOnly = true,
                                placeholder = { Text(stringResource(R.string.hint_experience)) },
                                trailingIcon = {
                                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedExperience)
                                },
                                singleLine = true,
                                shape = fieldShape,
                                colors = fieldColors,
                                modifier = Modifier
                                    .menuAnchor()
                                    .fillMaxWidth()
                            )
                            ExposedDropdownMenu(
                                expanded = expandedExperience,
                                onDismissRequest = { expandedExperience = false }
                            ) {
                                experienceOptions.forEach { option ->
                                    DropdownMenuItem(
                                        text = { Text(option) },
                                        onClick = {
                                            experience = option
                                            expandedExperience = false
                                        }
                                    )
                                }
                            }
                        }
                    }
                    Spacer(Modifier.height(dimensionResource(R.dimen.section_gap)))

                    Text(
                        text = stringResource(R.string.label_skill),
                        color = colorResource(R.color.text_primary),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Checkbox(
                                checked = skillAndroid,
                                onCheckedChange = { skillAndroid = it },
                                colors = checkboxColors
                            )
                            Text(
                                text = teksAndroid,
                                color = colorResource(R.color.text_primary)
                            )
                        }
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Checkbox(
                                checked = skillUiUx,
                                onCheckedChange = { skillUiUx = it },
                                colors = checkboxColors
                            )
                            Text(
                                text = teksUiUx,
                                color = colorResource(R.color.text_primary)
                            )
                        }
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Checkbox(
                                checked = skillWeb,
                                onCheckedChange = { skillWeb = it },
                                colors = checkboxColors
                            )
                            Text(
                                text = teksWeb,
                                color = colorResource(R.color.text_primary)
                            )
                        }
                    }
                    Spacer(Modifier.height(dimensionResource(R.dimen.section_gap)))
                    HorizontalDivider(
                        thickness = dimensionResource(R.dimen.divider_tipis),
                        color = colorResource(R.color.field_border)
                    )
                    Spacer(Modifier.height(dimensionResource(R.dimen.section_gap)))

                    Button(
                        onClick = { tampilHasil = true },
                        enabled = formValid,
                        shape = RoundedCornerShape(dimensionResource(R.dimen.button_corner)),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(R.color.button_enabled),
                            contentColor = colorResource(R.color.white),
                            disabledContainerColor = colorResource(R.color.button_disabled),
                            disabledContentColor = colorResource(R.color.button_text_disabled)
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(dimensionResource(R.dimen.button_height))
                    ) {
                        Text(
                            text = stringResource(R.string.btn_proceed),
                            fontWeight = FontWeight.Bold
                        )
                    }
                    if (tampilHasil) {
                        Spacer(Modifier.height(dimensionResource(R.dimen.section_gap)))
                        HorizontalDivider(
                            thickness = dimensionResource(R.dimen.divider_tipis),
                            color = colorResource(R.color.field_border)
                        )
                        Spacer(Modifier.height(dimensionResource(R.dimen.section_gap)))
                        ElevatedCard(
                            shape = resultShape,
                            elevation = CardDefaults.cardElevation(
                                defaultElevation = dimensionResource(R.dimen.result_elevation)
                            ),
                            colors = CardDefaults.cardColors(
                                containerColor = colorResource(R.color.black)
                            ),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(modifier = Modifier.padding(dimensionResource(R.dimen.result_padding))) {
                                Text(
                                    text = stringResource(
                                        R.string.hasil_nama,
                                        namaDepan,
                                        namaBelakang
                                    ),
                                    color = colorResource(R.color.white)
                                )
                                Text(
                                    text = stringResource(R.string.hasil_email, email),
                                    color = colorResource(R.color.white)
                                )
                                Text(
                                    text = stringResource(R.string.hasil_tgl, tglLahir),
                                    color = colorResource(R.color.white)
                                )
                                Text(
                                    text = stringResource(R.string.hasil_experience, experience),
                                    color = colorResource(R.color.white)
                                )
                                Text(
                                    text = stringResource(R.string.hasil_skill, skillTerpilih),
                                    color = colorResource(R.color.white)
                                )
                            }
                        }
                    }
                }
            }
        }
    }

}