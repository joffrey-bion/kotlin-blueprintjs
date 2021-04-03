@file:JsModule("@blueprintjs/core")

package blueprintjs.core

import react.RState
import react.ReactElement

external interface IDividerProps : IProps {
    /**
     * HTML tag to use for element.
     *
     * @default "div"
     */
    var tagName: Any?
}

open external class Divider : AbstractPureComponent2<IDividerProps, RState> {
    override fun render(): ReactElement
}
