package com.example.book.presentation.HomeScreen

import android.graphics.drawable.Icon
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BugReport
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Paid
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.book.R
import com.example.book.presentation.TabScreen.TabScreen
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    val coroutineScope = rememberCoroutineScope()

    val conetent = LocalContext.current

    val uriHandler = LocalUriHandler.current

    val scrollBahavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())


    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = true,
        drawerContent = {
            ModalDrawerSheet {

                Column(
                    modifier
                        .fillMaxHeight()
                        .width(250.dp)
                        .padding(16.dp)
                )
                {


                    Divider()

                    NavigationDrawerItem(
                        label = { Text("Home") },
                        icon = { Icon(imageVector = Icons.Filled.Home, "") },
                        selected = true,
                        onClick = {
                            coroutineScope.launch {
                                drawerState.close()
                            }
                        }
                    )

                    Divider()

                    NavigationDrawerItem(
                        label = { Text("Version 1:0") },
                        selected = false,
                        icon = { Icon(imageVector = Icons.Filled.Info, "") },
                        onClick = {

                            coroutineScope.launch {
                                drawerState.close()
                            }

                            Toast.makeText(conetent, "Version 1:0", Toast.LENGTH_SHORT).show()

                        }
                    )

                    Divider()

                    NavigationDrawerItem(
                        label = { Text("Contact me") },
                        selected = false,
                        icon = { Icon(painter = painterResource(R.drawable.github), "",
                            modifier = Modifier.size(20.dp)) },
                        onClick = {

                            coroutineScope.launch {
                                drawerState.close()
                            }

                            uriHandler.openUri("https://github.com/AndroidWithJoyonta")

                            Toast.makeText(conetent, "Contact me", Toast.LENGTH_SHORT).show()

                        }
                    )


                    NavigationDrawerItem(
                        label = { Text("Bug Report") },
                        selected = false,
                        icon = { Icon(imageVector = Icons.Filled.BugReport, "") },
                        onClick = {
                            uriHandler.openUri("https://alvo.chat/6lXK")
                            coroutineScope.launch {
                                drawerState.close()
                            }

                            Toast.makeText(conetent, "Bug Report", Toast.LENGTH_SHORT).show()

                        }
                    )


                }
            }
        }
    ) {
        Scaffold(modifier
            .fillMaxSize()
            .nestedScroll(scrollBahavior.nestedScrollConnection),
            topBar = {
                TopAppBar(title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {

                        Spacer(modifier.width(8.dp))

                        Text(
                            "Book Library",
                            maxLines = 1,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }, navigationIcon = {


                    IconButton(onClick = {
                        coroutineScope.launch {
                            drawerState.open()
                        }
                    }) {
                        Icon(imageVector = Icons.Filled.Menu, "")
                    }
                }, scrollBehavior = scrollBahavior)
            }) {

            Column(modifier.padding(it)) {

                TabScreen()

            }


        }


    }
}