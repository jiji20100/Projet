package com.example.daricom.backend
    /** *
     * Returns estimated price of a property
     * @param [property] type of property
     * @param [surface] surface of the property
     * @param [section] section of the property
     * @param [piece] number of rooms of the property
     * return [price] estimated price of the property
     */

interface EstimmoUtil {

    fun estimmo(proprety : String, section : String, terrain : Float?, surface : Float, piece : Int): Float
}
