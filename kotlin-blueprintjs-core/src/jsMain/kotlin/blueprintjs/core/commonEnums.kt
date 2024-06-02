@file:JsModule("@blueprintjs/core")
@file:Suppress("ConvertObjectToDataObject") // false positive

package blueprintjs.core

/**
 * The four basic intents.
 */
sealed external class Intent {
    object NONE : Intent
    object PRIMARY : Intent
    object SUCCESS : Intent
    object WARNING : Intent
    object DANGER : Intent
}

/** Alignment along the horizontal axis. */
sealed external class Alignment {
    object CENTER : Alignment
    object LEFT : Alignment
    object RIGHT : Alignment
}

/** Boundary of a one-dimensional interval. */
sealed external class Boundary {
    object START : Boundary
    object END : Boundary
}

sealed external class Elevation {
    object ZERO : Elevation
    object ONE : Elevation
    object TWO : Elevation
    object THREE : Elevation
    object FOUR : Elevation
}

sealed external class Position {
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
