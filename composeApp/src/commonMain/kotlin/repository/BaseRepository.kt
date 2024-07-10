package repository

import io.ktor.client.plugins.HttpRequestTimeoutException
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.client.statement.readText
import io.ktor.http.isSuccess
import io.ktor.utils.io.errors.IOException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import util.Outcome

open class BaseRepository {

    fun <T> result(call: suspend () -> HttpResponse, deserialize: suspend (String) -> T): Flow<Outcome<T?>> = channelFlow  {
        send(Outcome.PROGRESS)
        try {
            val c = call()
            if(c.status.isSuccess()){
                val responseBody = c.bodyAsText()
                val responseData = deserialize(responseBody)
                send(Outcome.SUCCESS(responseData))
            }else{
                val errorBody = c.bodyAsText()
                send(Outcome.FAILURE(getErrorMessage(c.status.value), c.status.value))

            }

        } catch (e: HttpRequestTimeoutException) {
            e.printStackTrace()
            send(Outcome.FAILURE(e.message ?: "Something went wrong",0))
        } catch (e: IOException) {
            e.printStackTrace()
            send(Outcome.FAILURE("Please check your network connection",0))
        } catch (e: Exception) {
            e.printStackTrace()
            send(Outcome.FAILURE("Something went wrong",1))
        }

    }

    private fun getErrorMessage(httpCode: Int): String {
        return when (httpCode) {
            401 -> "UNAUTHORIZED"
            404 -> "NOT_FOUND"
            500 -> "INTERNAL_SERVER_ERROR"
            else -> "$httpCode - Something went wrong"
        }
    }
}