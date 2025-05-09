package com.promact.tablayout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TabRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * A customizable tab row that can be used in any Android project
 *
 * @param selectedTabPage The currently selected tab page
 * @param onTabSelected Callback to be invoked when a tab is selected
 * @param tabs List of tab titles
 * @param backgroundColor Background color of the tab row
 * @param indicatorColor Color of the selected tab indicator
 * @param textColor Color of the unselected tab text
 * @param selectedTextColor Color of the selected tab text
 * @param tabCornerShape Corner shape for the tab row container
 * @param indicatorCornerShape Corner shape for the tab indicator
 * @param segmentedStyle Whether to use segmented control style where indicator fills the entire tab
 * @param modifier Optional modifier for the tab row
 */
@Composable
fun <T : TabPage> CustomTabRow(
    selectedTabPage: T,
    onTabSelected: (T) -> Unit,
    tabs: List<T>,
    backgroundColor: Color = TabLayoutColors.TabBackgroundColor,
    indicatorColor: Color = TabLayoutColors.SelectedTabIndicatorColor,
    textColor: Color = TabLayoutColors.TabTextColor,
    selectedTextColor: Color = TabLayoutColors.SelectedTabTextColor,
    tabCornerShape: RoundedCornerShape = RoundedCornerShape(20.dp),
    indicatorCornerShape: RoundedCornerShape = RoundedCornerShape(4.dp),
    segmentedStyle: Boolean = false,
    modifier: Modifier = Modifier
) {
    TabRow(
        selectedTabIndex = selectedTabPage.tabIndex,
        backgroundColor = backgroundColor,
        modifier = modifier
            .clip(tabCornerShape)
            .padding(horizontal = 4.dp, vertical = 4.dp),
        indicator = { tabPositions ->
            TabIndicator(
                tabPositions = tabPositions,
                tabPage = selectedTabPage,
                indicatorColor = indicatorColor,
                indicatorCornerShape = indicatorCornerShape,
                segmentedStyle = segmentedStyle
            )
        }
    ) {
        tabs.forEach { tab ->
            val tabTitle = tab.toString()
            val isSelected = selectedTabPage.tabIndex == tab.tabIndex

            TabItem(
                title = tabTitle,
                onClick = { onTabSelected(tab) },
                isSelected = isSelected,
                textColor = textColor,
                selectedTextColor = selectedTextColor
            )
        }
    }
}

/**
 * A customizable tab row that can be used in any Android project with string tab titles
 *
 * @param selectedTabIndex The currently selected tab index
 * @param onTabSelected Callback to be invoked when a tab is selected with the index
 * @param tabTitles List of tab titles
 * @param backgroundColor Background color of the tab row
 * @param indicatorColor Color of the selected tab indicator
 * @param textColor Color of the unselected tab text
 * @param selectedTextColor Color of the selected tab text
 * @param tabCornerShape Corner shape for the tab row container
 * @param indicatorCornerShape Corner shape for the tab indicator
 * @param segmentedStyle Whether to use segmented control style where indicator fills the entire tab
 * @param modifier Optional modifier for the tab row
 */
@Composable
fun CustomTabRowWithTitles(
    selectedTabIndex: Int,
    onTabSelected: (Int) -> Unit,
    tabTitles: List<String>,
    backgroundColor: Color = TabLayoutColors.TabBackgroundColor,
    indicatorColor: Color = TabLayoutColors.SelectedTabIndicatorColor,
    textColor: Color = TabLayoutColors.TabTextColor,
    selectedTextColor: Color = TabLayoutColors.SelectedTabTextColor,
    tabCornerShape: RoundedCornerShape = RoundedCornerShape(20.dp),
    indicatorCornerShape: RoundedCornerShape = RoundedCornerShape(4.dp),
    segmentedStyle: Boolean = false,
    modifier: Modifier = Modifier
) {
    // Create dummy tab pages
    val tabPages = tabTitles.mapIndexed { index, _ ->
        object : TabPage {
            override val tabIndex: Int = index
            override fun toString(): String = tabTitles[index]
        }
    }
    
    CustomTabRow(
        selectedTabPage = tabPages[selectedTabIndex],
        onTabSelected = { onTabSelected(it.tabIndex) },
        tabs = tabPages,
        backgroundColor = backgroundColor,
        indicatorColor = indicatorColor,
        textColor = textColor,
        selectedTextColor = selectedTextColor,
        tabCornerShape = tabCornerShape,
        indicatorCornerShape = indicatorCornerShape,
        segmentedStyle = segmentedStyle,
        modifier = modifier
    )
} 