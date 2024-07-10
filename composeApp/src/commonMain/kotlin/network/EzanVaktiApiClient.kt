package network

class EzanVaktiApiClient {

    companion object{
        val BASE_URL = "https://ezanvakti.herokuapp.com/"
        val ULKELER = "ulkeler/"
        val SEHIRLER = "sehirler/"
        val ILCELER = "ilceler/"
        val VAKITLER = "vakitler/"
    }

     val client = createHttpClient(BASE_URL)
}