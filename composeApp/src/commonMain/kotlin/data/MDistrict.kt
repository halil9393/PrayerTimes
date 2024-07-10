package data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MDistrict(
    @SerialName("IlceAdi")
    val name:String,
    @SerialName("IlceAdiEn")
    val enName:String,
    @SerialName("IlceID")
    val id:String
)