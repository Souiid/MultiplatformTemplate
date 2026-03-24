package com.idrisssouissi.multiplatformtemplate.domain.usecase

import com.idrisssouissi.multiplatformtemplate.domain.usecase.ValidationResult

class ValidateNameFormUseCase {

    fun execute(lastName: String, firstName: String): ValidationResult {
        val regex = Regex("^[a-zA-Z]+$")

        if (!regex.matches(lastName)) {
            return ValidationResult.Error("Nom invalide")
        }

        if (!regex.matches(firstName)) {
            return ValidationResult.Error("Prénom invalide")
        }

        return ValidationResult.Success
    }
}
