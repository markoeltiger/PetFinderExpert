package com.mark.petfinderexpert.presentation.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.mark.petfinderexpert.R
import com.mark.petfinderexpert.data.remote.models.pets.Animal
import com.mark.petfinderexpert.data.remote.models.pets.Type

@Composable
fun SingleTypeItem(
    type: com.mark.petfinderexpert.data.remote.models.pet_types.Type,
    onItemClick: (com.mark.petfinderexpert.data.remote.models.pet_types.Type) -> Unit
) {
    Card(  colors = CardDefaults.cardColors(
        colorResource(id = R.color.card_background), Color.White, Color.Black, Color.Black
    ),
        modifier = Modifier
            .clickable { onItemClick(type)
            }
            .padding(vertical = 8.dp, horizontal = 4.dp)
     ) {
        Text(text = type.name , modifier = Modifier.padding(10.dp))

    }
}
