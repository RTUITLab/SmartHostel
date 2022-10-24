package ru.rtulab.smarthostel.presentation.ui.booking

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import ru.rtulab.smarthostel.R
import ru.rtulab.smarthostel.data.remote.api.objects.ObjectWithDate
import ru.rtulab.smarthostel.presentation.navigation.AppScreen
import ru.rtulab.smarthostel.presentation.navigation.LocalNavController
import ru.rtulab.smarthostel.presentation.ui.common.AppBarTabRow
import ru.rtulab.smarthostel.presentation.ui.common.LoadingIndicator
import ru.rtulab.smarthostel.presentation.ui.common.ObjectCard
import ru.rtulab.smarthostel.presentation.ui.common.ObjectCardWithDate
import ru.rtulab.smarthostel.presentation.ui.objects.ObjectViewModel
import ru.rtulab.smarthostel.presentation.viewmodel.singletonViewModel
import ru.rtulab.smarthostel.ui.theme.Accent
import ru.rtulab.smarthostel.ui.theme.Green
import ru.rtulab.smarthostel.ui.theme.White

@OptIn(ExperimentalPagerApi::class)
@Preview
@Composable
fun Booking(
    bookingViewModel: BookingViewModel = singletonViewModel(),
    objectViewModel: ObjectViewModel = singletonViewModel()
){
    val bookingsDto = bookingViewModel.bookingsResourceFlow.collectAsState().value
    val objectsDto = objectViewModel.objectsResourceFlow.collectAsState().value
    val typesDto = objectViewModel.objectTypesResourceFlow.collectAsState().value

    val navController = LocalNavController.current

    val booking = bookingViewModel.bookingsFlow.collectAsState().value

    val pagerState = rememberPagerState()
    var isRefreshing by remember { mutableStateOf(false) }


    val tabs = listOf(
        stringResource(R.string.Active),
        stringResource(R.string.Ended),

    )
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier
                    .padding(16.dp),
                onClick = {
                    navController.navigate("${AppScreen.BookingCreate.navLink}")

                },
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
            count = tabs.size,
            state = pagerState

        ) { currentPage ->
            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
            ) {


                bookingsDto.handle(
                onLoading = {
                    LoadingIndicator()
                },
                onError = { msg ->
                    Text(text = msg)
                },
                onSuccess = { Dto ->
                    objectsDto.handle(
                        onLoading = {
                            LoadingIndicator()
                        },
                        onError = { msg ->
                            Text(text = msg)
                        },
                        onSuccess = { obj ->
                            typesDto.handle(
                                onLoading = {
                                    LoadingIndicator()
                                },
                                onError = { msg ->
                                    Text(text = msg)
                                },
                                onSuccess = { type ->
                                    bookingViewModel.onResourceSuccess(Dto, obj, type)
                                    SwipeRefresh(
                                        modifier = Modifier.fillMaxSize(),
                                        state = rememberSwipeRefreshState(isRefreshing),
                                        onRefresh = {
                                            bookingViewModel.onRefresh()
                                        }
                                    ) {
                                        when (tabs[currentPage]) {
                                            stringResource(R.string.Active) -> {
                                                LazyColumn() {
                                                    items(booking) { b ->
                                                        ObjectCardWithDate(
                                                            name = b.name,
                                                            status = b.status,
                                                            type = b.type,
                                                            room = b.room,
                                                            startTime = b.startTime,
                                                            endTime = b.endTime,
                                                            statusColor = Green
                                                        )
                                                    }
                                                }
                                            }
                                            stringResource(R.string.Ended) -> {
                                                LazyColumn() {
                                                    items(booking) { b ->
                                                        ObjectCardWithDate(
                                                            name = b.name,
                                                            status = b.status,
                                                            type = b.type,
                                                            room = b.room,
                                                            startTime = b.startTime,
                                                            endTime = b.endTime,
                                                            statusColor = Green
                                                        )
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }

)
                        }
                    )
                })
            }

        }
    }
    }

}