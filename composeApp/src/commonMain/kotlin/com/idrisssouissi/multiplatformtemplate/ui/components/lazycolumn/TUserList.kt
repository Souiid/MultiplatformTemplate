package com.idrisssouissi.multiplatformtemplate.ui.components.lazycolumn

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.idrisssouissi.multiplatformtemplate.data.User
import com.idrisssouissi.multiplatformtemplate.ui.components.cells.UserCell


@Composable
fun TUserList(
    users: List<User>,
    onUserClick: (User) -> Unit = {}
) {

    LazyColumn {
        items(
            items = users,
            key = { user -> user.userID }
        ) { user ->
            UserCell(
                user = user,
                onClick = { onUserClick(user) }
            )
        }
    }
}