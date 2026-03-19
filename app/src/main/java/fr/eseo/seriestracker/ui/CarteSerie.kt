package fr.eseo.seriestracker.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import fr.eseo.seriestracker.model.TvShow

@Composable
fun CarteSerie(tvShow: TvShow) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Miniature chargée avec Coil
            AsyncImage(
                model = tvShow.imageUrl,
                contentDescription = "Image de ${tvShow.name}",
                modifier = Modifier
                    .size(100.dp, 140.dp)
                    .padding(end = 16.dp),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                // Titre
                Text(
                    text = tvShow.name,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(4.dp))

                // Chaîne et pays
                Text(
                    text = "${tvShow.network} - ${tvShow.country}",
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.height(8.dp))

                // Badge coloré pour le statut
                val statusColor = if (tvShow.status == "Running") Color(0xFF4CAF50) else Color.Gray
                Box(
                    modifier = Modifier
                        .background(color = statusColor, shape = RoundedCornerShape(12.dp))
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = tvShow.status,
                        color = Color.White,
                        style = MaterialTheme.typography.labelSmall
                    )
                }
            }
        }
    }
}
