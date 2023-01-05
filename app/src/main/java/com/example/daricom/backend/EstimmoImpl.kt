package com.example.daricom.backend

import javax.inject.Inject

open class EstimmoImpl @Inject constructor(): EstimmoUtil {
    override fun Estimmo(): String {
        return "Estimmo"
    }

}