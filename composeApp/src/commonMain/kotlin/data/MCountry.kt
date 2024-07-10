package data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MCountry(
    @SerialName("UlkeAdi")
    val name:String,
    @SerialName("UlkeAdiEn")
    val enName:String,
    @SerialName("UlkeID")
    val id:String
)
