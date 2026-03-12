package com.idrisssouissi.multiplatformtemplate.ui.components.cells

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import com.idrisssouissi.multiplatformtemplate.data.User
import com.idrisssouissi.multiplatformtemplate.data.age
import com.idrisssouissi.multiplatformtemplate.ui.components.AppIcon
import com.idrisssouissi.multiplatformtemplate.ui.components.text.TText
import com.idrisssouissi.multiplatformtemplate.ui.components.text.TTextStyle
import com.idrisssouissi.multiplatformtemplate.ui.theme.Dimens
import com.idrisssouissi.multiplatformtemplate.ui.theme.Dimens.space12
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource

@Composable
fun UserCell(
    user: User,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {

        KamelImage(
            resource = {
                asyncPainterResource("https://testingbot.com/free-online-tools/random-avatar/300")
            },
            contentDescription = null,
            modifier = Modifier
                .size(Dimens.height48)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.onSurfaceVariant),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.width(space12))

        Column(modifier = Modifier.weight(1f)) {
            TText(user.name)
            TText("Age: ${user.age()}", style = TTextStyle.LABEL)
        }

        Icon(
            imageVector = AppIcon.ChevronRight,
            contentDescription = null
        )
    }
}