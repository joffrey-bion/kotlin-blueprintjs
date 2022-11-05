@file:JsModule("@blueprintjs/core")

package blueprintjs.core

import react.State
import react.ReactElement

external interface IDividerProps : IProps {
    /**
     * HTML tag to use for element.
     *
     * @default "div"
     */
    var tagName: Any?
}

open external class Divider : AbstractPureComponent2<IDividerProps, State> {
    override fun render(): ReactElement<IDividerProps>
}
