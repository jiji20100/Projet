package com.example.daricom.backend

import javax.inject.Inject
private val A_Maison = listOf(0.0F,
                            1419.0607130996075F,
                            22003.791F,
                            124.00865F,
                            380.23508F,
                            (-139.55600657560683).toFloat(),
                            0.744479F,
                            10.510937F,
                            (-27.805205185220355).toFloat(),
                            (-164.91108658278432).toFloat(),
                            (-0.8445930817257835).toFloat())
private val B_Maison = -26300.862647456146F

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
    override fun Estimmo(): Float {
        return 245.0F
    }
    }

    private fun EstimmoMaison (section : Int,  terrain : Float, surface : Float, piece : Int): Float {
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
    private fun EstimmoAppartement ( surface : Float, piece: Int, section : Int ): Float {
        val Estimatiom = (B_Appartement + A_Appartement[0]
        + A_Appartement[1]*surface
        + A_Appartement[2]*piece
        + A_Appartement[3]*section
        + A_Appartement[4]*surface*piece
        + A_Appartement[5]*surface*section
        + A_Appartement[6]*piece*section
        + A_Appartement[7]*surface*piece*section).toFloat()
        return Estimatiom



    }