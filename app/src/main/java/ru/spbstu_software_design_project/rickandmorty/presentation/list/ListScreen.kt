package ru.spbstu_software_design_project.rickandmorty.presentation.list

import android.view.ViewGroup
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import coil.annotation.ExperimentalCoilApi
import com.like.LikeButton
import com.like.OnLikeListener
import ru.spbstu_software_design_project.rickandmorty.R
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items

@OptIn(ExperimentalCoilApi::class)
@Composable
fun ListScreen(viewModel: CharactersScreenViewModel) {
    val charactersState =  viewModel.characters.collectAsLazyPagingItems()

    Scaffold(
        content = {
            LazyColumn {
                items(charactersState) { character ->
                    CharacterCard(
                        characterCard = character!!,
                        likeCharacter = {
                            viewModel.addToFavourite(character)
                        },
                        unlikeCharacter = {
                            viewModel.replaceFromFavourite(it)
                        }
                    )
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                Box {

                    AndroidView(
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
                                setOnLikeListener(object : OnLikeListener {
                                    override fun liked(likeButton: LikeButton?) {
                                        viewModel.loadFavouriteCharacters()
                                    }

                                    override fun unLiked(likeButton: LikeButton?) {
                                        viewModel.loadCharacters()
                                    }
                                })
                            }
                        })
                }
            }
        }
    )
}
