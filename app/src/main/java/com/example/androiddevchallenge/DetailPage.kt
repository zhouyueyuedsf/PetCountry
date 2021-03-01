package com.example.androiddevchallenge

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.data.PetInfo


@Composable
fun DetailPage(petInfo: PetInfo) {
    Scaffold(topBar = {
        TopAppBar(title = { Text(text = "宠物详情") })
    }) {
        Column(modifier = Modifier.padding(10.dp)) {
            PetItem(petInfo = petInfo, onItemClick = {})
            Text(text = "个性签名: ${petInfo.desc}", color = Color.Gray, fontSize = 14.sp)
        }
    }
}
