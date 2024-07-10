package data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MCity(
    @SerialName("SehirAdi")
    val name:String,
    @SerialName("SehirAdiEn")
    val enName:String,
    @SerialName("SehirID")
    val id:String
)