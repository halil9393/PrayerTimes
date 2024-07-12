import androidx.compose.ui.window.ComposeUIViewController
import di.appModule
import org.koin.core.context.startKoin
import ui.App

fun MainViewController() = ComposeUIViewController {

    startKoin {
        modules(appModule())
    }
    App()

    /*KoinApplication(application = {
        init()
    }) {
        App()
    }*/
}