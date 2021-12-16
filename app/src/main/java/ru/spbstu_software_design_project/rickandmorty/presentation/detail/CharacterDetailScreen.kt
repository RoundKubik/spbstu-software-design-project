package ru.spbstu_software_design_project.rickandmorty.presentation.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import ru.spbstu_software_design_project.rickandmorty.ui.theme.workSansFamily
import ru.spbstu_software_design_project.rickandmorty.R

@OptIn(ExperimentalCoilApi::class)
@Composable
fun DetailScreen(
    id: Int?,
    viewModel: CharacterDetailViewModel = hiltViewModel<CharacterDetailViewModel>().apply {
        load(id)
    },
    navController: NavController
) {
    val character = viewModel.character.collectAsState()

    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize()
            .padding(12.dp),
        elevation = 4.dp

    ) {
        Column {
            Image(
                painter = rememberImagePainter(character.value.imageUrl),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
            )
            Text(
                text = character.value.name,
                color = Color.Black,
                fontSize = 24.sp,
                fontFamily = workSansFamily,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(16.dp)
            )
            Row(modifier = Modifier.padding(horizontal = 16.dp)) {
                Text(
                    text = stringResource(id = R.string.detail_character_status_title),
                    color = Color.Gray,
                    fontSize = 18.sp,
                    fontFamily = workSansFamily,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = character.value.status,
                    color = Color.Gray,
                    fontSize = 18.sp,
                    fontFamily = workSansFamily,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(start = 4.dp)
                )
            }
            Row(modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp)) {
                Text(
                    text = stringResource(id = R.string.detail_character_species_title),
                    color = Color.Gray,
                    fontSize = 18.sp,
                    fontFamily = workSansFamily,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = character.value.species,
                    color = Color.Gray,
                    fontSize = 18.sp,
                    fontFamily = workSansFamily,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(start = 4.dp)
                )
            }
            Row(modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp)) {
                Text(
                    text = stringResource(id = R.string.detail_character_origin_title),
                    color = Color.Gray,
                    fontSize = 18.sp,
                    fontFamily = workSansFamily,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = character.value.origin,
                    color = Color.Gray,
                    fontSize = 18.sp,
                    fontFamily = workSansFamily,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(start = 4.dp)
                )
            }
            Row(
                modifier = Modifier.padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = 8.dp,
                    bottom = 28.dp
                )
            ) {
                Text(
                    text = stringResource(id = R.string.detail_character_gender_title),
                    color = Color.Gray,
                    fontSize = 18.sp,
                    fontFamily = workSansFamily,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = character.value.gender,
                    color = Color.Gray,
                    fontSize = 18.sp,
                    fontFamily = workSansFamily,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(start = 4.dp)
                )
            }

        }

    }
}