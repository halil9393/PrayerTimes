package viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import repository.NetworkRepository

class HomeViewModel(private val networkRepository: NetworkRepository) : ViewModel() {

     fun getCountries(){
        viewModelScope.launch {
            networkRepository.getCountriess().collect{

            }
        }
    }

    fun getCities(countryId:String){
        viewModelScope.launch {
            networkRepository.getCities(countryId).collect{

            }
        }
    }

    fun getDistricts(cityId:String){
        viewModelScope.launch {
            networkRepository.getDistricts(cityId).collect{

            }
        }
    }

    fun getPrayerTimes(districtId:String){
        viewModelScope.launch {
            networkRepository.getPrayerTimes(districtId).collect{

            }
        }
    }

    fun getPrayerTimesFromDB(){
        viewModelScope.launch {
            networkRepository.getPrayerTimesFromDB().collect{
                it.forEach {
                    println(it)
                }
            }

        }
    }

    fun insert(){
        viewModelScope.launch {
            networkRepository.insert()
        }
    }
}