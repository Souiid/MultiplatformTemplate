package com.idrisssouissi.multiplatformtemplate.ui.screens

import androidx.lifecycle.ViewModel
import com.idrisssouissi.multiplatformtemplate.domain.model.UserForm
import com.idrisssouissi.multiplatformtemplate.domain.usecase.ObserveFormUseCase
import kotlinx.coroutines.flow.StateFlow

class DetailViewModel(
    observeFormUseCase: ObserveFormUseCase
) : ViewModel() {

    val form: StateFlow<UserForm> = observeFormUseCase()
}