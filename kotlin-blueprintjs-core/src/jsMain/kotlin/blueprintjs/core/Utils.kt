@file:JsModule("@blueprintjs/core")

package blueprintjs.core

import react.*

// exported as an object named "Utils" in index.d.ts
external object Utils {
    fun isDarkTheme(element: Any? /* Element | Text | null | undefined */): Boolean

    /**
     * Assign the given ref to a target, either a React ref object or a callback which takes the ref as its first argument.
     */
    fun <T : Any> setRef(refTarget: Ref<T>?, ref: T?)

    fun <T : Any> getRef(ref: Any? /* T | React.RefObject<T> | null */): T?
}
