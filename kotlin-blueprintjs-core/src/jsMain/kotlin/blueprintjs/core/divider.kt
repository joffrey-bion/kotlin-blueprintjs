@file:JsModule("@blueprintjs/core")

package blueprintjs.core

import react.*
import react.dom.html.*
import web.html.*

external interface DividerProps : PropsWithClassName, HTMLAttributes<HTMLElement> {
    /**
     * HTML tag to use for element.
     *
     * @default "div"
     */
    var tagName: String? // keyof JSX.IntrinsicElements
}

/**
 * Divider component.
 *
 * https://blueprintjs.com/docs/#core/components/divider
 */
open external class Divider : AbstractPureComponent<DividerProps, State> {
    override fun render(): ReactElement<DividerProps>
}
