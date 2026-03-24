package com.idrisssouissi.multiplatformtemplate.domain.usecase

sealed class ValidationResult {
    object Success: ValidationResult()
    data class Error(val message: String): ValidationResult()
}