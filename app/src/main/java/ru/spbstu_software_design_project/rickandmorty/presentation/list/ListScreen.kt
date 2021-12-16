package ru.spbstu_software_design_project.rickandmorty.presentation.list

import android.view.ViewGroup
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import com.like.LikeButton
import com.like.OnLikeListener
import ru.spbstu_software_design_project.rickandmorty.R
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import androidx.navigation.NavController
import androidx.paging.compose.LazyPagingItems
import ru.spbstu_software_design_project.rickandmorty.domain.model.Character
import ru.spbstu_software_design_project.rickandmorty.presentation.navigation.Screen

@OptIn(ExperimentalCoilApi::class)
@Composable
fun ListScreen(
    navController: NavController, viewModel: CharactersScreenViewModel = hiltViewModel()
) {
    val charactersState = viewModel.characters.collectAsLazyPagingItems()
    val favouriteCharacters = viewModel.favouriteCharacters.collectAsState()
    val uiState = viewModel.state.collectAsState()

    Scaffold(
        content = {
            when (uiState.value) {
                CharactersScreenViewModel.State.Characters -> {
                    DisplayCards(
                        items = charactersState,
                        navController = navController,
                        viewModel = viewModel
                    )
                }
                CharactersScreenViewModel.State.Favourite -> {
                    DisplayCards(
                        items = favouriteCharacters.value,
                        navController = navController,
                        viewModel = viewModel
                    )
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
            }) {
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
                                        viewModel.toDisplayCharacters()
                                    }
                                })
                            }
                        })
                }
            }
        }
    )
}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun DisplayCards(
    items: LazyPagingItems<Character>,
    navController: NavController,
    viewModel: CharactersScreenViewModel
) {
    val context = LocalContext.current

    LazyColumn {
        items(items) { character ->
            CharacterCard(
                characterCard = character!!,
                likeCharacter = {
                    viewModel.addToFavourite(character)
                },
                unlikeCharacter = {
                    viewModel.replaceFromFavourite(it)
                }
            ) {
                navController.navigate(Screen.DetailScreen.withArgs(it.id.toString()))
            }
        }
    }
}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun DisplayCards(
    items: List<Character>,
    navController: NavController,
    viewModel: CharactersScreenViewModel
) {
    LazyColumn {
        items(items) { character ->
            CharacterCard(
                characterCard = character,
                likeCharacter = {
                    viewModel.addToFavourite(character)
                },
                unlikeCharacter = {
                    viewModel.replaceFromFavourite(it)
                }
            ) {
                navController.navigate(Screen.DetailScreen.withArgs(it.id.toString()))
            }
        }
    }
}