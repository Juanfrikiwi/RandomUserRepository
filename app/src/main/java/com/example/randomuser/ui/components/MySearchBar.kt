package com.example.randomuser.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.example.randomuser.R
import com.example.randomuser.data.models.Results

@Composable
fun MySearchBar(
    list: List<Results>?,
    callbackSearchList: (List<Results>) -> Unit,
    callbackCloseButton: () -> Unit,
) {
    var textSearch by remember {
        mutableStateOf(mutableStateOf(""))
    }

    var userList by remember {
        mutableStateOf(mutableStateOf(list))
    }
    Row {
        Column(modifier = Modifier.weight(7f)) {
            SearchTextField(
                value = textSearch.value,
                placeholder = {
                    Text(
                        text = stringResource(R.string.search_by_name_surname_email),
                        fontSize = 12.sp
                    )
                },
                onValueChange = {
                    textSearch.value = it
                    if (textSearch.value.isNotEmpty()) {
                        callbackSearchList(
                            filterUserListByNameAndSurnameOrEmail(
                                textSearch.value,
                                list = userList.value
                            )
                        )
                    }else{
                        callbackSearchList(
                            filterUserListByNameAndSurnameOrEmail(
                                "",
                                list = userList.value
                            )
                        )
                    }
                },
                onClickCloseSearchBar = {
                   callbackCloseButton()
                },
                modifier = Modifier
            )
        }
    }
}

fun filterUserListByNameAndSurnameOrEmail(text: String, list: List<Results>?): List<Results> {
    var listUsers: MutableList<Results> = arrayListOf()
    if (list != null) {
        listUsers =
            list.filter {
                val nameAndSurname = it.name.first.lowercase()+ " "+it.name.last.lowercase()
                nameAndSurname.contains(text.lowercase()) || it.email.lowercase().contains(
                    text.lowercase()
                )
            }.toMutableList()
    }
    return listUsers as ArrayList<Results>
}