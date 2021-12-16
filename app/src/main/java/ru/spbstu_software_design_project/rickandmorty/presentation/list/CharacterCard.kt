package ru.spbstu_software_design_project.rickandmorty.presentation.list

import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.like.LikeButton
import com.like.OnLikeListener
import ru.spbstu_software_design_project.rickandmorty.ui.theme.workSansFamily
import ru.spbstu_software_design_project.rickandmorty.R
import ru.spbstu_software_design_project.rickandmorty.domain.model.Character

@ExperimentalCoilApi
@Composable
fun CharacterCard(
    characterCard: Character,
    likeCharacter: (Character) -> Unit,
    unlikeCharacter: (Character) -> Unit,
    onClickCharacter: (Character) -> Unit
) {
    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable {
                onClickCharacter.invoke(characterCard)
            },
        elevation = 8.dp

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                painter = rememberImagePainter(characterCard.imageUrl),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(12.dp)
                    .size(64.dp)
                    .clip(CircleShape)
            )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(top = 12.dp, start = 4.dp, end = 12.dp, bottom = 12.dp)
            ) {
                Text(
                    text = characterCard.name,
                    color = Color.Black,
                    fontSize = 24.sp,
                    fontFamily = workSansFamily,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = characterCard.location,
                    color = Color.Gray,
                    fontSize = 18.sp,
                    fontFamily = workSansFamily,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(vertical = 2.dp)
                )
            }
            AndroidView(
                modifier = Modifier
                    .padding(12.dp)
                    .align(alignment = Alignment.CenterVertically),
                factory = { context ->
                    LikeButton(context).apply {
                        layoutParams = ViewGroup.LayoutParams(
                            132,
                            132,
                        )
                        setIconSizeDp(32)
                        setAnimationScaleFactor(1f)
                        setLikeDrawable(
                            ContextCompat.getDrawable(
                                context,
                                R.drawable.ic_item_like
                            )
                        )
                        setUnlikeDrawable(
                            ContextCompat.getDrawable(
                                context,
                                R.drawable.ic_item_unlike
                            )
                        )
                        isLiked = characterCard.isLiked
                        setOnLikeListener(object : OnLikeListener {
                            override fun liked(likeButton: LikeButton?) {
                                likeCharacter.invoke(characterCard)
                            }

                            override fun unLiked(likeButton: LikeButton?) {
                                unlikeCharacter.invoke(characterCard)
                            }
                        })
                    }
                })
        }
    }

}