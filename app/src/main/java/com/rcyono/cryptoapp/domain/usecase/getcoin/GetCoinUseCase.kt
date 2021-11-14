package com.rcyono.cryptoapp.domain.usecase.getcoin

import com.rcyono.cryptoapp.common.Resource
import com.rcyono.cryptoapp.data.remote.dto.coin.toCoin
import com.rcyono.cryptoapp.domain.model.Coin
import com.rcyono.cryptoapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coin = repository.getCoin().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coin))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "An Unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error<List<Coin>>("Could't reach server, Please check your internet connection"))
        }
    }
}