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

    fun Esttimmo() {
        _estimmoResult.value = EstimmoResult.Estimated(0)
    }

}