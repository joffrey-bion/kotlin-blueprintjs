@file:JsModule("@blueprintjs/core")
@file:Suppress("ConvertObjectToDataObject") // false positive

package blueprintjs.core

sealed external class Elevation {
    object ZERO : Elevation
    object ONE : Elevation
    object TWO : Elevation
    object THREE : Elevation
    object FOUR : Elevation
}
