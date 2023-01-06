package com.example.daricom.backend

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class EstimmoModule {
    @Binds
    abstract fun bindEstimmoUtil(estimmoImpl: EstimmoImpl): EstimmoUtil

}