package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.data.PetDataSource.petInfos
import com.example.androiddevchallenge.data.PetInfo
import com.example.androiddevchallenge.ui.theme.MyTheme
import kotlinx.coroutines.launch

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val id = intent.getLongExtra("itemId", -1L)
        val petInfo = petInfos.first { id == it.id }
        setContent {
            MyTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    DetailPage(petInfo)
                }
            }
        }
    }
}

@Composable
fun DetailPage(petInfo: PetInfo) {
    val snackbarHostState = SnackbarHostState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "宠物详情") })
        },
        snackbarHost = {
            SnackbarHost(snackbarHostState)
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    coroutineScope.launch {
                        snackbarHostState.showSnackbar("你已经领养了 ${petInfo.name}")
                    }
                }
            ) {
                Text(text = "领养", color = Color.White, fontWeight = FontWeight.Bold)
            }
        }
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp),
                painter = painterResource(id = petInfo.headerUri),
                contentDescription = ""
            )
            Column(modifier = Modifier.padding(10.dp)) {
                Row {
                    PetItem(petInfo = petInfo)
                }
                Text(text = "个性签名: ${petInfo.desc}", color = Color.Gray, fontSize = 14.sp)
            }
        }
    }
}
