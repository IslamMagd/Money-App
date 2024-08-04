package com.example.moneyapp.ui.commonUi

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun StepProgressBar(
    isFirstStepActive: Boolean,
    isSecondStepActive: Boolean,
    isThirdStepActive: Boolean,
    isFirstDeviderActive: Boolean,
    isSecondDeviderActive: Boolean
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            StepWithLabel(isActive = isFirstStepActive, stepNumber = "01", label = "Amount")
            StepDivider(isActive = isFirstDeviderActive)
            StepWithLabel(isActive = isSecondStepActive, stepNumber = "02", label = "Confirmation")
            StepDivider(isActive = isSecondDeviderActive)
            StepWithLabel(isActive = isThirdStepActive, stepNumber = "03", label = "Payment")
        }
    }
}

@Composable
private fun StepWithLabel(isActive: Boolean, stepNumber: String, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        StepCircle(isActive = isActive, stepNumber = stepNumber)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = label, fontSize = 12.sp,fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
    }
}

@Composable
fun StepCircle(isActive: Boolean, stepNumber: String) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(32.dp)
            .border(
                2.dp,
                if (isActive) Color(0xFFB00020) else Color.Gray.copy(alpha = 0.3f),
                CircleShape
            )
            .background(
                if (isActive) Color(0xFFB00020) else Color.Gray.copy(alpha = 0.3f),
                CircleShape
            )
    ) {
        Text(
            text = stepNumber,
            color = Color.White,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
@Composable
fun StepDivider(isActive: Boolean) {
    HorizontalDivider(
        modifier = Modifier
            .width(64.dp)
            .height(2.dp)
            .background(
                if (isActive) Color(0xFFB00020) else Color.Gray.copy(alpha = 0.3f)
            )
    )
}