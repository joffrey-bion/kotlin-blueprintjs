@file:JsModule("@blueprintjs/core")

package blueprintjs.core

import org.w3c.dom.HTMLElement

external interface IRefObject<T : HTMLElement> {
    var current: T?
}
