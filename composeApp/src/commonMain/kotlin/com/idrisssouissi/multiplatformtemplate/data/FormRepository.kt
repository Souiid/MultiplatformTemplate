package com.idrisssouissi.multiplatformtemplate.data

import com.idrisssouissi.multiplatformtemplate.domain.model.UserForm
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class FormRepository {

    private val _form = MutableStateFlow(UserForm())
    val form: StateFlow<UserForm> = _form

    fun updateName(firstName: String, lastName: String) {
        _form.value = _form.value.copy(
            firstName = firstName,
            lastName = lastName
        )
    }
}