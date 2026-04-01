package com.itainformatica.components.pages

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.itainformatica.InstitutionalPage
import com.itainformatica.LocationPage
import com.itainformatica.MainActivity
import com.itainformatica.R
import com.itainformatica.components.navbar.NavBar
import com.itainformatica.components.navbar.NavItem
import com.itainformatica.controllers.NavController
import com.itainformatica.controllers.Screen
import com.itainformatica.ui.theme.*

@SuppressLint("ConfigurationScreenWidthHeight")

@Composable
fun MainPage(
    modifier: Modifier = Modifier,
    padding: PaddingValues = PaddingValues(horizontal = 24.dp),
    bottomBar: @Composable () -> Unit = {
        NavBar(
            color = Primary,
            navItems = listOf(
                NavItem(
                    icon = painterResource(id = R.drawable.bag),
                    iconColor = DarkBlue,
                    onTap = {
                        NavController.setNavState(Screen.HOME)
                    }),
                NavItem(
                    icon = painterResource(id = R.drawable.compass),
                    iconColor = DarkBlue,
                    onTap = {
                        NavController.setNavState(Screen.LOCATION)
                    }),
                NavItem(
                    icon = painterResource(id = R.drawable.processor),
                    iconColor = DarkBlue,
                    onTap = {
                        NavController.setNavState(Screen.INSTITUTIONAL)
                    })
            )
        )
    },
    content: @Composable () -> Unit,
) {
    val baseSize = LocalConfiguration.current.screenWidthDp.dp * 0.01f

    Scaffold (
        modifier = modifier
            .fillMaxSize(),
        containerColor = Color.White,
        bottomBar = bottomBar
    ){ innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = innerPadding.calculateTopPadding() + (baseSize * 8f),
                    end = padding.calculateEndPadding(LayoutDirection.Ltr) + (baseSize * 5f),
                    start = padding.calculateStartPadding(LayoutDirection.Ltr) + (baseSize * 5f),
                    bottom = innerPadding.calculateBottomPadding()
                ),
            verticalArrangement = Arrangement.spacedBy(baseSize * 5)
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_welder),
                contentDescription = "Logo",
                modifier = Modifier
                    .size(width = 111.dp, height = 30.dp)
            )
            Spacer(modifier = Modifier.height((2.5f).dp))
            content()

        }
    }
}