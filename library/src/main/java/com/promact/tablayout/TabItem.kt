package com.promact.tablayout

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex

/**
 * Composable function for a custom tab in a tab row
 *
 * @param title The text to display on the tab
 * @param onClick Callback to be invoked when this tab is selected
 * @param isSelected Whether this tab is currently selected
 * @param textColor Optional color for the tab text (unselected state)
 * @param selectedTextColor Optional color for the tab text (selected state)
 */
@Composable
fun TabItem(
    title: String,
    onClick: () -> Unit,
    isSelected: Boolean,
    textColor: Color = TabLayoutColors.TabTextColor,
    selectedTextColor: Color = TabLayoutColors.SelectedTabTextColor
) {
    // Create a remember for the interaction source
    val interactionSource = remember { MutableInteractionSource() }

    Box(
        modifier = Modifier
            .padding(vertical = 4.dp, horizontal = 8.dp)
            .zIndex(if (isSelected) 2f else 0f)
            .clickable(
                interactionSource = interactionSource,
                indication = null, // This removes the ripple effect
                onClick = onClick
            ),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 12.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = title,
                color = if (isSelected) selectedTextColor else textColor,
                fontWeight = if (isSelected) FontWeight.Medium else FontWeight.Normal,
                fontSize = 14.sp,
                textAlign = TextAlign.Center
            )
        }
    }
} 