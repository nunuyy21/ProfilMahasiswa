
package com.nurul.profilmahasiswa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Ungu = Color(0xFF8055A5)
private val UnguMuda = Color(0xFFF5EFFA)
private val Pink = Color(0xFFE8BFD8)
private val Teks = Color(0xFF403449)
private val Putih = Color.White

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                FormProfilMahasiswa()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormProfilMahasiswa() {

    // STATE: menyimpan data mahasiswa
    var nama by remember { mutableStateOf("") }
    var nim by remember { mutableStateOf("") }
    var prodi by remember { mutableStateOf("") }
    var semester by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }

    var semesterMenu by remember { mutableStateOf(false) }
    var profilTersimpan by remember { mutableStateOf(false) }
    var pesanError by remember { mutableStateOf("") }

    val daftarSemester = listOf(
        "Semester 1",
        "Semester 2",
        "Semester 3",
        "Semester 4",
        "Semester 5",
        "Semester 6",
        "Semester 7",
        "Semester 8"
    )

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = UnguMuda
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            // HEADER APLIKASI
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Ungu
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "PROFIL MAHASISWA",
                        fontSize = 23.sp,
                        fontWeight = FontWeight.Bold,
                        color = Putih
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Lengkapi data diri kamu",
                        fontSize = 14.sp,
                        color = Putih
                    )
                }
            }

            // FORM DATA MAHASISWA
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Putih
                )
            ) {
                Column(
                    modifier = Modifier.padding(18.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(
                        text = "Data Diri",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Ungu
                    )

                    OutlinedTextField(
                        value = nama,
                        onValueChange = {
                            nama = it
                            profilTersimpan = false
                            pesanError = ""
                        },
                        label = { Text("Nama Lengkap") },
                        placeholder = { Text("Masukkan nama lengkap") },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true
                    )

                    OutlinedTextField(
                        value = nim,
                        onValueChange = {
                            nim = it
                            profilTersimpan = false
                            pesanError = ""
                        },
                        label = { Text("NIM") },
                        placeholder = { Text("Masukkan NIM") },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number
                        ),
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true
                    )

                    OutlinedTextField(
                        value = prodi,
                        onValueChange = {
                            prodi = it
                            profilTersimpan = false
                            pesanError = ""
                        },
                        label = { Text("Program Studi") },
                        placeholder = {
                            Text("Contoh: Sistem Informasi")
                        },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true
                    )

                    // EVENT: memilih semester
                    ExposedDropdownMenuBox(
                        expanded = semesterMenu,
                        onExpandedChange = {
                            semesterMenu = !semesterMenu
                        }
                    ) {
                        OutlinedTextField(
                            value = semester,
                            onValueChange = {},
                            readOnly = true,
                            label = { Text("Semester") },
                            placeholder = { Text("Pilih semester") },
                            trailingIcon = {
                                ExposedDropdownMenuDefaults
                                    .TrailingIcon(
                                        expanded = semesterMenu
                                    )
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .menuAnchor()
                        )

                        ExposedDropdownMenu(
                            expanded = semesterMenu,
                            onDismissRequest = {
                                semesterMenu = false
                            }
                        ) {
                            daftarSemester.forEach { pilihan ->
                                DropdownMenuItem(
                                    text = { Text(pilihan) },
                                    onClick = {
                                        semester = pilihan
                                        semesterMenu = false
                                        profilTersimpan = false
                                        pesanError = ""
                                    }
                                )
                            }
                        }
                    }

                    OutlinedTextField(
                        value = email,
                        onValueChange = {
                            email = it
                            profilTersimpan = false
                            pesanError = ""
                        },
                        label = { Text("Email") },
                        placeholder = { Text("nama@email.com") },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Email
                        ),
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true
                    )

                    OutlinedTextField(
                        value = alamat,
                        onValueChange = {
                            alamat = it
                            profilTersimpan = false
                            pesanError = ""
                        },
                        label = { Text("Alamat") },
                        placeholder = { Text("Masukkan alamat") },
                        modifier = Modifier.fillMaxWidth(),
                        minLines = 2,
                        maxLines = 3
                    )

                    if (pesanError.isNotEmpty()) {
                        Text(
                            text = pesanError,
                            color = Color.Red,
                            fontSize = 13.sp
                        )
                    }

                    // EVENT: tombol simpan
                    Button(
                        onClick = {
                            if (
                                nama.isBlank() ||
                                nim.isBlank() ||
                                prodi.isBlank() ||
                                semester.isBlank()
                            ) {
                                pesanError =
                                    "Nama, NIM, prodi, dan semester wajib diisi."
                                profilTersimpan = false
                            } else {
                                pesanError = ""
                                profilTersimpan = true
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(52.dp),
                        shape = RoundedCornerShape(14.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Ungu
                        )
                    ) {
                        Text(
                            text = "Simpan Profil",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    OutlinedButton(
                        onClick = {
                            nama = ""
                            nim = ""
                            prodi = ""
                            semester = ""
                            email = ""
                            alamat = ""
                            pesanError = ""
                            profilTersimpan = false
                        },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(14.dp)
                    ) {
                        Text("Reset Form")
                    }
                }
            }

            // RECOMPOSITION: pratinjau mengikuti perubahan state
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Putih
                )
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(
                        text = "Pratinjau Profil",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Ungu
                    )

                    HorizontalDivider(color = Pink)

                    BarisProfil("Nama", nama)
                    BarisProfil("NIM", nim)
                    BarisProfil("Program Studi", prodi)
                    BarisProfil("Semester", semester)
                    BarisProfil("Email", email)
                    BarisProfil("Alamat", alamat)

                    if (profilTersimpan) {
                        Text(
                            text = "Profil berhasil disimpan!",
                            color = Color(0xFF287D48),
                            fontWeight = FontWeight.Bold
                        )
                    } else {
                        Text(
                            text = "Pratinjau berubah otomatis saat data diedit.",
                            color = Ungu,
                            fontSize = 12.sp
                        )
                    }
                }
            }

            Text(
                text = "Kotlin • Jetpack Compose",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.dp),
                color = Ungu,
                fontSize = 12.sp
            )
        }
    }
}

@Composable
fun BarisProfil(label: String, nilai: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.Top
    ) {
        Text(
            text = "$label:",
            modifier = Modifier.width(105.dp),
            fontWeight = FontWeight.SemiBold,
            color = Teks
        )

        Text(
            text = nilai.ifBlank { "-" },
            modifier = Modifier.weight(1f),
            color = Teks
        )
    }
}
