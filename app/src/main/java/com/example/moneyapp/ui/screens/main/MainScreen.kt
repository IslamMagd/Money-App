package com.example.moneyapp.ui.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItemDefaults.contentColor
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.moneyapp.navigation.BottomBarRoutes
import com.example.moneyapp.navigation.BottomNavGraph
import com.example.moneyapp.ui.theme.Dark_pink
import com.example.moneyapp.ui.theme.GrayG200
import com.example.moneyapp.ui.theme.Light_pink


@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomBar(navController = navController) }
    ) { _ ->
        BottomNavGraph(navController = navController,Modifier.background(
            brush = Brush.verticalGradient(
                colors = listOf(
                    Color(Light_pink.value), Color(Dark_pink.value)
                )
            )
        ))
    }
}

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarRoutes.Home,
        BottomBarRoutes.Transfer,
        BottomBarRoutes.Transactions,
        BottomBarRoutes.Cards,
        BottomBarRoutes.More
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar {
        contentColor.red
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }
}

@Composable
fun getImageVector( iconRes: Int) : ImageVector{
    return ImageVector.vectorResource(id = iconRes)
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarRoutes,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    NavigationBarItem(
        modifier = Modifier.size(40.dp),
        label = {
            Text(
                text = screen.title,
                color = GrayG200,
                softWrap = false,
                overflow = TextOverflow.Visible
                )
                },
        icon = {
            Icon(
                imageVector = getImageVector(iconRes = screen.iconRes),
                contentDescription = "Navigation Icon",
                tint = GrayG200,
            )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
//        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }

    )
}