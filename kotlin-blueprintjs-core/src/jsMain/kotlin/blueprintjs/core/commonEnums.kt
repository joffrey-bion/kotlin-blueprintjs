@file:JsModule("@blueprintjs/core")

package blueprintjs.core

/**
 * The four basic intents.
 */
external sealed class Intent {
    object NONE : Intent
    object PRIMARY : Intent
    object SUCCESS : Intent
    object WARNING : Intent
    object DANGER : Intent
}

/** Alignment along the horizontal axis. */
external sealed class Alignment {
    object CENTER : Alignment
    object LEFT : Alignment
    object RIGHT : Alignment
}

/** Boundary of a one-dimensional interval. */
external sealed class Boundary {
    object START : Boundary
    object END : Boundary
}

external sealed class Elevation {
    object ZERO : Elevation
    object ONE : Elevation
    object TWO : Elevation
    object THREE : Elevation
    object FOUR : Elevation
}

external sealed class Position {
    object BOTTOM : Position
    object BOTTOM_LEFT : Position
    object BOTTOM_RIGHT : Position
    object LEFT : Position
    object LEFT_BOTTOM : Position
    object LEFT_TOP : Position
    object RIGHT : Position
    object RIGHT_BOTTOM : Position
    object RIGHT_TOP : Position
    object TOP : Position
    object TOP_LEFT : Position
    object TOP_RIGHT : Position
}
