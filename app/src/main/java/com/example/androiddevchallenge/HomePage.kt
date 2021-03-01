package com.example.androiddevchallenge

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevchallenge.data.PetInfo

@Composable
fun HomePage(onItemClick: (Long) -> Unit) {
    Scaffold(topBar = {
        TopAppBar(title = { Text(text = "宠物领养") })
    }, floatingActionButton = {
        FloatingActionButton(onClick = { }) {
        }
    }) {
        val petHomePageViewModel: PetHomePageViewModel = viewModel()
        val petInfos by petHomePageViewModel.petInfos.observeAsState()
        LazyColumn(Modifier.background(Color.LightGray), verticalArrangement = Arrangement.spacedBy(5.dp)) {
            items(petInfos ?: emptyList()) { item ->
                PetItem(petInfo = item, onItemClick)
            }
        }
    }
}

@Composable
fun PetItem(petInfo: PetInfo, onItemClick: (Long) -> Unit) {
    Column {
        Row(
            modifier = Modifier
                .padding(3.dp).clickable(onClick = {
                    onItemClick.invoke(petInfo.id)
                })
                .background(Color.White)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            val preText = "铲屎官:"
            Image(
                modifier = Modifier.width(48.dp).height(48.dp),
                painter = painterResource(id = petInfo.headerUri),
                contentDescription = "头像"
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column {
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = petInfo.name, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Spacer(modifier = Modifier.height(10.dp))
                Row {
                    Tag(text = petInfo.age, Color.Blue)
                    Spacer(modifier = Modifier.width(5.dp))
                    Tag(text = petInfo.breed, Color.Magenta)
                    Spacer(modifier = Modifier.width(5.dp))
                    Tag(text = petInfo.sign, Color.Gray)
                }
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "$preText ${petInfo.hostName}" , color = Color.Gray, fontSize = 8.sp)
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}

@Composable
fun Tag(text: String, background: Color) {
    Column(
        modifier = Modifier
            .background(color = background, shape = RoundedCornerShape(4.dp))
    ) {
        Text(
            text = text,
            fontSize = 8.sp,
            color = Color.White,
            modifier = Modifier.padding(5.dp, 2.dp)
        )
    }
}