package com.idrisssouissi.multiplatformtemplate.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.idrisssouissi.multiplatformtemplate.domain.model.UserForm
import com.idrisssouissi.multiplatformtemplate.domain.usecase.ObserveFormUseCase
import com.idrisssouissi.multiplatformtemplate.domain.usecase.UpdateNameUseCase
import com.idrisssouissi.multiplatformtemplate.domain.usecase.ValidateNameFormUseCase
import com.idrisssouissi.multiplatformtemplate.domain.usecase.ValidationResult
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val validateNameFormUseCase: ValidateNameFormUseCase,
    private val updateNameUseCase: UpdateNameUseCase,
    observeFormUseCase: ObserveFormUseCase
) : ViewModel() {

    val form: StateFlow<UserForm> = observeFormUseCase()

    private val _event = MutableSharedFlow<ValidationResult>()
    val event = _event

    fun onNextClicked(firstName: String, lastName: String) {

        val result = validateNameFormUseCase.execute(firstName, lastName)

        if (result is ValidationResult.Success) {
            updateNameUseCase(firstName, lastName)
        }

        viewModelScope.launch {
            _event.emit(result)
        }
    }
}