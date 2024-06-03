@file:JsModule("@blueprintjs/core")
@file:Suppress("ConvertObjectToDataObject") // false positive

package blueprintjs.core

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
