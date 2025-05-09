package com.promact.tablayout

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.TabPosition
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex

/**
 * Composable function for a custom animated tab indicator
 *
 * @param tabPositions List of tab positions in the tab row
 * @param tabPage Current selected tab page
 * @param indicatorColor Color of the tab indicator
 * @param indicatorCornerShape Corner shape for the tab indicator
 * @param segmentedStyle Whether to use segmented control style where indicator fills the entire tab
 */
@Composable
fun TabIndicator(
    tabPositions: List<TabPosition>,
    tabPage: TabPage,
    indicatorColor: Color = TabLayoutColors.SelectedTabIndicatorColor,
    indicatorCornerShape: RoundedCornerShape = RoundedCornerShape(4.dp),
    segmentedStyle: Boolean = false
) {
    // Create a transition that animates between tab positions
    val transition = updateTransition(targetState = tabPage, label = "Tab Indicator")

    // Animate the left edge of the indicator
    val indicatorLeft by transition.animateDp(
        transitionSpec = {
            spring(stiffness = Spring.StiffnessMedium)
        },
        label = "Indicator left"
    ) { page ->
        tabPositions[page.tabIndex].left
    }

    // Animate the right edge of the indicator
    val indicatorRight by transition.animateDp(
        transitionSpec = {
            spring(stiffness = Spring.StiffnessMedium)
        },
        label = "Indicator right"
    ) { page ->
        tabPositions[page.tabIndex].right
    }

    if (segmentedStyle) {
        // Draw the indicator as a full tab background for segmented control style
        Box(
            Modifier
                .wrapContentSize(align = Alignment.BottomStart)
                .offset(x = indicatorLeft)
                .width(indicatorRight - indicatorLeft)
                .height(40.dp) // Fixed height for the tab
                .padding(horizontal = 2.dp, vertical = 2.dp)
                .background(indicatorColor, indicatorCornerShape)
                .zIndex(1f)
        )
    } else {
        // Draw the indicator as a bottom bar (original style)
        Box(
            Modifier
                .fillMaxSize()
                .wrapContentSize(align = Alignment.BottomStart)
                .offset(x = indicatorLeft)
                .width(indicatorRight - indicatorLeft)
                .padding(4.dp)
                .fillMaxSize()
                .background(indicatorColor, indicatorCornerShape)
                .border(
                    BorderStroke(1.dp, indicatorColor),
                    indicatorCornerShape
                )
                .zIndex(1f)
        )
    }
} 