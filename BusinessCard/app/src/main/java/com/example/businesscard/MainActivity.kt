package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                BusinessCardApp()
            }
        }
    }
}

@Composable
fun BusinessCardApp(modifier: Modifier = Modifier) {
    val androidIcon = painterResource(R.drawable.android_logo)
    Column(modifier = modifier
        .fillMaxSize()
        .background(Color(0xFFD6E7D5)),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier
                    .background(Color(0xFF142f40))
                    .padding(vertical = 12.dp, horizontal = 4.dp)
                    .widthIn(max = 100.dp),
                painter = androidIcon,
                contentDescription = "Android Icon",
            )
            Text(
                text = stringResource(R.string.name),
                fontSize = 36.sp
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Associate Software Engineer",
                color = Color(0xFF347045),
                fontWeight = FontWeight.Bold
            )
        }
        Column(
            modifier = Modifier
                .padding(horizontal = 42.dp)
                .padding(bottom = 20.dp)
        ) {
            ListItem(
                leadingContent = {
                    Icon(imageVector = Icons.Filled.Call, contentDescription = null)
                },
                headlineContent = { Text(text = "+1 (801) 361 7770") },
                colors = ListItemDefaults.colors(containerColor = Color.Transparent)
            )
            ListItem(
                leadingContent = {
                    Icon(imageVector = Icons.Filled.Share, contentDescription = null)
                },
                headlineContent = { Text(text = "@AndroidDev") },
                colors = ListItemDefaults.colors(containerColor = Color.Transparent)
            )
            ListItem(
                leadingContent = {
                    Icon(imageVector = Icons.Filled.Email, contentDescription = null)
                },
                headlineContent = { Text(text = "jordan.fraughton@gmail.com") },
                colors = ListItemDefaults.colors(containerColor = Color.Transparent)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCardApp()
    }
}