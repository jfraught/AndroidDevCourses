package com.example.artspace

import android.bluetooth.BluetoothClass.Device
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                ArtSpaceApp()
            }
        }
    }
}

@Composable
fun ArtSpaceApp(modifier: Modifier = Modifier) {
    var result by remember { mutableIntStateOf(1) }
    val imageResource = when (result) {
        1 -> R.drawable.setupone
        2 -> R.drawable.setuptwo
        3 -> R.drawable.setupthree
        4 -> R.drawable.setupfour
        5 -> R.drawable.setupfive
        6 -> R.drawable.setupsix
        7 -> R.drawable.setupseven
        8 -> R.drawable.setupeight
        9 -> R.drawable.setupnine
        10 -> R.drawable.setupten
        11 -> R.drawable.setupeleven
        12 -> R.drawable.setuptwelve
        13 -> R.drawable.setupthirteen
        else -> R.drawable.setupfourteen
    }
    val imageDescription = when (result) {
        1 -> R.string.setup_one
        2 -> R.string.setup_two
        3 -> R.string.setup_three
        4 -> R.string.setup_four
        5 -> R.string.setup_five
        6 -> R.string.setup_six
        7 -> R.string.setup_seven
        8 -> R.string.setup_eight
        9 -> R.string.setup_nine
        10 -> R.string.setup_ten
        11 -> R.string.setup_eleven
        12 -> R.string.setup_twelve
        13 -> R.string.setup_thirteen
        else -> R.string.setup_fourteen
    }
    val imageYear = when (result) {
        1 -> R.string.one_date
        2 -> R.string.two_date
        3 -> R.string.four_date
        5 -> R.string.five_date
        6 -> R.string.six_date
        7 -> R.string.seven_date
        8 -> R.string.eight_date
        9 -> R.string.nine_date
        10 -> R.string.ten_date
        11 -> R.string.eleven_date
        12 -> R.string.twelve_date
        13 -> R.string.thirteen_date
        else -> R.string.fourteen_date
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()
            .padding(vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(modifier = Modifier
            .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Surface(
                modifier = Modifier
                    .padding(32.dp),
                tonalElevation = 4.dp,
                shadowElevation= 4.dp,
                ) {
                Image(
                    modifier = Modifier
                        .padding(16.dp)
                        .clip(RoundedCornerShape(6.dp)),
                    painter = painterResource(imageResource),
                    contentDescription = stringResource(imageDescription),
                    contentScale = ContentScale.FillWidth,
                )
            }
        }
        Surface(
            modifier = Modifier.padding(16.dp),
            tonalElevation = 4.dp,
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Text(
                    text = stringResource(imageDescription)
                )
                Row {
                    Text(
                        text = "Jordan Fraughton",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = stringResource(imageYear),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Light
                    )
                }
            }
        }
        Row(
            modifier = Modifier
                .widthIn(max = 400.dp)
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Button(
                modifier = Modifier.weight(1f),
                onClick = {
                    if (result > 1) {
                        result -= 1
                    }
                },
                enabled = (result > 1)
            ) {
                Text(text = "Previous")
            }
            Button(
                modifier = Modifier.weight(1f),
                onClick = {
                    if (result < 14) {
                        result += 1
                    }
                },
                enabled = (result < 14)
            ) {
                Text(text = "Next")
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun ArtSpaceAppPreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}