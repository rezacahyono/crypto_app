package com.rcyono.cryptoapp.domain.usecase.getcoindetail

import com.rcyono.cryptoapp.common.Resource
import com.rcyono.cryptoapp.domain.model.CoinDetail
import com.rcyono.cryptoapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinDetailUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coinDetail = repository.getCoinDetail(coinId = coinId)
            val coinTickers = repository.getCoinTickers(coinId = coinId)
            val coin = CoinDetail(
                coinDetail.id,
                coinDetail.name,
                coinDetail.description,
                coinDetail.symbol,
                coinDetail.rank,
                coinDetail.isActive,
                coinDetail.tags?.map { it.name },
                coinDetail.team,
                coinTickers.quotes
            )
            emit(Resource.Success(coin))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An Unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error("Could't reach server, Please check your internet connection"))
        }
    }
}