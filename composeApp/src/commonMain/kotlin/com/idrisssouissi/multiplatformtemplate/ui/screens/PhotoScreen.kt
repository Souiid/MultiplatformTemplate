package com.idrisssouissi.multiplatformtemplate.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.idrisssouissi.multiplatformtemplate.ui.components.AppIcon
import com.idrisssouissi.multiplatformtemplate.ui.components.button.TButton
import com.idrisssouissi.multiplatformtemplate.ui.components.button.TButtonType
import io.github.ismoy.imagepickerkmp.domain.config.CameraCaptureConfig
import io.github.ismoy.imagepickerkmp.domain.config.CropConfig
import io.github.ismoy.imagepickerkmp.domain.config.ImagePickerConfig
import io.github.ismoy.imagepickerkmp.domain.models.PhotoResult
import io.github.ismoy.imagepickerkmp.presentation.ui.components.GalleryPickerLauncher
import io.github.ismoy.imagepickerkmp.presentation.ui.components.ImagePickerLauncher
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PhotoScreen() {

    var showCamera by remember { mutableStateOf(false) }
    var showGallery by remember { mutableStateOf(false) }
    var showSheet by remember { mutableStateOf(false) }

    var photo by remember { mutableStateOf<PhotoResult?>(null) }

    val sheetState = rememberModalBottomSheetState()

    val cameraCaptureConfig = remember {
        CameraCaptureConfig(
            cropConfig = CropConfig(
                enabled = true,
                circularCrop = true,
                squareCrop = false
            )
        )
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Box(
                modifier = Modifier.size(120.dp),
                contentAlignment = Alignment.Center
            ) {

                Box(
                    modifier = Modifier
                        .matchParentSize()
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.surfaceVariant)
                        .clickable { showSheet = true },
                    contentAlignment = Alignment.Center
                ) {

                    if (photo != null) {
                        val uri = photo!!.uri
                        val imageUri =
                            if (uri.startsWith("file://")) uri else "file://$uri"

                        KamelImage(
                            resource = asyncPainterResource(imageUri),
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                    } else {
                        Icon(
                            imageVector = AppIcon.Person,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.size(48.dp)
                        )
                    }
                }

                Box(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .offset(x = -2.dp, y = (3).dp)
                        .size(28.dp)
                        .shadow(4.dp, CircleShape)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.primary),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = AppIcon.Create,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onPrimary,
                        modifier = Modifier.size(16.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text("Ajouter une photo")
        }

        if (showCamera) {
            ImagePickerLauncher(
                config = ImagePickerConfig(
                    onPhotoCaptured = {
                        photo = it
                        showCamera = false
                    },
                    cameraCaptureConfig = cameraCaptureConfig,
                    onDismiss = { showCamera = false },
                    onError = { showCamera = false }
                )
            )
        }

        if (showGallery) {
            GalleryPickerLauncher(
                onPhotosSelected = {
                    photo = it.firstOrNull()
                    showGallery = false
                },
                includeExif = true,
                cameraCaptureConfig = cameraCaptureConfig,
                onDismiss = { showGallery = false },
                onError = { showGallery = false },
                allowMultiple = false
            )
        }
    }

    if (showSheet) {
        ModalBottomSheet(
            onDismissRequest = { showSheet = false },
            sheetState = sheetState,
            containerColor = MaterialTheme.colorScheme.onPrimary
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(3.dp)
            ) {

                TButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Prendre une photo",
                    isTextAlignStart = true,
                    type = TButtonType.TEXT,
                    onClick = {
                        showSheet = false
                        showCamera = true
                    }
                )

                TButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Choisir dans la galerie",
                    isTextAlignStart = true,
                    type = TButtonType.TEXT,
                    onClick = {
                        showSheet = false
                        showGallery = true
                    }
                )

                if (photo != null) {
                    TButton(
                        modifier = Modifier.fillMaxWidth(),
                        isTextAlignStart = true,
                        text = "Supprimer la photo",
                        type = TButtonType.TEXT_NEGATIVE,
                        onClick = {
                            photo = null
                            showSheet = false
                        }
                    )
                }
            }
        }
    }
}
