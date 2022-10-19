package ru.rtulab.smarthostel.presentation.ui.objects

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import ru.rtulab.smarthostel.R
import ru.rtulab.smarthostel.presentation.ui.common.AppBarTabRow
import ru.rtulab.smarthostel.presentation.ui.common.ObjectCard
import ru.rtulab.smarthostel.presentation.ui.common.SearchView

@OptIn(ExperimentalPagerApi::class)
@Preview
@Composable
fun Objects(){
    val pagerState = rememberPagerState()
    val arrayString = listOf("First","Second","Third")

    val tabs = arrayString
    Column() {

    Surface(
        color = MaterialTheme.colors.primarySurface,
        contentColor = contentColorFor(MaterialTheme.colors.primarySurface),
        elevation = AppBarDefaults.TopAppBarElevation
    ) {
        AppBarTabRow(
            pagerState = pagerState,
            tabs = tabs,
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

                Row(
                    modifier = Modifier
                        .padding(vertical = 24.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.9f),
                        verticalArrangement = Arrangement.Center
                    ) {
                        SearchView(
                            query = TextFieldValue(""),
                            onQueryChange = {},
                            onClearQuery = { /*TODO*/ },
                            searching = false,

                        )
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.1f),
                        verticalArrangement = Arrangement.Center
                    ) {

                        IconButton(
                            modifier = Modifier
                                .height(36.dp)
                                .width(36.dp),
                            onClick = { /*to Filter*/ }
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.filter),
                                contentDescription = stringResource(R.string.filter),
                                modifier = Modifier
                            )
                        }
                    }
                }
                Row(
                    modifier = Modifier
                        .padding(bottom = 16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = arrayString[currentPage],
                        color = MaterialTheme.colors.onBackground,
                        fontSize = 14.sp,
                        lineHeight = 20.sp
                    )
                }
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