@file:JsModule("@blueprintjs/core")
@file:Suppress("ConvertObjectToDataObject") // false positive

package blueprintjs.core

/** Alignment along the horizontal axis. */
sealed external class Alignment {
    object CENTER : Alignment
    object LEFT : Alignment
    object RIGHT : Alignment
}
