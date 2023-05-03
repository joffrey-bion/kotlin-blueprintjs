@file:JsModule("@blueprintjs/core")

package blueprintjs.core

/**
 * The four basic intents.
 */
external enum class Intent {
    NONE,
    PRIMARY,
    SUCCESS,
    WARNING,
    DANGER
}

/** Alignment along the horizontal axis. */
external enum class Alignment {
    CENTER,
    LEFT,
    RIGHT
}

/** Boundary of a one-dimensional interval. */
external enum class Boundary {
    START,
    END,
}

external enum class Elevation {
    ZERO,
    ONE,
    TWO,
    THREE,
    FOUR
}

external enum class Position {
    BOTTOM,
    BOTTOM_LEFT,
    BOTTOM_RIGHT,
    LEFT,
    LEFT_BOTTOM,
    LEFT_TOP,
    RIGHT,
    RIGHT_BOTTOM,
    RIGHT_TOP,
    TOP,
    TOP_LEFT,
    TOP_RIGHT,
}
