package com.jpdev.yummyconnect.presentation.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jpdev.yummyconnect.R

@Composable
fun CreateReceiptScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            item{
                Text(
                    text = "Create Recipe",
                    style = TextStyle(fontWeight = FontWeight.Medium, fontSize = 34.sp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                AddPhotoCard()
            }
            item {
                Spacer(modifier = Modifier.height(16.dp))
                AddRecipeForm()
            }
        }
    }
}

@Composable
fun AddRecipeForm() {
    Column(Modifier.fillMaxWidth()) {
        Text("Recipe Title")
        ElementForm(label="E.G. Creamy Garlic Pasta")
        Text("Description")
        ElementForm(label="E.G. Creamy Garlic Pasta")
        Text("Recipe Title")
        ElementForm(label="E.G. Creamy Garlic Pasta")
        Text("Recipe Title")
        ElementForm(label="E.G. Creamy Garlic Pasta")
        Text("Recipe Title")
        ElementForm(label="E.G. Creamy Garlic Pasta")
        Text("Recipe Title")
        ElementForm(label="E.G. Creamy Garlic Pasta")
        Text("Recipe Title")
        ElementForm(label="E.G. Creamy Garlic Pasta")
        Text("Recipe Title")
        ElementForm(label="E.G. Creamy Garlic Pasta")
        Text("Recipe Title")
        ElementForm(label="E.G. Creamy Garlic Pasta")
        Text("Recipe Title")
        ElementForm(label="E.G. Creamy Garlic Pasta")
        Text("Recipe Title")
        ElementForm(label="E.G. Creamy Garlic Pasta")
    }
}

@Composable
fun ElementForm(label: String) {
    OutlinedTextField(
        value = "",
        onValueChange = {},
        label = { Text(label) },
        modifier = Modifier.fillMaxWidth()
    )
}


@Composable
fun AddPhotoCard() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {

        Canvas(modifier = Modifier.matchParentSize()) {
            val stroke = Stroke(
                width = 8f,
                pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
            )

            drawRoundRect(
                color = Color.Gray,
                size = size,
                cornerRadius = CornerRadius(25f, 25f),
                style = stroke
            )
        }

        Card(
            modifier = Modifier.fillMaxSize(),
            shape = RoundedCornerShape(12.dp),
            elevation = CardDefaults.cardElevation(4.dp),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_add_photo),
                    contentDescription = "Add photo",
                    tint = Color.Gray,
                    modifier = Modifier.size(50.dp)
                )
                Text(
                    text = "Add Cover Photo",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.Gray
                )
            }
        }

    }
}