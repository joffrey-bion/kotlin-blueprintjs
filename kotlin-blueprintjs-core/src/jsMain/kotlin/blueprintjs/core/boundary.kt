@file:JsModule("@blueprintjs/core")
@file:Suppress("ConvertObjectToDataObject") // false positive

package blueprintjs.core

/** Boundary of a one-dimensional interval. */
sealed external class Boundary {
    object START : Boundary
    object END : Boundary
}
