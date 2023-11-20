package com.mark.petfinderexpert.presentation.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.mark.petfinderexpert.R
import com.mark.petfinderexpert.data.remote.models.pets.Animal


@Composable
fun SinglePetItem(
    animal: Animal, onItemClick: (Animal) -> Unit
) {
    Card(modifier = Modifier
        .clickable { onItemClick(animal) }
        .padding(vertical = 16.dp, horizontal = 16.dp)
        .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            colorResource(id = R.color.card_background), Color.White, Color.Black, Color.Black
        )) {
        Row {
            var model = animal.photos.firstOrNull()?.small
            if (model.isNullOrEmpty()){
                model="https://upload.wikimedia.org/wikipedia/commons/b/b2/Petfinder_logo.png"
            }
            AsyncImage(
                model = model,
                "Animal Image",
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
                    .padding(8.dp),
                placeholder = painterResource(
                    R.mipmap.ic_launcher_foreground
                )
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Row {
                    Text(
                        text = stringResource(id = R.string.pet_name),
                        fontWeight = FontWeight.Light,
                        fontSize = 20.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = animal.name,
                        fontWeight = FontWeight.Normal,
                        fontSize = 20.sp,
                        color = Color.White,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row {
                    Text(
                        text = stringResource(id = R.string.pet_gender),
                        fontWeight = FontWeight.Light,
                        fontSize = 20.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = animal.gender,
                        fontWeight = FontWeight.Normal,
                        fontSize = 20.sp,
                        color = Color.White,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))

                Row {
                    Text(
                        text = stringResource(id = R.string.pet_type),
                        fontWeight = FontWeight.Light,
                        fontSize = 20.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = animal.type,
                        fontWeight = FontWeight.Normal,
                        fontSize = 20.sp,
                        color = Color.White,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }

        }
        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Preview
@Composable
fun PreviewPetItemCard() {
}


