package com.idrisssouissi.multiplatformtemplate.ui.screens

import androidx.lifecycle.ViewModel
import com.idrisssouissi.multiplatformtemplate.domain.usecase.ValidatePasswordUseCase

class HomeViewModel(
    private val validatePasswordUseCase: ValidatePasswordUseCase
): ViewModel() {

    fun onNextClicked(password: String): Boolean {
        return validatePasswordUseCase.execute(password)
    }
}