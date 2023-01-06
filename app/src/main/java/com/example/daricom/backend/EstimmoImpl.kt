package com.example.daricom.backend

import com.example.daricom.data.EstimmoResult
import javax.inject.Inject
private val conversionTable = mapOf(
    "AB" to 0, "AC" to 1, "AD" to 2,
    "AE" to 3, "AI" to 4, "AK" to 5,
    "AO" to 6, "AP" to 7, "AR" to 8,
    "AS" to 9, "AT" to 10,"AV" to 11,
    "AW" to 12, "AX" to 13,"AY" to 14,
    "AZ" to 15, "BC" to 16, "BD" to 17,
    "BE" to 18, "BH" to 19, "BK" to 20,
    "BL" to 21, "BM" to 22, "BO" to 23,
    "BP" to 24, "BR" to 25, "BS" to 26,
    "BT" to 27, "BV" to 28, "BW" to 29)

private val A_Maison = listOf(0.0,
                            1419.0607130996075,
                            22003.791,
                            124.00865,
                            380.23508,
                            -139.55600657560683,
                            0.744479,
                            10.510937,
                            -27.805205185220355,
                            -164.91108658278432,
                            -0.8445930817257835)
private const val B_Maison = -26300.862647456146

private val A_Appartement = listOf(0.0,
                            11981.57268588179,
                            189188.96480528245,
                            492.7451974352732,
                            -4399.072898557155,
                            -415.9294148094125,
                            -7055.696328457678,
                            157.98110206439185)
private val B_Appartement =  70307.78517292827



open class EstimmoImpl @Inject constructor(): EstimmoUtil {



    override fun estimmo(proprety : String, section : String,  terrain : Float?, surface : Float, piece : Int ): Float {
        val section = convertSection(section)
        val proprety = convertProprety(proprety)

        return if (proprety == 0) {
            estimmoMaison(section, surface, piece, terrain!!)
        } else {
            estimmoAppartement( section, surface, piece)
        }
    }


    private fun convertSection(section: String): Int {
        return conversionTable[section]!!
    }

    private fun convertProprety(proprety: String): Int {
        return if (proprety == "Maison") 0 else 1
    }


    private fun estimmoMaison (section : Int, surface : Float, piece : Int, terrain : Float): Float {
        val Estimation = (B_Maison + A_Maison[0]
        + A_Maison[1]*surface
        + A_Maison[2]* piece
        + A_Maison[3]* terrain
        + A_Maison[4]* section
        + A_Maison[5]*surface*piece
        + A_Maison[6]*surface*terrain
        + A_Maison[7]*surface*section
        + A_Maison[8]*piece*terrain
        + A_Maison[9]*piece*section
        + A_Maison[10]*terrain*section).toFloat()
        return Estimation
    }

    private fun estimmoAppartement ( section : Int, surface : Float, piece: Int ): Float {
        val estimatiom = (B_Appartement + A_Appartement[0]
        + A_Appartement[1]*surface
        + A_Appartement[2]*piece
        + A_Appartement[3]*section
        + A_Appartement[4]*surface*piece
        + A_Appartement[5]*surface*section
        + A_Appartement[6]*piece*section
        + A_Appartement[7]*surface*piece*section).toFloat()
        return estimatiom
    }
}



