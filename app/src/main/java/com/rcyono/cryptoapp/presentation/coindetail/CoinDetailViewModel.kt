package com.rcyono.cryptoapp.presentation.coindetail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rcyono.cryptoapp.common.Constant.PARAM_COIN_ID
import com.rcyono.cryptoapp.common.Resource
import com.rcyono.cryptoapp.domain.usecase.getcoindetail.GetCoinDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinDetailUseCase: GetCoinDetailUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(CoinDetailState())
    val state: State<CoinDetailState> = _state

    init {
        savedStateHandle.get<String>(PARAM_COIN_ID)?.let { coinId ->
            getCoinDetail(coinId = coinId)
//            getCoinTickers(coinId = coinId)
        }
    }

    private fun getCoinDetail(coinId: String) {
        getCoinDetailUseCase(coinId = coinId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = CoinDetailState(
                        coinDetail = result.data
                    )
                }
                is Resource.Error -> {
                    _state.value = CoinDetailState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = CoinDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

//    private fun getCoinTickers(coinId: String) {
//        getCoinTickersUseCase(coinId = coinId).onEach { result ->
//            when (result) {
//                is Resource.Success -> {
//                    _state.value = CoinDetailState(
//                        coinTickers = result.data
//                    )
//                }
//                is Resource.Error -> {
//                    _state.value = CoinDetailState(
//                        error = result.message ?: "An unexpected error occured"
//                    )
//                }
//                is Resource.Loading -> {
//                    _state.value = CoinDetailState(isLoading = true)
//                }
//            }
//        }.launchIn(viewModelScope)
//    }
}