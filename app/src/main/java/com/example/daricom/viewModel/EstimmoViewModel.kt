package com.example.daricom.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.daricom.backend.EstimmoUtil
import com.example.daricom.data.EstimmoResult
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
const val STATE_KEY_RESULT = "state_key_result"

@HiltViewModel
class EstimmoViewModel @Inject constructor(
    state: SavedStateHandle,
    private val estimmoUtil: EstimmoUtil
): ViewModel() {

    private val _estimmoResult: MutableLiveData<EstimmoResult> = state.getLiveData(STATE_KEY_RESULT, EstimmoResult.Empty)
    val estimmoResult: LiveData<EstimmoResult> = _estimmoResult

    fun estimmo(proprety : String, section : String, terrain : Float?, surface : Float?, piece : Int?) {
        try {
            if (surface != null && piece != null && (terrain != null || proprety == "Appartement")) {
                _estimmoResult.value = EstimmoResult.Estimated(estimmoUtil.estimmo(proprety, section, terrain, surface, piece))
            }
            else {
                throw IllegalArgumentException("Surface, piece et/ou terrain non renseigné")
            }
        }
        catch (e:java.lang.IllegalArgumentException){
            _estimmoResult.value = EstimmoResult.Failed(e.message.toString())
        }
    }
}