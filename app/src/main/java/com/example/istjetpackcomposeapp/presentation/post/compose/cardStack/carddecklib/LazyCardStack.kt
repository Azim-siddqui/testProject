package sharechat.library.composeui.common.carddecklib

import android.util.Log
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.consumePositionChange
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import com.example.istjetpackcomposeapp.presentation.post.compose.cardStack.Reward
import com.example.istjetpackcomposeapp.presentation.post.compose.cardStack.UserGift
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.combine


/**
 * This card deck composable is responsible for the swipe enabled animating cards which will give user to swipe through the cards to the left
 * direction and it will swipe animating the view. One of it's core feature is to lazily load the view in to the view hierarchy.
 * @param modifier Modifier to style the container of the card deck
 * @param items items to show
 * @param maxElements Max cards needs to be shown
 * @param cornerShape Corner shape for the container box
 * @param elevation Container elevation to look good
 * @param verticalArrangement Vertical Arrangement to arrange the deck of cards
 * @param horizontalAlignment Horizontal alignment to align the deck of cards
 * @param content Content then needs to be placed into the container
 * @param isDragEnable It will just enable the drag gesture or disable the drag gesture.
 * @author Debdut Saha
 */
@ExperimentalMaterialApi
@Composable
fun <T> LazyCardStack(
    modifier: Modifier = Modifier,
    items: MutableList<T>,
    maxElements: Int = 3,
    cornerShape: RoundedCornerShape = CardStackDefaults.CornerShape,
    elevation: Dp = CardStackDefaults.Elevation,
    verticalArrangement: Arrangement.HorizontalOrVertical = CardStackDefaults.VerticalArrangement,
    horizontalAlignment: Alignment.Horizontal = CardStackDefaults.HorizontalAlignment,
    dragState: DragManager? = null,
    isDragEnable: Boolean = true,
    scope: CoroutineScope = rememberCoroutineScope(),
    content: @Composable (T) -> Unit
) {
    val dragManager = dragState ?: rememberDragManager(
        size = items.size,
        maxCards = maxElements,
        scope = scope
    )
    Column(
        modifier = modifier,
        verticalArrangement = verticalArrangement,
        horizontalAlignment = horizontalAlignment
    ) {
        BoxWithConstraints(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .fillMaxHeight(0.8f)
                .pointerInput(Unit) {
                    detectDragGestures(
                        onDragEnd = {
                            if (isDragEnable.not()) return@detectDragGestures
                            dragManager.onDragEnd(
                                index = dragManager.topDeckIndex.value,
                                selectedIndex = dragManager.topDeckIndex.value
                            )
                        },
                        onDrag = { change, dragAmount ->
                            if (isDragEnable.not()) return@detectDragGestures
                            change.consumePositionChange()
                            if (dragAmount.x > 0 || dragManager.topDeckIndex.value == 0) {
                                dragManager.dragRight(
                                    dragAmount = dragAmount
                                )
                            } else {
                                dragManager.dragLeft(
                                    dragAmount = dragAmount
                                )
                            }
                        }
                    )
                },
            contentAlignment = Alignment.Center
        ) {
            val density = LocalDensity.current
            LaunchedEffect(key1 = Unit, block = {
                dragManager.setBoxWidth(with(density) { maxWidth.value.dp.toPx() })
            })
            val visibleIndexRange =
                (items.size - 1 downTo (dragManager.topDeckIndex.value - maxElements).coerceAtLeast(
                    0
                )).map { it }


//            val combinedList = joined(items, primaryItems)
//            Log.i("joinList", "LazyCardStack: $combinedList")


            Log.i("size", "LazyCardStack: ${items.size}")
            items.forEachIndexed { index, item ->
                if (dragManager.listOfDragState.isNotEmpty()) {
                    var swipeState: DragState? = null
                    if (index < items.size - 1) {
                        swipeState = dragManager.listOfDragState[index]
                    }
                    if (index in visibleIndexRange) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .graphicsLayer {
                                    scaleY = swipeState?.scale?.value ?: 1f
                                    scaleX = swipeState?.scale?.value ?: 1f
                                    translationX = swipeState?.offsetX?.value ?: 0f
                                }
                                .shadow(elevation = elevation, shape = cornerShape),
                        ) {
                            Box(modifier = Modifier.fillMaxSize()) {
                                Log.i("xyz", "LazyCardStack: $item")

                                if(item is Reward){
                                    content(
                                        item
                                    )
                                }
                            }
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .alpha(alpha = swipeState?.opacity?.value ?: 1f)
                                    .background(
                                        color = Color.White,
                                        shape = cornerShape
                                    )
                            )
                        }
                    }
                }
            }

        }


    }

}

//fun <T, U> joined(first: List<T>, second: List<U>): List<Any> {
//    val list: MutableList<Any> = ArrayList();
//    list.addAll(first.map { i -> i as Any })
//    list.addAll(second.map { i -> i as Any })
//    return list
//}






