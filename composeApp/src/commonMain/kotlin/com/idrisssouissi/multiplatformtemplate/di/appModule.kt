package com.idrisssouissi.multiplatformtemplate.di

import com.idrisssouissi.multiplatformtemplate.data.FormRepository
import com.idrisssouissi.multiplatformtemplate.domain.usecase.ObserveFormUseCase
import com.idrisssouissi.multiplatformtemplate.domain.usecase.UpdateNameUseCase
import com.idrisssouissi.multiplatformtemplate.domain.usecase.ValidateNameFormUseCase
import com.idrisssouissi.multiplatformtemplate.ui.screens.DetailViewModel
import com.idrisssouissi.multiplatformtemplate.ui.screens.HomeViewModel
import org.koin.dsl.module


val appModule = module {

    single { FormRepository() }

    factory { ValidateNameFormUseCase() }
    factory { UpdateNameUseCase(get()) }
    factory { ObserveFormUseCase(get()) }

    factory { HomeViewModel(get(), get(), get()) }
    factory { DetailViewModel(get()) }
}