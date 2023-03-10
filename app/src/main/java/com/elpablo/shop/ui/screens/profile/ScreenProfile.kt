package com.elpablo.shop.ui.screens.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.elpablo.shop.R
import com.elpablo.shop.ui.navigation.Screen
import com.elpablo.shop.ui.theme.AppTheme

@Composable
fun ScreenProfile(navController: NavController, modifier: Modifier) {

    Column(modifier = modifier.fillMaxSize()) {
        TopAppBar(
            modifier = Modifier.fillMaxWidth(),
            title = stringResource(id = R.string.screen_profile_title_text),
            navigationAction = {
                IconButton(
                    onClick = { navController.popBackStack() }
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = stringResource(id = R.string.screen_profile_button_back_description),
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        )

        Column(
            modifier = Modifier.padding(horizontal = 43.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            AsyncImage(
                model = R.drawable.profile,
                contentDescription = stringResource(id = R.string.screen_profile_image_user_description),
                modifier = Modifier
                    .size(61.dp)
                    .clip(CircleShape)
            )

            Text(
                text = stringResource(id = R.string.screen_profile_button_change_user_photo_text),
                modifier = Modifier
                    .padding(top = 6.dp)
                    .clickable { /* TODO */ },
                color = AppTheme.color.secondaryTextColor,
                style = AppTheme.typography.profileHintText
            )

            Text(
                text = "Satria Adhi Pradana",
                Modifier.padding(top = 17.dp),
                style = AppTheme.typography.profileTitleText
            )

            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 36.dp),
                shape = AppTheme.shape.authButtonShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = AppTheme.color.buttonBackground,
                    contentColor = AppTheme.color.textButtonColor
                )
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.upload),
                        contentDescription = stringResource(id = R.string.screen_profile_button_upload_item_text),
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                            .padding(start = 42.dp)
                    )
                    Text(
                        text = stringResource(id = R.string.screen_profile_button_upload_item_text),
                        textAlign = TextAlign.Center,
                        style = AppTheme.typography.authButtonText
                    )
                }
            }

            MenuItem(
                modifier = Modifier.padding(top = 14.dp),
                icon = painterResource(id = R.drawable.card),
                text = stringResource(id = R.string.screen_profile_menu_item_trade_store_text),
                button = {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = null
                    )
                }
            )

            MenuItem(
                modifier = Modifier.padding(top = 14.dp),
                icon = painterResource(id = R.drawable.card),
                text = stringResource(id = R.string.screen_profile_menu_item_payment_method_text),
                button = {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = null
                    )
                }
            )

            MenuItem(
                modifier = Modifier.padding(top = 14.dp),
                icon = painterResource(id = R.drawable.card),
                text = stringResource(id = R.string.screen_profile_menu_item_balance_text),
                button = { Text(text = "$ 1593") }

            )

            MenuItem(
                modifier = Modifier.padding(top = 14.dp),
                icon = painterResource(id = R.drawable.card),
                text = stringResource(id = R.string.screen_profile_menu_item_trade_history_text),
                button = {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = null
                    )
                }
            )

            MenuItem(
                modifier = Modifier.padding(top = 14.dp),
                icon = painterResource(id = R.drawable.restore),
                text = stringResource(id = R.string.screen_profile_menu_item_restore_purchase_text),
                button = {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = null
                    )
                }
            )

            MenuItem(
                modifier = Modifier.padding(top = 14.dp),
                icon = painterResource(id = R.drawable.help),
                text = stringResource(id = R.string.screen_profile_menu_item_help_text),
                button = {

                }
            )

            MenuItem(
                modifier = Modifier
                    .padding(top = 14.dp)
                    .clickable {
                        navController.navigate(Screen.SignIn.route) {
                            popUpTo(Screen.SignIn.route) {
                                inclusive = true
                            }
                        }
                    },
                icon = painterResource(id = R.drawable.logout),
                text = stringResource(id = R.string.screen_profile_menu_item_logout_text),
                button = {

                }
            )
        }
    }
}

@Preview
@Composable
fun ProfilePreview() {
    ScreenProfile(navController = rememberNavController(), modifier = Modifier)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(modifier: Modifier, title: String, navigationAction: @Composable () -> Unit) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = AppTheme.typography.profileTitleText
            )
        },
        modifier = modifier,
        navigationIcon = navigationAction
    )
}

@Composable
fun MenuItem(modifier: Modifier, icon: Painter, text: String, button: @Composable () -> Unit) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(40.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(AppTheme.color.secondaryBackground),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = icon,
                contentDescription = null
            )
        }
        Text(
            text = text,
            modifier = Modifier.padding(start = 6.dp),
            textAlign = TextAlign.Center,
            style = AppTheme.typography.profileMenuItemText
        )
        Spacer(modifier = Modifier.weight(1f))
        button()
    }
}