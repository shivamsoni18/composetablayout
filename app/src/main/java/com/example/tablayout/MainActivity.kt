package com.example.tablayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.promact.tablayout.CustomTabRow
import com.promact.tablayout.CustomTabRowWithTitles
import com.promact.tablayout.TabPage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    DemoScreen()
                }
            }
        }
    }
}

@Composable
fun DemoScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Tab Layout Library Demo",
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        // Demo 1: Using enum tabs
        Text(
            text = "Demo 1: Using enum tabs",
            fontSize = 18.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        var selectedTab by remember { mutableStateOf(DemoTabs.HOME) }

        CustomTabRow(
            selectedTabPage = selectedTab,
            onTabSelected = { selectedTab = it },
            tabs = DemoTabs.values().toList(),
            tabCornerShape = RoundedCornerShape(20.dp),
            indicatorCornerShape = RoundedCornerShape(4.dp),
            modifier = Modifier.fillMaxWidth()
        )

        TabContent(tab = selectedTab)

        Spacer(modifier = Modifier.height(32.dp))


    }
}

@Composable
fun TabContent(tab: DemoTabs) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(top = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Content for tab: ${tab.name}",
            textAlign = TextAlign.Center,
            fontSize = 18.sp
        )
    }
}

enum class DemoTabs : TabPage {
    HOME,
    PROFILE,
    SETTINGS;

    override val tabIndex: Int
        get() = ordinal
} 