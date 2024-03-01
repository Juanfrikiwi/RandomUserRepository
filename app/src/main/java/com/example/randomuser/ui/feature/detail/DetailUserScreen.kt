package com.example.randomuser.ui.feature.detail

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import coil.request.ImageRequest
import coil.size.Scale
import com.example.randomuser.R
import com.example.randomuser.data.models.Results
import com.example.randomuser.ui.components.ImageDialog
import com.example.randomuser.ui.components.ItemUserDetail
import com.example.randomuser.ui.components.TopBars
import com.example.randomuser.utils.DateFormatUtils
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.CameraPositionState
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.rememberMarkerState
import com.example.randomuser.ui.components.MyLoader

@Composable
fun DetailUserScreen(
    context: Context,
    navHostController: NavHostController,
    callbackIsDetailTheme: (Boolean) -> Unit,
) {
    callbackIsDetailTheme(true)
    val userData =
        navHostController.previousBackStackEntry?.savedStateHandle?.get<Results?>("userData")
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            painter = painterResource(R.drawable.detail_topbar_background),
            contentDescription = "",
            contentScale = ContentScale.Crop
        )
    }
    var nameUser = ""
    if (userData?.name?.first != null && userData?.name?.last != null) {
        nameUser = userData?.name?.first.toString() + " " + userData?.name?.last.toString()
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        containerColor = Color.Transparent,
        topBar = {
            if (nameUser != "") {
                TopBars().DetailUserTopBar(nameUser, navHostController)
            }
        }
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(contentPadding),
        ) {
            userData?.let { DetailUserScreenContent(context = context, userData = it) }
        }
    }
}


@Composable
fun DetailUserScreenContent(context: Context, userData: Results) {
    val isShowImageDialog = remember {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp)
    ) {
        Row {
            Box(modifier = Modifier.padding(top = 55.dp)) {
                Row {
                    Card(
                        modifier = Modifier
                            .clip(RoundedCornerShape(100))
                            .size(85.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White
                        )
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            SubcomposeAsyncImage(
                                model =
                                ImageRequest.Builder(context)
                                    .data(userData.picture?.large)
                                    .crossfade(true)
                                    .scale(Scale.FIT)
                                    .build(),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(80.dp)
                                    .clip(RoundedCornerShape(100))
                                    .clickable{
                                       isShowImageDialog.value = true
                                    },

                                ) {
                                val state = painter.state
                                when (state) {
                                    is AsyncImagePainter.State.Loading -> {
                                        MyLoader(60, 3)
                                    }

                                    is AsyncImagePainter.State.Error -> {
                                        SubcomposeAsyncImage(
                                            model = R.drawable.avatar,
                                            contentDescription = ""
                                        ) {
                                            SubcomposeAsyncImageContent()
                                        }
                                    }

                                    else -> {
                                        SubcomposeAsyncImageContent()
                                    }
                                }
                            }
                        }

                    }
                }
                Row {
                    Column() {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 48.dp, end = 12.dp),
                            horizontalArrangement = Arrangement.End,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(modifier = Modifier.padding(end = 24.dp)) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_camera),
                                    contentDescription = "",
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                            Column {
                                Icon(
                                    painter = painterResource(id = R.drawable.edit),
                                    contentDescription = "",
                                    modifier = Modifier.size(32.dp)
                                )
                            }
                        }

                        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                            ItemUserDetail(
                                title = stringResource(R.string.name_and_surname),
                                subtitle = userData?.name?.first.toString() + " " + userData?.name?.last.toString(),
                                icon = R.drawable.profile
                            )
                            ItemUserDetail(
                                title = stringResource(R.string.email),
                                subtitle = userData.email.toString(),
                                icon = R.drawable.mail
                            )

                            if (userData.gender == "male") {
                                ItemUserDetail(
                                    title = stringResource(R.string.gender),
                                    subtitle = stringResource(R.string.man),
                                    icon = R.drawable.male
                                )
                            } else {
                                ItemUserDetail(
                                    title = stringResource(R.string.gender),
                                    subtitle = stringResource(R.string.woman),
                                    icon = R.drawable.female
                                )
                            }
                            if (userData.registered?.date != null) {
                                ItemUserDetail(
                                    title = stringResource(R.string.registration_date),
                                    subtitle = DateFormatUtils().formatDateFromServer(userData.registered?.date.toString()),
                                    icon = R.drawable.ic_calendar
                                )
                            }
                            ItemUserDetail(
                                title = stringResource(R.string.phone),
                                subtitle = userData.phone.toString(),
                                icon = R.drawable.phone
                            )


                            Row(
                                modifier = Modifier
                                    .padding(vertical = 8.dp)
                                    .height(180.dp)
                            ) {
                                Column(
                                    modifier = Modifier
                                        .weight(2f)
                                ) {

                                }
                                Column(
                                    modifier = Modifier
                                        .weight(9f)
                                        .padding(end = 18.dp)
                                ) {
                                    Row(modifier = Modifier.padding(vertical = 6.dp)) {
                                        Text(
                                            text = stringResource(R.string.address),
                                            fontSize = 11.sp,
                                            color = colorResource(id = R.color.gray_dark),
                                        )
                                    }
                                    Row(modifier = Modifier.padding(vertical = 6.dp)) {
                                        val latitude =
                                            userData.location?.coordinates?.latitude?.toDouble()
                                        val longitude =
                                            userData.location?.coordinates?.longitude?.toDouble()
                                        if (latitude != null && longitude != null) {
                                            val location = LatLng(latitude, longitude)
                                            val cameraPositionState: CameraPositionState =
                                                rememberCameraPositionState {
                                                    position =
                                                        CameraPosition.fromLatLngZoom(location, 11f)
                                                }
                                            GoogleMap(
                                                contentPadding = PaddingValues(top = 500.dp),
                                                cameraPositionState = cameraPositionState,
                                                uiSettings =
                                                MapUiSettings(
                                                    zoomControlsEnabled = false
                                                )
                                            ) {
                                                Marker(
                                                    state = rememberMarkerState(position = location),
                                                    icon = BitmapDescriptorFactory.defaultMarker(
                                                        BitmapDescriptorFactory.HUE_AZURE
                                                    )
                                                )
                                            }
                                        }


                                    }

                                }
                            }

                        }
                    }
                }

            }
        }
        if (isShowImageDialog.value){
            ImageDialog(context = context, urlImage = userData?.picture?.large.toString()) {
                isShowImageDialog.value = false
            }
        }

    }
}


