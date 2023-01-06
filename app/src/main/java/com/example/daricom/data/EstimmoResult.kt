package com.example.daricom.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
/** 
    * Data class for the result of the estimation of the price of a property
 */

sealed interface EstimmoResult : Parcelable {
    @Parcelize
    object Empty : EstimmoResult

    @Parcelize
    data class Estimated(val float: Float) : EstimmoResult

    @Parcelize
    data class Failed(val message: String) : EstimmoResult
}
