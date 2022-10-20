package ru.rtulab.smarthostel.presentation.ui.booking

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import ru.rtulab.smarthostel.R
import ru.rtulab.smarthostel.presentation.ui.common.AppBarTabRow
import ru.rtulab.smarthostel.presentation.ui.common.ObjectCard
import ru.rtulab.smarthostel.ui.theme.Accent
import ru.rtulab.smarthostel.ui.theme.White

@OptIn(ExperimentalPagerApi::class)
@Preview
@Composable
fun Booking(){
    val pagerState = rememberPagerState()
    val arrayString = listOf("First","Second","Third")

    val tabs = listOf(
        stringResource(R.string.Active),
        stringResource(R.string.Ended)
    )
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier
                    .padding(16.dp),
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(8.dp),
                backgroundColor = Accent,
                contentColor = White,
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = stringResource(R.string.Add) )

            }
        }
    ) {

    Column() {

        Surface(
            color = MaterialTheme.colors.primarySurface,
            contentColor = contentColorFor(MaterialTheme.colors.primarySurface),
            elevation = AppBarDefaults.TopAppBarElevation
        ) {
            AppBarTabRow(

                pagerState = pagerState,
                tabs = tabs,
                modifier = Modifier
                    .fillMaxWidth(),
                isScrollable = true
            )
        }




        HorizontalPager(
            count = arrayString.size,
            state = pagerState

        ) { currentPage ->
            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
            ) {



                val arrayobject = listOf<Nothing>()
                LazyColumn() {
                    items(arrayobject.size) {
                        ObjectCard()
                    }
                }
            }

        }
    }
    }

}