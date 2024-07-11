package data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MDay(
    @PrimaryKey(autoGenerate = true) val id:Int = 0,
    val Aksam: String? = null,
    val AyinSekliURL: String? = null,
    val GreenwichOrtalamaZamani: Int?= null,
    val Gunes: String?= null,
    val GunesBatis: String?= null,
    val GunesDogus: String?= null,
    val HicriTarihKisa: String?= null,
    val HicriTarihKisaIso8601: String?= null,
    val HicriTarihUzun: String?= null,
    val HicriTarihUzunIso8601: String?= null,
    val Ikindi: String?= null,
    val Imsak: String?= null,
    val KibleSaati: String?= null,
    val MiladiTarihKisa: String?= null,
    val MiladiTarihKisaIso8601: String?= null,
    val MiladiTarihUzun: String?= null,
    val MiladiTarihUzunIso8601: String?= null,
    val Ogle: String?= null,
    val Yatsi: String? = null
)