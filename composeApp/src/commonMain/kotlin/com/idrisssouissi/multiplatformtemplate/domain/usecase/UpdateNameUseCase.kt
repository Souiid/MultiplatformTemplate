package com.idrisssouissi.multiplatformtemplate.domain.usecase

import com.idrisssouissi.multiplatformtemplate.data.FormRepository

class UpdateNameUseCase(
    private val repository: FormRepository
) {
    operator fun invoke(
        firstName: String,
        lastName: String
    ) {
        repository.updateName(firstName, lastName)
    }
}