import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import database.DBFactory
import ui.App

fun MainViewController() = ComposeUIViewController {
    val dao = remember{
        DBFactory().createDatabase().getDao()
    }
    App(dao)
}