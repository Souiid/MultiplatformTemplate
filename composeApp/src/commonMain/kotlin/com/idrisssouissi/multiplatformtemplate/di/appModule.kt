package com.idrisssouissi.multiplatformtemplate.di

import com.idrisssouissi.multiplatformtemplate.domain.usecase.ValidatePasswordUseCase
import com.idrisssouissi.multiplatformtemplate.ui.screens.HomeViewModel
import org.koin.dsl.module


val appModule = module {
    factory { HomeViewModel(get()) }

    factory { ValidatePasswordUseCase() }
}