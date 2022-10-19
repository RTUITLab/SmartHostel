package ru.rtulab.smarthostel.presentation.ui.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import coil.compose.AsyncImage
import coil.request.ImageRequest
import ru.rtulab.smarthostel.R
import ru.rtulab.smarthostel.ui.theme.Accent50


@Preview
@Composable
fun ImageDownloadCard(
    modifier:Modifier = Modifier,
    imageLink: String ="https://example.com/image.jpg"
    ){
    val imageSize = remember{ mutableStateOf(Size.Zero)}
    Box(
        modifier = modifier
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageLink)
                .crossfade(true)
                .build(),
            placeholder = painterResource(R.drawable.placeholderimage),
            contentDescription = stringResource(R.string.image),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
                .clip(RoundedCornerShape(8.dp))
                .onGloballyPositioned {
                    imageSize.value = it.size.toSize()
                },
        )
        Column(
            modifier = Modifier
                .size(with(LocalDensity.current) { imageSize.value.toDpSize() }),
            verticalArrangement = Arrangement.Bottom
        ) {

            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxSize(),
                elevation = 0.dp,
                backgroundColor = Accent50,
                shape = RoundedCornerShape(8.dp)

            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .weight(0.5f, false)
                    ) {
                        Text(
                            text = stringResource(R.string.texttodownload),
                            color = MaterialTheme.colors.onPrimary
                        )
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .weight(0.5f, false)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.download),
                            contentDescription = stringResource(R.string.download)
                        )
                    }
                }
            }
        }
    }


}