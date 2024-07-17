package repository

import data.MCity
import data.MCountry
import data.MDay
import data.MDistrict
import database.AppDatabase
import database.MDayDao
import database.PreferencesDataStore
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import kotlinx.coroutines.flow.Flow
import kotlinx.serialization.json.Json
import network.EzanVaktiApiClient

class NetworkRepository(private val ezanVaktiApiClient: HttpClient, private val mDayDao: MDayDao, private val preferencesDataStore: PreferencesDataStore) : BaseRepository(){

    suspend fun getCountriess() = result(
        call = { ezanVaktiApiClient.get(EzanVaktiApiClient.ULKELER) },
        deserialize = { responseBody ->
            Json.decodeFromString<MutableList<MCountry>>(responseBody)
        })

    suspend fun getCities(countryId:String) = result(
        call = {ezanVaktiApiClient.get("${EzanVaktiApiClient.SEHIRLER}/$countryId")},
        deserialize = { responseBody ->
            Json.decodeFromString<MutableList<MCity>>(responseBody)
        }
    )

    suspend fun getDistricts(cityId:String) = result(
        call = {ezanVaktiApiClient.get("${EzanVaktiApiClient.ILCELER}/$cityId")},
        deserialize = { responseBody ->
            Json.decodeFromString<MutableList<MDistrict>>(responseBody)
        }
    )

    suspend fun getPrayerTimes(districtId:String) = result(
        call = {ezanVaktiApiClient.get("${EzanVaktiApiClient.VAKITLER}/$districtId")},
        deserialize = { responseBody ->
            Json.decodeFromString<MutableList<MDay>>(responseBody)
        }
    )

    suspend fun getPrayerTimesFromDB(): Flow<List<MDay>> {
        //return appDatabase.getDao().getAllMDay()
        return mDayDao.getAllMDay()
    }

    suspend fun getValueFromPreferences(key : String) : Flow<String?>{
        return preferencesDataStore.getString(key,null)
    }

    suspend fun setValueToPreferences(key : String, value : String) {
        preferencesDataStore.setString(key,value)
    }

    suspend fun insert(){
        val mDayList = listOf(
            MDay(Aksam = "123"),
            MDay(Aksam = "345"),
            MDay(Aksam = "678")
        )

        mDayList.forEach {
            //appDatabase.getDao().insert(it)
            mDayDao.insert(it)
        }

    }

}