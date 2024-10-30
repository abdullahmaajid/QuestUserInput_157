package com.example.activity4_userinput

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun latihaninput(modifier: Modifier = Modifier){

    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var noHp by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }

    var nama1 by remember { mutableStateOf("") }
    var email1 by remember { mutableStateOf("") }
    var noHp1 by remember { mutableStateOf("") }
    var alamat1 by remember { mutableStateOf("") }
    var gender1 by remember { mutableStateOf("") }
    val datagender = listOf("LK", "P")



    Column (modifier = modifier
        .fillMaxSize()
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally){
        Text(text = "Biodata",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp)

        Spacer(modifier = Modifier.padding(20.dp))

        TextField (
            value = nama,
            onValueChange = {nama = it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            label = {Text("Nama")},
            placeholder = {Text("Masukkan Nama Anda")}
        )

        Row (
            modifier = Modifier.fillMaxWidth()) {       //mengganti variabel modifier dengan Modifier
            datagender.forEach{ selectedGender ->
                Row (verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = gender == selectedGender,
                        onClick = {
                            gender = selectedGender
                        })
                }
                Text(text = selectedGender) }
        }

        TextField (
            value = email,
            onValueChange = {email = it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            label = {Text("Email")},
            placeholder = {Text("Masukkan Email Anda")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        TextField (
            value = noHp,
            onValueChange = {noHp = it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            label = {Text("Nomor Handphone")},
            placeholder = {Text("Masukkan Nomor Handphone Anda")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        TextField (
            value = alamat,
            onValueChange = {alamat = it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            label = {Text("Alamat")},
            placeholder = {Text("Masukkan Alamat Anda")},
        )

        Button(onClick = {
            nama1 = nama
            gender1 = gender
            email1 = email
            noHp1 = noHp
            alamat1 = alamat

        }, modifier = Modifier.padding(vertical = 10.dp)
            )

        {
            Text("Simpan")
        }


        Card(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)) {
            Column {
                TampilData(param = "nama" , argu = nama1 )
                TampilData(param = "gender" , argu = gender1 )
                TampilData(param = "email" , argu = email1 )
                TampilData(param = "noHp" , argu = noHp1 )
                TampilData(param = "alamat" , argu = alamat1 )
            }
        }
    }
}

@Composable
fun TampilData(param: String, argu: String) {
    Column (
        modifier = Modifier.padding(16.dp)
    ) {
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = param,
                modifier = Modifier.weight(0.8f))
            Text(text = ":",
                modifier = Modifier.weight(0.2f))
            Text(text = argu,
                modifier = Modifier.weight(2f))

        }
    }
}