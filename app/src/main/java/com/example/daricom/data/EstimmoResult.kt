package com.example.daricom.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

sealed interface EstimmoResult : Parcelable {
    @Parcelize
    object Empty : EstimmoResult

    @Parcelize
    data class Estimated(val int: Int) : EstimmoResult
}