package com.idrisssouissi.multiplatformtemplate.domain.usecase

class ValidatePasswordUseCase {

    fun execute(password: String): Boolean {
        return password == "hello123"
    }
}