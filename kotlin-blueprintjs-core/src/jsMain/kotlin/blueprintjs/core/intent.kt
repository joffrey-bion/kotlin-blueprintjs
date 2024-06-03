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
