package com.mark.petfinderexpert.presentation.ui.petdetails


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.mark.petfinderexpert.R
import com.mark.petfinderexpert.presentation.viewmodel.petdetails.PetDetailsViewModel
import com.mark.petfinderexpert.utils.helper.AppHelper

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PetDetailsScreen(
    navController: NavController,
    viewModel: PetDetailsViewModel = hiltViewModel()
) {

    val petDetailsUIState by viewModel.petDetails.collectAsState()
    Column(modifier = Modifier
        .padding(8.dp)) {
        TopAppBar(  title = {
            Text(text = stringResource(id = R.string.pet_details))
        },
            navigationIcon = {
                IconButton(onClick = {
                    navController.popBackStack()
                }) {
                    Icon(Icons.Filled.ArrowBack, "backIcon")
                }
            })
        //Load Image of the Anumal
        Card(
            modifier = Modifier
                .padding(vertical = 16.dp, horizontal = 16.dp)
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(
                colorResource(id = R.color.card_background), Color.White, Color.Black, Color.Black
            )
        ) {
            Row {
                var model = AppHelper.selectedPet?.photos?.firstOrNull()?.medium
                if (model.isNullOrEmpty()) {
                    model = "https://upload.wikimedia.org/wikipedia/commons/b/b2/Petfinder_logo.png"
                }
                AsyncImage(
                    model = model,
                    "Animal Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                        .padding(8.dp),
                    placeholder = painterResource(
                        R.mipmap.ic_launcher_foreground
                    )
                )
            }
        }
        Spacer(modifier = Modifier.width(16.dp))
        Row(modifier = Modifier
            .padding(16.dp)) {
            Text(
                text = stringResource(id = R.string.pet_name),
                fontWeight = FontWeight.Light,
                fontSize = 20.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = AppHelper.selectedPet!!.name,
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp,
                color = colorResource(id = R.color.primary_color),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row (modifier = Modifier
            .padding(16.dp)){
            Text(
                text = stringResource(id = R.string.pet_size),
                fontWeight = FontWeight.Light,
                fontSize = 20.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
             Text(
                text = AppHelper.HandleNull(AppHelper.selectedPet!!.size),
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp,
                color = colorResource(id = R.color.primary_color),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(modifier = Modifier
            .padding(16.dp)) {
            Text(
                text = stringResource(id = R.string.pet_primary_color),
                fontWeight = FontWeight.Light,
                fontSize = 20.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = AppHelper.HandleNull(AppHelper.selectedPet?.colors?.primary),
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp,
                color = colorResource(id = R.color.primary_color),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(modifier = Modifier
            .padding(16.dp)) {
            Text(
                text = stringResource(id = R.string.pet_address),
                fontWeight = FontWeight.Light,
                fontSize = 20.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = AppHelper.HandleNull(AppHelper.selectedPet?.contact?.address?.address1),
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp,
                color = colorResource(id = R.color.primary_color),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        val uriHandler = LocalUriHandler.current

        Button(onClick = { uriHandler.openUri(AppHelper.selectedPet!!.url) } , modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)) {
            Text(text = "Pets Website")
            
        }
    }

}


