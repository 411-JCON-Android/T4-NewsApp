package com.example.t4newsapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.t4newsapp.R

data class GridNews(val imageResId: Int, val title: String)

@Composable
fun AroundTheWorldGrid() {
    val gridItems = listOf(
        GridNews(R.drawable.peru, "Empieza la tercera guerra mundial, Perú inicia conflicto"),
        GridNews(R.drawable.pez, "Un pescado resulta elegido nuevo gobernador de Campeche"),
        GridNews(R.drawable.mono, "Chimpancé inventa una nueva alternativa a la rueda"),
        GridNews(R.drawable.griegos, "La espectacular historia de los griegos según la IA")
    )

    Column(modifier = Modifier.fillMaxSize()) {

        Text(
            text = "Alrededor del mundo",
            fontSize = 24.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color.Black,
            modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp)
        )

        // grid
        LazyVerticalGrid(
            columns = GridCells.Fixed(2), // 2 columnas
            contentPadding = PaddingValues(horizontal = 24.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(gridItems) { item ->
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(20.dp))
                        .background(Color(0xFFD4D4D4))
                        .height(210.dp)
                ) {
                    Image(
                        painter = painterResource(id = item.imageResId),
                        contentDescription = item.title,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(110.dp)
                    )

                    Text(
                        text = item.title,
                        color = Color.Black,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        lineHeight = 18.sp,
                        modifier = Modifier.padding(12.dp)
                    )
                }
            }
        }
    }
}