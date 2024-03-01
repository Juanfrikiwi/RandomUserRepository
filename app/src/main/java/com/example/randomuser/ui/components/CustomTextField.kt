package com.example.randomuser.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SearchTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier,
    enabled: Boolean = true,
    placeholder: @Composable (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    maxLines: Int = 1,
    onClickCloseSearchBar : () -> Unit,
) {
    var textValue = remember {
        mutableStateOf("")
    }
    textValue.value = value
    Column(
        modifier = modifier
    ) {
        Box(modifier = Modifier.shadow(elevation = 0.dp)) {
            TextField(
                modifier = Modifier.fillMaxWidth(),
                enabled = enabled,
                value = textValue.value,
                onValueChange = onValueChange,
                placeholder = placeholder,
                keyboardOptions = keyboardOptions,
                keyboardActions = keyboardActions,
                maxLines = maxLines,
                visualTransformation = visualTransformation,
                textStyle = TextStyle(fontSize = 14.sp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Black,
                    unfocusedIndicatorColor =  Color.LightGray,
                    unfocusedContainerColor =  Color.Transparent,
                    disabledContainerColor =  Color.Transparent,
                ),
                leadingIcon = {
                    Icon(
                        Icons.Outlined.Search,
                        contentDescription = null,
                        modifier = Modifier.size(20.dp).clickable{
                            onClickCloseSearchBar()
                        }
                    )
                },
                trailingIcon = {
                    Icon(
                        Icons.Outlined.Close,
                        contentDescription = null,
                        modifier = Modifier.size(18.dp).clickable{
                            onClickCloseSearchBar()
                        }
                    )
                }
            )
        }
    }
}

@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier,
    enabled: Boolean = true,
    placeholder: @Composable (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    maxLines: Int = 1,
) {
    var textValue = remember {
        mutableStateOf("")
    }
    textValue.value = value
    Column(
        modifier = modifier
    ) {
        Box(modifier = Modifier.shadow(elevation = 0.dp)) {
            TextField(
                modifier = Modifier.fillMaxWidth(),
                enabled = enabled,
                value = textValue.value,
                onValueChange = onValueChange,
                placeholder = placeholder,
                keyboardOptions = keyboardOptions,
                keyboardActions = keyboardActions,
                maxLines = maxLines,
                visualTransformation = visualTransformation,
                textStyle = TextStyle(fontSize = 18.sp, textAlign = TextAlign.Center),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Black,
                    unfocusedIndicatorColor =  Color.LightGray,
                    unfocusedContainerColor =  Color.Transparent,
                    disabledContainerColor =  Color.Transparent,
                ),
            )
        }
    }
}