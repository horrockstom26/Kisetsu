package dev.lelonio.square.ui.theme

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import dev.lelonio.square.R

/**
 * The app's typeface: Spotify Mix (Regular, Medium, Bold).
 */
val SpotifyMix = FontFamily(
    Font(R.font.spotifymix_regular, weight = FontWeight.Normal),
    Font(R.font.spotifymix_medium, weight = FontWeight.Medium),
    Font(R.font.spotifymix_medium, weight = FontWeight.SemiBold),
    Font(R.font.spotifymix_bold, weight = FontWeight.Bold),
)

/** Kept for compatibility; the app uses [SpotifyMix] everywhere. */
val Inter = SpotifyMix

/**
 * Display/artist-name face: uses Spotify Mix Bold throughout the app.
 */
val InstrumentSerif = FontFamily(
    Font(R.font.spotifymix_bold, weight = FontWeight.Normal),
    Font(R.font.spotifymix_bold, weight = FontWeight.Medium),
    Font(R.font.spotifymix_bold, weight = FontWeight.SemiBold),
    Font(R.font.spotifymix_bold, weight = FontWeight.Bold),
)

/**
 * [content] with the system font scale held at [max] at most.
 *
 * For chrome of a fixed height: the tab bar and the mini player keep their size
 * whatever the font setting, so text there that grew with it was cut off. Like
 * iOS's tab bar, it follows the setting a little way and then stops.
 */
@androidx.compose.runtime.Composable
fun CappedFontScale(max: Float = 1.15f, content: @androidx.compose.runtime.Composable () -> Unit) {
    val density = androidx.compose.ui.platform.LocalDensity.current
    if (density.fontScale <= max) {
        content()
    } else {
        androidx.compose.runtime.CompositionLocalProvider(
            androidx.compose.ui.platform.LocalDensity provides
                androidx.compose.ui.unit.Density(density.density, max),
            content = content,
        )
    }
}
