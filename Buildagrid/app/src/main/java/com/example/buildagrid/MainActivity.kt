package com.example.buildagrid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Grain
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.buildagrid.data.DataSource
import com.example.buildagrid.model.Topic
import com.example.buildagrid.ui.theme.BuildAGridTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BuildAGridTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .statusBarsPadding(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TopicGrid(
                        modifier = Modifier.padding(
                            start = 8.dp,
                            top = 8.dp,
                            end = 8.dp,
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun TopicGrid(modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        items(DataSource.topics) { topic ->
            TopicGridItem(
                topic = topic
            )
        }
    }
}

@Composable
fun TopicGridItem(
    modifier: Modifier = Modifier,
    topic: Topic
) {
    Card {
        Row {
            Image(
                modifier = modifier
                    .size(68.dp)
                    .aspectRatio(1f),
                painter = painterResource(topic.imageSourcesId),
                contentDescription = stringResource(topic.nameID)
            )
            Column(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .padding(horizontal = 16.dp)
            ) {
                Text(
                    modifier = Modifier.padding(bottom = 8.dp),
                    style = MaterialTheme.typography.bodyMedium,
                    text = stringResource(topic.nameID)
                )
                Row {
                    Icon(
                        imageVector = Icons.Filled.Grain,
                        contentDescription = null
                    )
                    Text(
                        modifier = Modifier.padding(start = 8.dp),
                        text = topic.number.toString()
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TopicGridItemPreview() {
    BuildAGridTheme {
        TopicGrid()
    }
}