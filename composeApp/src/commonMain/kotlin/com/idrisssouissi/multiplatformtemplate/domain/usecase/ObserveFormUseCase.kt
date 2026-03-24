package com.idrisssouissi.multiplatformtemplate.domain.usecase

import com.idrisssouissi.multiplatformtemplate.data.FormRepository
import com.idrisssouissi.multiplatformtemplate.domain.model.UserForm
import kotlinx.coroutines.flow.StateFlow

class ObserveFormUseCase(
    private val repository: FormRepository
) {
    operator fun invoke(): StateFlow<UserForm> {
        return repository.form
    }
}